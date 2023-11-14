/*package com.springbootacademy.batch13.pos.entity;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.vladmihalcea.hibernate.type.json.JsonType;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.ArrayList;


@Entity
@Table(name = "customer")

@TypeDefs(

        @TypeDef(name = "json", typeClass = JsonType.class)
})
public class Customer {

    @Id
    @Column(name = "customer id",length = 45)
    private int customerId;

    @Column(name="customer name",length = 100)
    private String CustomerName;

    @Column(name = "customer address",length = 100)
    private String customerAddress;

    @Column(name = "customer sallary")
    private String customerSallary;

    @Type(type="json")
    @Column(name="customer_number",columnDefinition = "json")
    private ArrayList contact_numbers;

    @Column(name = "nic")
    private String nic;

    @Column(name = "active_state",columnDefinition = "TINYINT default 1")
    private String active;


}*/

package com.springbootacademy.batch13.pos.entity;

import com.vladmihalcea.hibernate.type.json.JsonType;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "customer")
@TypeDefs({
        @TypeDef(name = "json", typeClass = JsonType.class)
})
public class Customer {

    @Id
    @Column(name = "customer_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    //generate the id autoly
    private int customerId;

    @Column(name = "customer_name", length = 100)
    private String customerName;

    @Column(name = "customer_address", length = 100)
    private String customerAddress;

    @Column(name = "customer_salary")
    private double customerSalary;

    @Type(type = "json")
    @Column(name = "contact_numbers", columnDefinition = "json")
    private List<String> contactNumbers;

    @Column(name = "nic")
    private String nic;

    @Column(name = "active_state", columnDefinition = "TINYINT default 0")
    private boolean active;

    public Customer() {
    }

    public Customer(int customerId, String customerName, String customerAddress, double customerSalary, List<String> contactNumbers, String nic, boolean active) {
        this.customerId = customerId;
        this.customerName = customerName;
        this.customerAddress = customerAddress;
        this.customerSalary = customerSalary;
        this.contactNumbers = contactNumbers;
        this.nic = nic;
        this.active = active;
    }

    public Customer(int customerId, String customerName) {
        this.customerId = customerId;
        this.customerName = customerName;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerAddress() {
        return customerAddress;
    }

    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
    }

    public double getCustomerSalary() {
        return customerSalary;
    }

    public void setCustomerSalary(double customerSalary) {
        this.customerSalary = customerSalary;
    }

    public List<String> getContactNumbers() {
        return contactNumbers;
    }

    public void setContactNumbers(List<String> contactNumbers) {
        this.contactNumbers = contactNumbers;
    }

    public String getNic() {
        return nic;
    }

    public void setNic(String nic) {
        this.nic = nic;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}


