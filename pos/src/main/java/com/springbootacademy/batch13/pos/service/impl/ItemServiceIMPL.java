

package com.springbootacademy.batch13.pos.service.impl;

import com.springbootacademy.batch13.pos.dto.CustomerDTO;
import com.springbootacademy.batch13.pos.dto.request.ItemSaveRequestDTO;
import com.springbootacademy.batch13.pos.dto.response.ItemGetResponseDTO;
import com.springbootacademy.batch13.pos.entity.Customer;
import com.springbootacademy.batch13.pos.entity.Item;
import com.springbootacademy.batch13.pos.repo.ItemRepo;
import com.springbootacademy.batch13.pos.service.ItemService;
//import com.springbootacademy.batch13.pos.util.mappers.ItemMapper;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;


@Service
public class ItemServiceIMPL implements ItemService {

    @Autowired
    private ItemRepo itemRepo;

    @Autowired
    private ModelMapper modelMapper;

//    @Autowired
//    private ItemMapper itemMapper;


    @Override
    public List<ItemGetResponseDTO> getItemByNameAndStatusByMapStruct(String itemName) {

        return null;
    }

    @Override
    public String saveItem(ItemSaveRequestDTO itemSaveRequestDTO) {


      Item item =new Item(
               1,
                itemSaveRequestDTO.getItem_name(),
                itemSaveRequestDTO.getMeasuringUnitType(),
                itemSaveRequestDTO.getBalanceQty(),
                itemSaveRequestDTO.getSupplierPrice(),
                itemSaveRequestDTO.getSellingPrice(),
                true

        );

             itemRepo.save(item);

        return item.getItem_name();
        //Item item =modelMapper.map(itemSaveRequestDTO,Item.class);
  //  }



        //itemSaveRequestDTO convert into class Item

//        Item item =modelMapper.map(itemSaveRequestDTO,Item.class);
//
//        item.setActiveState(true);
//        if(itemRepo.existsById(item.getItemId())) {
//            itemRepo.save(item);
//            return item.getItemId() + "saved suceesfully";
//        }
//        else{
//            throw new DuplicateKeyException("alredy added");
//
//        }

       // return "";

    }

//    @Override
//    public List<ItemGetResponseDTO> getItemByNameAndStatus(String itemName) {
//        boolean b =true;
//
//        List<Item> items =itemRepo.findAllByItemNameEqualsAndActiveStateEquals(itemName,b);
//        if(items.size()>0)
//        {
//            List<ItemGetResponseDTO> itemGetResponseDTOS =modelMapper.map(items,new TypeToken< List<ItemGetResponseDTO>>(){}.getType());
//            return  itemGetResponseDTOS;
//        }
//        else {
//            throw new RuntimeException("Not found ");
//        }
//    }


}

