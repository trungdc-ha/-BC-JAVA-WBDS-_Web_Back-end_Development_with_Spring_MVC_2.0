package com.codegym.ungdungspringbootwebservice.controller;

import com.codegym.ungdungspringbootwebservice.model.Location;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class HomeController {
    @GetMapping("/weather/{userName}/{passWord}")
    public ResponseEntity<Location> getWether(@PathVariable String userName, @PathVariable String passWord){
        return new ResponseEntity<Location>(new Location(1,"VietName",27.4f,"Sun"), HttpStatus.OK);
    }
}
