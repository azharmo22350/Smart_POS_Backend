package com.springbootacademy.batch13.pos.controller;

import com.springbootacademy.batch13.pos.dto.CustomerDTO;
import com.springbootacademy.batch13.pos.dto.request.CustomerUpdateDTO;
import com.springbootacademy.batch13.pos.service.CustomerService;
import com.springbootacademy.batch13.pos.service.impl.CustomerServiceIMPL;
import com.springbootacademy.batch13.pos.util.StandardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController


@RequestMapping("api/v1/customer")


@CrossOrigin
public class CustomerController {
    @Autowired

    private CustomerService customerService;

    //without sending  string type response we can give ResponseEntititype response and giving the code as well
    //It is industry level response type
    @PostMapping("/save-1")
    public ResponseEntity<StandardResponse> saveMessage(@RequestBody CustomerDTO customerdto)
    {
        String message = customerService.saveCustomer(customerdto);
//        ResponseEntity responseEntity=new ResponseEntity<StandardResponse>(
////                new StandardResponse(201,"Success",message), HttpStatus.CREATED
//        );
        //we put 201 for if it is post one
        System.out.println("come");

        return new ResponseEntity<StandardResponse>(
                new StandardResponse(201,"Succes",message),HttpStatus.CREATED
        );


    }

    @PostMapping("/save -2")
    public  String saveCustomer2(){

        String Message2 ="I m the second method";

        return Message2;
    }
    @PutMapping("/update")
    public String updateCustomer(@RequestBody CustomerUpdateDTO customerUpdateDTO){
        System.out.println("inside the update customer");
        String messagae =customerService.updateCustomer(customerUpdateDTO);
        return messagae;

    }

    @GetMapping(

            path="/get-by-id",
            params ="id"
    )

    public  CustomerDTO getCustomerById(@RequestParam(value="id") int customerId){
        //to work this  inside the bracket should be  (int id)
        //ifwe put int customerId there is a error
        //to use any variable use anotation above

        CustomerDTO customerDTO =customerService.getCustomerById(customerId);

        return customerDTO;

    }

    @GetMapping(
            path ="/get-all-customers"
    )

    //ResponseEntity responce type
    public List<CustomerDTO> getAllCudtomers(){

        List<CustomerDTO> allCustomers =customerService.getAllCustomers();

        return allCustomers;
    }

    //2 types of pass variaBes 1 params 2path variables in dele te consider path variables
    /*
    @DeleteMapping(
            path="delete-customer/{id}" //from here it is define path variables.see belowit is as like see line 72
    )
    public String deleteCustomer(@PathVariable(value="id") int customerId){
        String deleted =customerService
        return deleted;

    }*/

    @GetMapping(
            path ="/get-all-customers-by-active-state/{status}"
    )
    //put code 200 if it is a get response

    public ResponseEntity<StandardResponse> getAllCudtomersByActiveState(@PathVariable(value="status")boolean activeState){

        List<CustomerDTO> allCustomers =customerService.getAllCudtomersByActiveState(activeState);

        return new ResponseEntity<StandardResponse>(new StandardResponse(200,"Sucess",allCustomers),HttpStatus.OK);
    }




}





//only we put beans to the container not pojos put into the container
//Customer is pojo
