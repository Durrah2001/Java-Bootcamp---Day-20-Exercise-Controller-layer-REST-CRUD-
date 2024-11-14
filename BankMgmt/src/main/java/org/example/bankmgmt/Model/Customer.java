package org.example.bankmgmt.Model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor


public class Customer {


    private String ID;
    private String userName;
    private double balance;


}
