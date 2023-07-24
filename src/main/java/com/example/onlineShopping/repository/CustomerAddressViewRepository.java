package com.example.onlineShopping.repository;

import com.example.onlineShopping.entity.CustomerAddressView;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerAddressViewRepository extends JpaRepository<CustomerAddressView, Integer> {
    List<CustomerAddressView> findByAddress(String address);
}
