package com.codegyn.form_validate.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Not blank")
    @Size(min = 5,max = 45,message = "Size not match")
    @Pattern(regexp = "^\\w+(?: \\w+)*$",message = "Wrong name")
    private String firstName;

    @NotBlank(message = "Not blank")
    @Size(min = 5,max = 45,message = "Size not match")
    @Pattern(regexp = "^\\w+(?: \\w+)*$",message = "Wrong name")
    private String lastName;

    @NotBlank(message = "Not blank")
    @Pattern(regexp = "^(?=0)\\d{10,11}$",message = "Phone number is not exist")
    private String phoneNumber;

    @Min(value = 18,message = "Too young")
    private int age;

    @NotBlank(message = "Not blank")
    @Pattern(regexp = "^\\w+\\w*@\\w+(?:\\.\\w+){1,2}$",message = "Email is not exist")
    private String email;

    public User() {
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return firstName+" "+lastName;
    }
}
