package com.store.customLinkedList;

import com.store.models.Customer;

import java.util.LinkedList;

public class CustomLInkedLIst{
    Node head;

    public void insert(Customer customer) {
        Node newNode = new Node(customer);

        if (head == null) {
            head = newNode;
        } else {

            Node currentNode = head;

            while (currentNode.next != null) {
                currentNode = currentNode.next;
            }
            currentNode.next = newNode;
        }
    }
    public void insertAtStart(Customer customer) {
        Node newNode = new Node(customer);

        newNode.next = head;
        head = newNode;
    }
    public int count() {
//        Node newNode = new Node();
        int count  = 1;
        if (head == null) {
            return 0;
        }

        Node currentNode = head;
        while (currentNode.next != null) {
            count++;
            currentNode = currentNode.next;
        }
        return count;
    }




}
