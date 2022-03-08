package com.store.customerOperations;

import com.store.exceptions.ProductNotInStockException;
import com.store.exceptions.ProductOutOfStockException;
import com.store.models.Category;
import com.store.models.Customer;
import com.store.models.Product;
import com.store.models.Store;

import java.util.*;

public class CustomerOperationsImpl implements CustomerOperations{

    @Override
    public Map<Product, Integer> addProductToCart(Customer customer, Store store, String productName, int quantityWanted) throws ProductOutOfStockException, ProductNotInStockException {
        for (int i=0; i < store.getProductList().length; i++) { //
            if (store.getProductList()[i].getProductName().equalsIgnoreCase(productName)) {
                if (store.getProductList()[i].getProductQuantity() >= quantityWanted) {
//                    store.getProductList()[i].setProductQuantity(store.getProductList()[i].getProductQuantity()-quantityWanted);
                    customer.getCartMap().merge(store.getProductList()[i], quantityWanted, Integer::sum);
                    joinQueue(customer,store);
                    break;
                } else {
                    try
                    {
                        throw new ProductOutOfStockException("Dear " + customer.getFirstName()+", "+ productName + " Out Of Stock");

                    } catch (Exception e) {
                        System.out.println("Dear " + customer.getFirstName()+", "+ productName + " is Out Of Stock");
                    }

//                    throw new ProductOutOfStockException("Dear " + customer.getFirstName()+", "+ productName + " Out Of Stock");
//
                }
            }
        }
        return customer.getCartMap();
    }
    private void joinQueue(Customer customer, Store store) {
        store.getCustomerCustomPriorityQueue().add(customer);
    }
    public List<Product> viewProductByCategory(Customer customer, Store store, String category) throws ProductNotInStockException {
        List<Product> categoryList = new ArrayList<>();
        for (int i=0; i< store.getProductList().length; i++) {
            if (store.getProductList()[i].getCategory().getCategoryName().equalsIgnoreCase(category)) {
                categoryList.add(store.getProductList()[i]);
                }
            }
        System.out.println(categoryList);
        return categoryList;
        }




    @Override
    public void loadCustomerAccount(Customer customer, double amount) {
        double originalBalance = customer.getAccount().getAccountBalance();
        customer.getAccount().setAccountBalance(originalBalance+amount);
    }
}
