package org.example.bankmgmt.Controller;


import org.example.bankmgmt.ApiResponse.BankMgmt_Response;
import org.example.bankmgmt.Model.Customer;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("api/v1/BankMgmt")
public class BankManagementController {

//    Get all the customers
//    Add new customers
//    Update customers
//    Delete customers
//    Deposit money to customer
//    Withdraw money from customers

    ArrayList<Customer> customers = new ArrayList<>();

    @PostMapping(path = "/add")
    public BankMgmt_Response addCustomer(@RequestBody Customer customer){

        customers.add(customer);
        return new BankMgmt_Response("Customer Added Successfully");

    }


    @GetMapping(path = "/get")
    public ArrayList<Customer> getAllCustomers(){

        return customers;
    }

    @PutMapping(path = "/update/{index}")
    public BankMgmt_Response updateCustomer(@PathVariable int index, @RequestBody Customer customer){
        customers.set(index, customer);

        return new BankMgmt_Response("Customer Updated Successfully");

    }

    @DeleteMapping(path = "/delete/{index}")
    public BankMgmt_Response deleteCustomer(@PathVariable int index){
        customers.remove(index);
        return new BankMgmt_Response("Customer Deleted Successfully");
    }


    @PutMapping(path = "/deposit/{amount}/{index}")
    public BankMgmt_Response depositTo(@PathVariable double amount, @PathVariable int index){

       for(Customer customer : customers){
               if(index < customers.size()) {
                   customer.setBalance(customer.getBalance() + amount);
                   return new BankMgmt_Response("Deposit to this customer done successfully");
               }
       }

       return new BankMgmt_Response("Customer Not Found");
    }


    @PutMapping(path = "/withdraw/{amount}/{index}")
    public BankMgmt_Response withdrawFrom(@PathVariable double amount, @PathVariable int index){
    //amount: amount want to withdraw from balnace
        if(index < customers.size()) {

            for(Customer customer : customers){

                if(customer.getBalance() >= amount) {
                    customer.setBalance(customer.getBalance() - amount);
                    return new BankMgmt_Response("Withdraw from customer done successfully");
                }else {
                    return new BankMgmt_Response("Insufficient Balance");
                }

            }//End for

        } //End if

        return new BankMgmt_Response("Customer Not Found");
    }








} //End controller
