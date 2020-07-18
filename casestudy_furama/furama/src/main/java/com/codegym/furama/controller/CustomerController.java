package com.codegym.furama.controller;

import com.codegym.furama.entity.Customer;
import com.codegym.furama.service.CustomerService;
import com.codegym.furama.service.TypeOfCustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Controller
public class CustomerController {

    @Autowired
    CustomerService customerService;

    @Autowired
    TypeOfCustomerService typeOfCustomerService;

    @GetMapping("/add_customer")
    public String goAddCustomer(Model model) {
        model.addAttribute("customer", new Customer());
        model.addAttribute("typeOfCustomerList", typeOfCustomerService.getAllTypeOfCustomer());
        return "customer/add_customer";
    }

    @PostMapping("/add_customer")
    public String addCustomer(@Valid @ModelAttribute("customer") Customer customer, BindingResult bindingResult, Model model) {

//        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
//
//        customer.setStartDate(new Date());
        new Customer().validate(customer, bindingResult);
        if (bindingResult.hasErrors()) {
            model.addAttribute("typeOfCustomerList", typeOfCustomerService.getAllTypeOfCustomer());
            return "customer/add_customer";
        } else {
            customerService.addCustomer(customer);
            return "redirect:/list_customer";
        }
    }

    @GetMapping("/list_customer")
    public ModelAndView getListCustomer(Optional<String> keyword, Pageable pageable) {
        Page<Customer> customerList = null;
        String keywordGet = null;

        Pageable pageableSortByCustomerId = PageRequest.of(pageable.getPageNumber(), 3, Sort.by("dateOfBirth").descending());

        if (keyword.isPresent()) {
            keywordGet = keyword.get();
            customerList = customerService.findByCustomerNameContaining(keyword.get(), pageableSortByCustomerId);
        } else {
            customerList = customerService.getAllCustomer(pageableSortByCustomerId);
        }
        ModelAndView modelAndView = new ModelAndView("index", "customerList", customerList);

        modelAndView.addObject("keyword", keywordGet);
        return modelAndView;
    }

    @GetMapping("/edit_customer")
    public String goEditCustomer(@RequestParam(value = "customerId") Long customerId, Model model) {
        model.addAttribute("typeOfCustomerList", typeOfCustomerService.getAllTypeOfCustomer());
        model.addAttribute("customer", customerService.getCustomerById(customerId));
        return "customer/edit_customer";
    }

    @PostMapping("/edit_customer")
    public String editCustomer(@ModelAttribute(name = "customer") Customer customer, BindingResult bindingResult) {

        new Customer().validate(customer, bindingResult);
        if (bindingResult.hasErrors()) {
            return "customer/edit_customer";
        } else {
            customerService.editCustomer(customer);
            return "redirect:/list_customer";
        }
    }

    @GetMapping("/delete_customer")
    public String deleteCustomer(@RequestParam(value = "customerId") Long customerId) {
        customerService.deleteCustomer(customerId);
        return "redirect:/list_customer";
    }

    @GetMapping("/type_customer")
    public ModelAndView goTypeOfCustomer(Pageable pageabe) {
        ModelAndView modelAndView = new ModelAndView("customer/type_of_customer");
        modelAndView.addObject("listType", typeOfCustomerService.getAllTypeOfCustomerPage(pageabe));
        return modelAndView;
    }

    @GetMapping("/list_customer_by_type")
    public ModelAndView getListCustomerByType(Optional<String> keyword, Pageable pageable,
                                              @RequestParam("typeOfCustomer") Long typeOfCustomerId) {
        Page<Customer> customerList = null;
        String keywordGet = null;

        Pageable pageableSortByCustomerId = PageRequest.of(pageable.getPageNumber(), 3, Sort.by("dateOfBirth").descending());

        if (keyword.isPresent()) {
            keywordGet = keyword.get();
            customerList = customerService.findByCustomerNameContaining(keyword.get(), pageableSortByCustomerId);
        } else {
            customerList = customerService.getAllCustomerByType(typeOfCustomerId, pageableSortByCustomerId);
        }
        ModelAndView modelAndView = new ModelAndView("index", "customerList", customerList);

        modelAndView.addObject("keyword", keywordGet);
        return modelAndView;
    }

    @GetMapping("/list_customer_by_type/{type_of_customer_id}")
    public ModelAndView getListCustomerByTypeByPathVariable(Optional<String> keyword, Pageable pageable,
                                              @PathVariable("type_of_customer_id") Long typeOfCustomerId) {
        Page<Customer> customerList = null;
        String keywordGet = null;

        Pageable pageableSortByCustomerId = PageRequest.of(pageable.getPageNumber(), 3, Sort.by("dateOfBirth").descending());

        if (keyword.isPresent()) {
            keywordGet = keyword.get();
            customerList = customerService.findByCustomerNameContaining(keyword.get(), pageableSortByCustomerId);
        } else {
            customerList = customerService.getAllCustomerByType(typeOfCustomerId, pageableSortByCustomerId);
        }
        ModelAndView modelAndView = new ModelAndView("index", "customerList", customerList);

        modelAndView.addObject("keyword", keywordGet);
        return modelAndView;
    }

    //-------------------Retrieve All Customers--------------------------------------------------------

//    @RequestMapping(value = "/customers/", method = RequestMethod.GET)
//    public ResponseEntity<List<Customer>> listAllCustomers() {
//        List<Customer> customers = customerService.findAll();
//        if (customers.isEmpty()) {
//            return new ResponseEntity<List<Customer>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
//        }
//        return new ResponseEntity<List<Customer>>(customers, HttpStatus.OK);
//    }
}
