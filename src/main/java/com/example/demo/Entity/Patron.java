package com.example.demo.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Patron {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Patron_id;
    private String full_name;
    @Email(message = "Invalid email format")
    private String email;
    @Pattern(regexp="(^$|[0-10]{11})", message="Invalid phone number")
    private String phoneNumber;
    @NotBlank(message = "National ID number cannot be empty")
    @Pattern(regexp="\\d{14}", message="Invalid national ID number")
    private String NationalID;
}
