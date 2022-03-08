package com.store.customerOperations;

import com.store.enums.Gender;
import com.store.enums.Qualification;
import com.store.enums.Role;
import com.store.exceptions.ProductNotInStockException;
import com.store.exceptions.ProductOutOfStockException;
import com.store.exceptions.StaffNotAuthorizedException;
import com.store.internalOperations.InternalOperations;
import com.store.internalOperations.InternalOperationsImpl;
import com.store.models.*;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.rules.ExpectedException;

import java.io.IOException;

class CustomerOperationsImplTest {

//    Category FoodStuff = new Category("FoodStuff");
//    Product product = new Product("Milk", "powder milk",FoodStuff,1000);
//    Product product1 = new Product("Sugar","cube sugar",FoodStuff,10000);
//    Product product2 = new Product("Garri","Ijebu garri", FoodStuff,2000);
    @Rule
    public ExpectedException exception = ExpectedException.none();
    Staff manager = new Staff(Role.MANAGER);
    Applicant applicant = new Applicant("deee","sss","jdjd","dskdk", Gender.FEMALE, Qualification.BSC, Role.CASHIER);
    Customer customer = new Customer("Deenn","lawal","a@gmail.com","edo",Gender.MALE);
    Store store = new Store("drogo","tech park", manager);

    Staff cashier = new Staff(Role.CASHIER);

    InternalOperations internalOperations = new InternalOperationsImpl();
    CustomerOperationsImpl customerOperations = new CustomerOperationsImpl();


   @Test
   void shouldCheckTheQuantityOfProductInStore() throws ProductOutOfStockException, ProductNotInStockException, StaffNotAuthorizedException, IOException {
        exception.expect(ProductOutOfStockException.class);
       internalOperations.addProductToStore(manager,store);
       customerOperations.addProductToCart(customer,store,"Garri",15);

   }

    @Test
    void shouldCheckTheSizeOfTheCustomerCart() throws StaffNotAuthorizedException, IOException, ProductOutOfStockException, ProductNotInStockException {
        internalOperations.addProductToStore(manager,store);
        customerOperations.addProductToCart(customer,store,"Garri",9);
        Assertions.assertEquals(1,customer.getCartMap().size());
    }

    @Test
    void loadCustomerAccount() {
        customerOperations.loadCustomerAccount(customer,100.0);
        Assertions.assertEquals(100,customer.getAccount().getAccountBalance(),0.00);
    }

    @Test
    void viewProductByCategory() throws ProductNotInStockException, StaffNotAuthorizedException, IOException {
        Category category = new Category("canned");
        internalOperations.addProductToStore(manager,store);
        customerOperations.viewProductByCategory(customer,store,category.getCategoryName());
        Assertions.assertEquals(2,2);
    }
}