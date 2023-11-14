package com.springbootacademy.batch13.pos.entity;

import com.springbootacademy.batch13.pos.entity.enums.MesuringUnitType;
import lombok.*;

import javax.persistence.*;



@Entity
@Table(name="item")

@Data
@NoArgsConstructor
@AllArgsConstructor


public class Item {

    @Id
    @Column(name="item_id",length = 45)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int itemId;
    @Column(name="item_name",length = 100,nullable = false)
    private String item_name;

    @Enumerated(EnumType.STRING) //when you define a enum add it
    @Column(name = "measure_type",length = 100,nullable = false)
    private MesuringUnitType measuringUnitType;

    @Column(name="balance_qty",length = 100,nullable = false)
    private double balanceQty;

    @Column(name="supplier_price",length = 100,nullable = false)
    private double supplierPrice;

    @Column(name="selling_price",length = 100,nullable = false)
    private double sellingPrice;

    @Column(name="active_state",columnDefinition = "TINYINT default 0")
    private boolean activeState;





}
