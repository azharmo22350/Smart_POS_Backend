package com.springbootacademy.batch13.pos.controller;

import com.springbootacademy.batch13.pos.dto.request.ItemSaveRequestDTO;
import com.springbootacademy.batch13.pos.dto.response.ItemGetResponseDTO;
import com.springbootacademy.batch13.pos.entity.Item;

import com.springbootacademy.batch13.pos.repo.ItemRepo;
import com.springbootacademy.batch13.pos.service.ItemService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/item")
@CrossOrigin
public class ItemController {

    @Autowired
    private ItemService itemService;

//    @Autowired
//    private ItemRepo itemRepo;

    @Autowired
    private ModelMapper modelMapper;




//    public String saveMessage(@RequestBody ItemSaveRequestDTO itemSaveRequestDTO)
//    {
//        //String Message=customerdto.getCustomerName();
//        // CustomerServiceIMPL customerServiceIMPL =new CustomerServiceIMPL();
//        //customerServiceIMPL.saveCustomer(customerdto); not good solution
//
//
//        itemService.saveItem(itemSaveRequestDTO);
//        return "saved";
//
//
//    }
@PostMapping(
        path={"/save"}
)

    public ResponseEntity saveMessage(@RequestBody ItemSaveRequestDTO itemSaveRequestDTO)
    {
        ResponseEntity responseEntity=null;
        
        itemService.saveItem(itemSaveRequestDTO);
        return responseEntity;


    }

//    @GetMapping(
//            path="/get-by-name",
//            params =  "name"
//    )
//    public List<ItemGetResponseDTO> getItemByNameAndStatus(@RequestParam(value="name") String itemName){
//
//
//        List<ItemGetResponseDTO> itemDTOS =itemService.getItemByNameAndStatus(itemName);
//        return itemDTOS;
//
//
//    }

//    @GetMapping(
//            path="/get-by-name-with-mapstruct",
//            params="name"
//    )
//    public List<ItemGetResponseDTO> getItemByNameAndStatusByMapStruct(@RequestParam(value = "name") String itemName){
//
//        List<ItemGetResponseDTO> itemDrTOs =ItemService.getItemByNameAndStatusByMapStruct(itemName);
//        return itemDrTOs;
//    }
}
