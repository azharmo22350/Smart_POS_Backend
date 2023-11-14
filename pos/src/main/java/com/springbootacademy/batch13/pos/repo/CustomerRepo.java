package com.springbootacademy.batch13.pos.repo;


import com.springbootacademy.batch13.pos.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.List;

//repo is a interface
//java + mysql = hebernate

@Repository
@EnableJpaRepositories

//using these anotation these are generating quries
//generaic-no specific types it can be assigned dynamically

//

public interface CustomerRepo extends JpaRepository<Customer,Integer> {
    Customer getReferenceById(int customerId);


    //entity type, type of primary key

    //go inside the -see when pass variables to this it changes queries
    //JpaRepository >> PagingAndSortingRepository >>CrudRepository in this interface there is a method called
    //save we have to access it to send over entity

    List<Customer> findAllByActiveEquals(boolean activeState); //can be found by cntrl + state
}

//
//
//package com.springbootacademy.batch13.pos.repo;
//
//import com.springbootacademy.batch13.pos.entity.Item;
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
//import org.springframework.stereotype.Repository;
//
//import java.util.List;
//
//
//@Repository
//@EnableJpaRepositories
//public interface ItemRepo extends JpaRepository<Item,Integer> {
//
//  List<Item> findAllByItemnameEqualsAndActiveStateEquals(String itemName, boolean b);
//}
//
//



