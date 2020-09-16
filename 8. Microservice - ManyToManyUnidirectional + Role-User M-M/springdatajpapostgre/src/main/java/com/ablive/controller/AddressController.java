package com.ablive.controller;

import com.ablive.entity.Address;
import com.ablive.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AddressController {

    @Autowired
    private AddressRepository addressRepository;

    @GetMapping(value = "/address/get/all")
    public List<Address> getAddress() {
        return addressRepository.findAll();
    }
}