package com.springbootacademy.batch13.pos.service;

import com.springbootacademy.batch13.pos.dto.CustomerDTO;
import com.springbootacademy.batch13.pos.dto.request.ItemSaveRequestDTO;
import com.springbootacademy.batch13.pos.dto.response.ItemGetResponseDTO;

import java.util.List;

public interface ItemService {
      List<ItemGetResponseDTO> getItemByNameAndStatusByMapStruct(String itemName) ;

//    static String saveCustomer(ItemSaveRequestDTO itemSaveRequestDTO) {
//        return null;
//    }



    String saveItem(ItemSaveRequestDTO itemSaveRequestDTO);

  //  List<ItemGetResponseDTO> getItemByNameAndStatus(String itemName);
}
