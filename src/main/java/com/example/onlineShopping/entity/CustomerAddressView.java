package com.example.onlineShopping.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Immutable;
import org.hibernate.annotations.Subselect;
import org.hibernate.validator.constraints.Email;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Subselect("SELECT * FROM customer_order_details")
@Immutable
public class CustomerAddressView {
    @Id
    private int customerId;
    @NotNull(message = "Name cannot be null")
    private String customerName;
    @Pattern(regexp = "^[FM]$")
    private String gender;
    @Email(message = "Email should be valid")
    private String email;
    @NotBlank
    private String address;
    @Digits(message="Number should contain 6 digits.", fraction = 0, integer = 6)
    @Positive
    private String pincode;
    @Digits(message="Number should contain 10 digits.", fraction = 0, integer = 10)
    @Positive
    private String phone;
    private int orderTotal;
    private LocalDate orderDate;
    private LocalDate shippedDate;
}
