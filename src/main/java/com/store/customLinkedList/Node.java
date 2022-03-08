package com.store.customLinkedList;

import com.store.models.Customer;

public class Node {


    Node next;
    Customer customer;

    public Node(Customer customer) {
        this.customer = customer;
        this.next = null;
    }

    @Override
    public String toString() {
        return "Node{" +
                "next=" + next +
                ", customer=" + customer +
                '}';
    }
}
