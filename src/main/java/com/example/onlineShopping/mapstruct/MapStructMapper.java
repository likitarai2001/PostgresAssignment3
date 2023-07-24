package com.example.onlineShopping.mapstruct;

import com.example.onlineShopping.dto.CustomerDto;
import com.example.onlineShopping.entity.Customer;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MapStructMapper {
    Customer customerDtoToCustomer(CustomerDto customerDto);

    CustomerDto customerToCustomerDto(Customer customer);
}
