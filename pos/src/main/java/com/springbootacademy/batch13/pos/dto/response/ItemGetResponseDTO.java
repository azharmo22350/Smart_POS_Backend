package com.springbootacademy.batch13.pos.dto.response;


import com.springbootacademy.batch13.pos.entity.enums.MesuringUnitType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ItemGetResponseDTO {

    private String item_name;


    private MesuringUnitType measuringUnitType;


    private double balanceQty;


    private double supplierPrice;


    private double sellingPrice;


    private boolean activeState;

}
