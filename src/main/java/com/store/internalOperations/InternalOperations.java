package com.store.internalOperations;

import com.store.customLinkedList.CustomPriorityQueue;
import com.store.exceptions.InsufficientFundException;
import com.store.exceptions.StaffNotAuthorizedException;
import com.store.models.Customer;
import com.store.models.Staff;
import com.store.models.Store;
import com.store.models.Product;

import java.io.IOException;

public interface InternalOperations {
    void addProductToStore(Staff admin, Store store) throws StaffNotAuthorizedException, IOException;
    void sellToCustomerInQueue(CustomPriorityQueue customPriorityQueue, Staff staff, Store store) throws InsufficientFundException, StaffNotAuthorizedException;
    String printReceipt(Store store, Customer customer,double totalAmount);

}
