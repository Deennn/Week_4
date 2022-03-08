package com.store.customLinkedList;

import com.store.models.Customer;

import java.util.LinkedList;

public class CustomPriorityQueue {

    private LinkedList<Customer> linkedList = new LinkedList<>();

    public void add(Customer customer) {
        String newProduct = customer.getCartMap().keySet().stream().toList().get(0).getProductName();
        int quantity = customer.getCartMap().values().stream().toList().get(0);
        if (!linkedList.isEmpty()) {
            boolean flag = false;
            int j = 0;
            for (int i = 0; i < linkedList.size(); i++) {
                String  existingProduct = linkedList.get(i).getCartMap().keySet().stream().toList().get(0).getProductName();
                int existingQuantity = linkedList.get(i).getCartMap().values().stream().toList().get(0);
                if (newProduct.equals(existingProduct) && quantity < existingQuantity) {
                    j = i;
                    flag = true;
                    break;
                }
            }
            if (flag) {
                linkedList.add(j, customer);
            } else {
                linkedList.add(customer);
            }

        } else {
            linkedList.add(customer);
        }
    }
    public boolean empty() {
        return linkedList.isEmpty();
    }
    public Customer peek(){
        return linkedList.peek();
    }
    public int count() {
      return linkedList.size();
    }
    public Customer poll() {
        return linkedList.poll();
    }

    @Override
    public String toString() {
        return "LinkedQueue{" +
                "linkedList=" + linkedList +
                '}';
    }
}

