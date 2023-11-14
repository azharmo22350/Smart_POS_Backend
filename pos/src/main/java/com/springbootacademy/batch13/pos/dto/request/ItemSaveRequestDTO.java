package com.springbootacademy.batch13.pos.dto.request;


import com.springbootacademy.batch13.pos.entity.enums.MesuringUnitType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class ItemSaveRequestDTO {


    private String item_name;


    private MesuringUnitType measuringUnitType;


    private double balanceQty;


    private double supplierPrice;


    private double sellingPrice;


}
