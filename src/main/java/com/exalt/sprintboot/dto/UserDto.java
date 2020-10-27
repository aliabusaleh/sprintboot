package com.exalt.sprintboot.dto;

import lombok.NonNull;

import javax.persistence.Column;
import javax.persistence.Transient;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class UserDto {

    @NonNull
    @NotEmpty(message = "You must enter First Name.")
    private String firstName;

    @NonNull
    @NotEmpty(message = "You must enter Last Name.")
    private String lastName;

    @NonNull
    @NotEmpty(message = "Please enter alias.")
    @Column(nullable = false, unique = true)
    private String alias;

    @NonNull
    @Size(min = 8, max = 20)
    @Pattern(message = "Invalid email Regex", regexp = "^.+@.+\\..+$")
    @Column(nullable = false, unique = true)
    private String email;

    @NonNull
    @Column(length = 100)
    @Pattern(regexp="^[a-zA-Z0-9]{3}",message="Password length must be 3")
    private String password;

    @Transient
    @NotEmpty(message = "Please enter Password Confirmation.")
    private String confirmPassword;

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

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
