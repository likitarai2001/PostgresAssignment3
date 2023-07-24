package com.example.onlineShopping.service.Impl;

import com.example.onlineShopping.entity.CustomerAddressView;
import com.example.onlineShopping.repository.CustomerAddressViewRepository;
import com.example.onlineShopping.service.CustomerAddressViewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerAddressViewServiceImpl implements CustomerAddressViewService {

    private final CustomerAddressViewRepository customerAddressViewRepository;

    @Autowired
    public CustomerAddressViewServiceImpl(CustomerAddressViewRepository customerAddressViewRepository) {
        this.customerAddressViewRepository = customerAddressViewRepository;
    }


    @Override
    public List<CustomerAddressView> getAllCustomersWithGivenAddress(String address) {
        return customerAddressViewRepository.findByAddress(address);
    }
}
