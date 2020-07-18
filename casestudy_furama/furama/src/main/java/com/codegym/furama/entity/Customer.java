package com.codegym.furama.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import net.bytebuddy.implementation.bind.annotation.Empty;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
public class Customer implements Validator {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long customerId;

    private String customerName;

    private String dateOfBirth;

    private String gender;

    @Pattern(regexp = "^[\\d]{9,12}$", message = "Format Id card is wrong")
    private String idCard;

    @Pattern(regexp = "(090|091|\\+8490|\\+8491)+([0-9]{7})\\b", message = "Format phone is wrong")
    private String phoneNumber;

    @Pattern(regexp = "^[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,6}$", message = "Format email is wrong")
    private String email;

    @OneToOne
    @JoinColumn
    private TypeOfCustomer typeOfCustomer;

    private String address;

    private Date startDate;

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {

    }
}
