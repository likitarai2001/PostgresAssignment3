package com.example.onlineShopping.service;

import com.example.onlineShopping.entity.CustomerAddressView;

import java.util.List;

public interface CustomerAddressViewService {
    public List<CustomerAddressView> getAllCustomersWithGivenAddress(String address);
}
