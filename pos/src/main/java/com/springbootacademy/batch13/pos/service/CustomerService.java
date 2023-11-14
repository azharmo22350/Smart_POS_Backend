package com.springbootacademy.batch13.pos.service;

import com.springbootacademy.batch13.pos.dto.CustomerDTO;
import com.springbootacademy.batch13.pos.dto.request.CustomerUpdateDTO;

import java.util.List;

public interface CustomerService {




    public String saveCustomer(CustomerDTO customerDTO);

    String updateCustomer(CustomerUpdateDTO customerUpdateDTO);

    CustomerDTO getCustomerById(int customerId);

    List<CustomerDTO> getAllCustomers();

    List<CustomerDTO> getAllCudtomersByActiveState(boolean activeState);
}
