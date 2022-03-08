package com.store.models;

//import com.store.SortByFIFO;

import com.store.customLinkedList.CustomPriorityQueue;

import java.util.*;


public class Store {

    private String name;
    private String address;
    private Account storeAccount;
    private CustomPriorityQueue customerCustomPriorityQueue;
    private List<Staff> staffs;
    private List<Applicant> applicants;
    private Product[] productList = new Product[1];

    public Store(String name, String address , Staff manager) {
        this.name = name;
        this.address = address;
        this.customerCustomPriorityQueue = new CustomPriorityQueue();
        this.storeAccount = new Account(this.name);
        this.staffs = new ArrayList<>();
        this.applicants = new ArrayList<>();
        staffs.add(manager);
    }

    public String getName() {
        return name;
    }



    public String getAddress() {
        return address;
    }

    public Account getStoreAccount() {
        return storeAccount;
    }


    public List<Staff> getStaffs() {
        return staffs;
    }


    public List<Applicant> getApplicants() {
        return applicants;
    }


    public Product[] getProductList() {
        return productList;
    }

    public void setProductList(Product[] productList) {
        this.productList = productList;
    }

//    public PriorityQueue<Customer> getCustomerPriorityQueue() {
//        return customerPriorityQueue;
//    }

//    public void setCustomerPriorityQueue(PriorityQueue<Customer> customerPriorityQueue) {
//        this.customerPriorityQueue = customerPriorityQueue;
//    }

    public CustomPriorityQueue getCustomerCustomPriorityQueue() {
        return customerCustomPriorityQueue;
    }

    public void setCustomerCustomPriorityQueue(CustomPriorityQueue customerCustomPriorityQueue) {
        this.customerCustomPriorityQueue = customerCustomPriorityQueue;
    }

    @Override
    public String toString() {
        return "Store{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", storeAccount=" + storeAccount +
                ", customerCustomPriorityQueue=" + customerCustomPriorityQueue +
                ", staffs=" + staffs +
                ", applicants=" + applicants +
                ", productList=" + Arrays.toString(productList) +
                '}';
    }
}
