package com.store.internalOperations;

import com.store.customerOperations.CustomerOperationsImpl;
import com.store.enums.Gender;
import com.store.enums.Role;
import com.store.exceptions.InsufficientFundException;
import com.store.exceptions.ProductNotInStockException;
import com.store.exceptions.ProductOutOfStockException;
import com.store.exceptions.StaffNotAuthorizedException;
import com.store.models.*;
import com.store.models.Category;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

class InternalOperationsImplTest {

    Store store;
    Category Food;
    Product product;
    Product product1;
    Staff adee;
    Staff chisom;
    Customer deenn;
    Customer sam;
    Customer wale;
    Customer sola;
    Customer kunle;
    Customer ade;
    Customer akin;

    InternalOperations internalOperations;
    CustomerOperationsImpl customerOperations = new CustomerOperationsImpl();

    @BeforeEach
    void setUp() {
        store = new Store("DrogoStore","Tech_Park",chisom);
        Food = new Category("Food");

        adee = new Staff(Role.MANAGER);
        chisom = new Staff(Role.CASHIER);
        internalOperations = new InternalOperationsImpl();

        deenn = new Customer("Deenn","lawal","a@gmail.com","edo", Gender.MALE);
        sam= new Customer("yyy","Lawal","ade@gmail.com","Edo Park",Gender.MALE);
        wale = new Customer("xxx","lawal","a@gmail.com","edo",Gender.MALE);
        sola = new Customer("Sam","lawal","a@gmail.com","edo",Gender.MALE);
        kunle = new Customer("Kunle","lawa","a@gmail.com","edo",Gender.MALE);
        ade = new Customer("kam","lawal","a@gmail.com","edo",Gender.MALE);
        akin = new Customer("fam","lawal","a@gmail.com","edo",Gender.MALE);


    }

    @Test
    void shouldCheckNumberOfProductsAddedToStore() throws StaffNotAuthorizedException, IOException {
        internalOperations.addProductToStore(adee,store);
        Assertions.assertEquals(13,store.getProductList().length);
    }

    @Test
    void shouldCheckIfTheProductsInStoreAreWhatWasAdded() throws StaffNotAuthorizedException, IOException {
        internalOperations.addProductToStore(adee,store);
        Assertions.assertTrue(store.getProductList()[7].getProductName().equalsIgnoreCase("juice"));
        Assertions.assertEquals(10,store.getProductList()[0].getProductQuantity());
    }
    @Test
    void shouldCheckWhoseAddingProductToStore() throws StaffNotAuthorizedException, IOException {

        Assertions.assertThrows(StaffNotAuthorizedException.class, ()-> internalOperations.addProductToStore(chisom,store));
    }

    @Test
    void sellProducts() throws StaffNotAuthorizedException, IOException, ProductOutOfStockException, ProductNotInStockException {
        internalOperations.addProductToStore(adee,store);
        customerOperations.addProductToCart(deenn,store,"Bread",4);
        customerOperations.loadCustomerAccount(deenn,10.0);
        Assertions.assertThrows(StaffNotAuthorizedException.class, ()-> internalOperations.sellToCustomerInQueue(store.getCustomerCustomPriorityQueue(), adee,store));
    }

    @Test
    void shouldThrowInsufficientFundException() throws StaffNotAuthorizedException, IOException, InsufficientFundException, ProductOutOfStockException, ProductNotInStockException {
        internalOperations.addProductToStore(adee,store);
        customerOperations.addProductToCart(deenn,store,"Bread",4);
        customerOperations.loadCustomerAccount(deenn,10.0);
        Assertions.assertEquals(10.00, deenn.getAccount().getAccountBalance());
        Assertions.assertThrows(InsufficientFundException.class, () -> internalOperations.sellToCustomerInQueue(store.getCustomerCustomPriorityQueue(),chisom, store));
    }
    @Test
    void shouldCheckIfQueueIsEmptyAfterSelling() throws StaffNotAuthorizedException, IOException, InsufficientFundException, ProductOutOfStockException, ProductNotInStockException {
        internalOperations.addProductToStore(adee,store);
        customerOperations.addProductToCart(deenn,store,"Bread",4);
        customerOperations.loadCustomerAccount(deenn,100000000.0);
        internalOperations.sellToCustomerInQueue(store.getCustomerCustomPriorityQueue(), chisom,store);

        Assertions.assertEquals(0, store.getCustomerCustomPriorityQueue().count());
    }
    @Test
    void shouldCheckIfCustomerCartIsEmpty() throws StaffNotAuthorizedException, IOException, InsufficientFundException, ProductOutOfStockException, ProductNotInStockException {
        internalOperations.addProductToStore(adee,store);
        customerOperations.addProductToCart(deenn,store,"Bread",4);
        customerOperations.loadCustomerAccount(deenn,100000000.0);
        internalOperations.sellToCustomerInQueue(store.getCustomerCustomPriorityQueue(), chisom,store);

        Assertions.assertEquals(0, deenn.getCartMap().size());
    }
    @Test
    void shouldCheckIfCustomerWalletAfterBuying() throws StaffNotAuthorizedException, IOException, InsufficientFundException, ProductOutOfStockException, ProductNotInStockException {
        internalOperations.addProductToStore(adee,store);
        customerOperations.addProductToCart(deenn,store,"Bread",4);
        customerOperations.loadCustomerAccount(deenn,100000000.0);
        double balanceBeforeBuying = deenn.getAccount().getAccountBalance();
       internalOperations.sellToCustomerInQueue(store.getCustomerCustomPriorityQueue(), chisom,store);

        Assertions.assertTrue(balanceBeforeBuying > deenn.getAccount().getAccountBalance());
    }
    @Test
    public void checkSequenceOfQueue() throws ProductOutOfStockException, ProductNotInStockException, StaffNotAuthorizedException, IOException {
        internalOperations.addProductToStore(adee,store);
        customerOperations.addProductToCart(sam,store,"Garri",1);
        customerOperations.addProductToCart(wale,store,"Garri",2);
        customerOperations.addProductToCart(akin,store,"Bread", 2);
        customerOperations.addProductToCart(kunle,store,"Garri",5);
        customerOperations.addProductToCart(sola,store,"Bread",4);
        customerOperations.addProductToCart(ade,store,"Bread",1);
        String expected = "1yyy 2xxx 3kam 4fam 5Kunle 6Sam";
        StringBuilder actualSequence = new StringBuilder();
        int count = 1;
        while (!store.getCustomerCustomPriorityQueue().empty()){
            Customer customer = store.getCustomerCustomPriorityQueue().poll();
            actualSequence.append(count).append(customer.getFirstName()).append(" ");
            count++;
        }
        Assertions.assertEquals(expected, actualSequence.toString().trim());
    }
}