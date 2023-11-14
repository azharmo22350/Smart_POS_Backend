package com.springbootacademy.batch13.pos.service.impl;

import com.springbootacademy.batch13.pos.dto.CustomerDTO;
import com.springbootacademy.batch13.pos.dto.request.CustomerUpdateDTO;
import com.springbootacademy.batch13.pos.entity.Customer;
import com.springbootacademy.batch13.pos.exception.NotFoundException;
import com.springbootacademy.batch13.pos.repo.CustomerRepo;
import com.springbootacademy.batch13.pos.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
//here it includes component anotation
//it add beeen (service object) s into te container
public class CustomerServiceIMPL implements CustomerService {

    @Autowired
    private CustomerRepo customerRepo;

    @Override
    public String saveCustomer(CustomerDTO customerDTO) {
       // Customer customer1 =new Customer(1,"azhar");

        Customer customer1 =new Customer(customerDTO.getCustomerId(),customerDTO.getCustomerName(),customerDTO.getCustomerAddress(),
                customerDTO.getCustomerSalary(),customerDTO.getContactNumbers(),customerDTO.getNic(),customerDTO.isActive());

        System.out.println(customerDTO.getCustomerAddress());

        //Customer customer =new Customer();

        customerRepo.save(customer1);
        return customerDTO.getCustomerName();
    }

    @Override
    public String updateCustomer(CustomerUpdateDTO customerUpdateDTO) {

        System.out.println("inside public String updateCustomer");
        if(customerRepo.existsById(customerUpdateDTO.getCustomerId()))
        {
            System.out.println("inside if statement");
            Customer customer =customerRepo.getReferenceById(customerUpdateDTO.getCustomerId());
            customer.setCustomerName(customerUpdateDTO.getCustomerName());
            customer.setCustomerAddress(customerUpdateDTO.getCustomerAddress());
            customer.setCustomerSalary(customerUpdateDTO.getCustomerSalary());

            //use save method for both update and first entry
            customerRepo.save(customer);

            return  customerUpdateDTO.getCustomerName() +"updated successfull" ;

        }else{
            throw new RuntimeException("no data found");
        }




    }

    @Override
    public CustomerDTO getCustomerById(int customerId) {

        if (customerRepo.existsById(customerId))
        {
            Customer customer =customerRepo.getReferenceById(customerId);
            CustomerDTO customerDTO =new CustomerDTO(
                    customer.getCustomerId(),customer.getCustomerName(),
                    customer.getCustomerAddress(),customer.getCustomerSalary(),
                    customer.getContactNumbers(),customer.getNic(),customer.isActive());

            return  customerDTO;

        }else {
            throw new RuntimeException("no such id");
        }

    }

    @Override
    public List<CustomerDTO> getAllCustomers() {
        List<Customer> getAllCustomer =customerRepo.findAll();
        List<CustomerDTO> customerDTOList =new ArrayList();

        if(getAllCustomer.size()>0) {

            for (Customer customer : getAllCustomer) {
                CustomerDTO customerDTO = new CustomerDTO(
                        customer.getCustomerId(), customer.getCustomerName(),
                        customer.getCustomerAddress(), customer.getCustomerSalary(),
                        customer.getContactNumbers(), customer.getNic(), customer.isActive()

                );
                customerDTOList.add(customerDTO);
            }
        }else{
            throw new NotFoundException("no Customer Found ");
        }
        return customerDTOList;
    }

    public List<CustomerDTO> getAllCudtomersByActiveState(boolean activeState){

        List<Customer> getAllCustomer =customerRepo.findAllByActiveEquals(activeState);  //cntrl +f // 5th video 1.50.00
        List<CustomerDTO> customerDTOList =new ArrayList();

        for(Customer customer : getAllCustomer)
        {
            CustomerDTO customerDTO =new CustomerDTO(
                    customer.getCustomerId(),customer.getCustomerName(),
                    customer.getCustomerAddress(),customer.getCustomerSalary(),
                    customer.getContactNumbers(),customer.getNic(),customer.isActive()

            );
            customerDTOList.add(customerDTO);
        }
        return customerDTOList;


    }
}
