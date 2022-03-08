package com.store.models;

import com.store.common.Person;
import com.store.enums.Gender;

import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class Customer extends Person implements Comparable<Customer> {

    private Account account;
    private Map<Product, Integer> cartMap;

    public Customer(String firstName, String lastName, String email, String address, Gender gender) {
        super(firstName, lastName, email, address, gender);
        this.cartMap = new HashMap<>();
        this.account = new Account(this.getFirstName() + " " + this.getLastName());
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    //    public double getWallet() {
//        return wallet;
//    }

//    public void setWallet(double wallet) {
//        this.wallet = wallet;
//    }

//    public int getQuantityWanted() {
//        return quantityWanted;
//    }

//    public void setQuantityWanted(int quantityWanted) {
//        this.quantityWanted = quantityWanted;
//    }

    public Map<Product, Integer> getCartMap() {
        return cartMap;
    }

    public void setCartMap(Product product, int quantityWanted) {
        this.cartMap = cartMap;
    }

    @Override
    public String toString() {
        return this.getFirstName()+"{" +
                "account=" + account +
                ", cartMap=" + cartMap +
                '}';
    }

//    @Override
//    public int compare(Customer o1, Customer o2) {
//        var customerOrder = o1.getCartMap().entrySet().iterator().next();
//        var nextCustomerOrder = o2.getCartMap().entrySet().iterator().next();
//        if (customerOrder.getKey().equals(nextCustomerOrder.getKey())) {
//            return customerOrder.getValue() - nextCustomerOrder.getValue();
//        }
//        return 0;
//    }

    @Override
    public int compareTo(Customer next) {
        var customerOrder = this.getCartMap().entrySet().iterator().next();
        var nextCustomerOrder = next.getCartMap().entrySet().iterator().next();
        if (customerOrder.getKey().equals(nextCustomerOrder.getKey())) {
            return customerOrder.getValue() - nextCustomerOrder.getValue();
        } else {
            return 0;
        }

    }
}




