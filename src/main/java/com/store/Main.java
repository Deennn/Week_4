package com.store;

import com.store.application.Application;
import com.store.application.ApplicationImpl;
import com.store.customLinkedList.CustomPriorityQueue;
import com.store.customerOperations.CustomerOperations;
import com.store.customerOperations.CustomerOperationsImpl;
import com.store.enums.Gender;
import com.store.enums.Qualification;
import com.store.enums.Role;
import com.store.exceptions.*;
import com.store.internalOperations.InternalOperations;
import com.store.internalOperations.InternalOperationsImpl;
import com.store.models.*;
import com.store.models.Category;
import com.store.recruitment.Recruitment;
import com.store.recruitment.recruitmentImpl;

import java.io.IOException;

public class Main {

   public static void main(java.lang.String[] args) throws StaffNotAuthorizedException, ApplicantsAlreadyAppliedException, OverStaffedException, InsufficientFundException, ProductOutOfStockException, ProductNotInStockException, IOException {
        Category FoodStuff = new Category("FoodStuff");
//        Product milk = new Product("Milk", "powder milk",FoodStuff,1000,10);
//        Product sugar = new Product("Sugar","cube sugar",FoodStuff,10000,14);
//        Product garri = new Product("Garri","Ijebu garri", FoodStuff,2000,12);
        Applicant applicant = new Applicant("deee","sss","jdjd","dskdk",Gender.FEMALE,Qualification.BSC,Role.CASHIER);
        Customer sam= new Customer("samson","Lawal","ade@gmail.com","Edo Park",Gender.MALE);
        Customer wale = new Customer("wale","lawal","a@gmail.com","edo",Gender.MALE);
        Customer sola = new Customer("sola","lawal","a@gmail.com","edo",Gender.MALE);
        Customer kunle = new Customer("Kunle","lawa","a@gmail.com","edo",Gender.MALE);
        Customer ade = new Customer("ade","lawal","a@gmail.com","edo",Gender.MALE);
        Customer akin = new Customer("akin","lawal","a@gmail.com","edo",Gender.MALE);
        Staff manager = new Staff(Role.MANAGER);
        Staff cashier = new Staff(Role.CASHIER);
        Store store = new Store("drogo","tech park",manager);

        InternalOperations internalOperations = new InternalOperationsImpl();
        CustomerOperations customerOperations = new CustomerOperationsImpl();

        Application application = new ApplicationImpl();
        Recruitment recruitment = new recruitmentImpl();
//
//        application.apply(applicant, store);
//        recruitment.hire(applicant, manager, store);
//        System.out.println(store.getApplicants().size());
//        System.out.println(store.getStaffs().size());


        Staff deee = store.getStaffs().get(0);
//        System.out.println(deee.getFirstName());
        Category category  = new Category("Food/Beverages");

        internalOperations.addProductToStore(manager,store);
//        System.out.println(Arrays.toString(store.getProductList()));
//        System.out.println("Food/ Beverages category");
//        customerOperations.viewProductByCategory(sam,store,"canned");


//        customerOperations.buyProduct(sam,store,"garri",5);
        customerOperations.loadCustomerAccount(sam,100000000);
        customerOperations.loadCustomerAccount(wale,100000000);
        customerOperations.loadCustomerAccount(akin,100000000);
        customerOperations.loadCustomerAccount(kunle,100000000);
        customerOperations.loadCustomerAccount(sola,100000000);
        customerOperations.loadCustomerAccount(ade,100000000);


        // 1A 10B 7A 5A 4B

        //5A 7A 12A 4B 10B

        //5A -> 7A -> 12A -> 4B -> 10B
        System.out.println(store.getProductList()[0]);
        System.out.println(store.getProductList()[1]);

        customerOperations.addProductToCart(sam,store,"Garri",10); //2
        customerOperations.addProductToCart(ade,store,"Garri",4); //5 4
        customerOperations.addProductToCart(wale,store,"Milk",6); //3
        customerOperations.addProductToCart(akin,store,"Milk", 2); //4  3
        customerOperations.addProductToCart(kunle,store,"Garri",3); //1
        customerOperations.addProductToCart(sola,store,"Milk",7); //6  5







        internalOperations.sellToCustomerInQueue(store.getCustomerCustomPriorityQueue(),cashier,store);
        System.out.println(store.getProductList()[0]);
        System.out.println(store.getProductList()[1]);






//        CustomPriorityQueue customLInkedLIst = new CustomPriorityQueue();
//        customLInkedLIst.add(sam);
//        customLInkedLIst.add(ade);
//        customLInkedLIst.add(wale);
//        customLInkedLIst.add(sola);
//
//        customLInkedLIst.add(kunle);
//
//
//
//        System.out.println("list size : "+ customLInkedLIst.size());
//        customLInkedLIst.poll();
//        System.out.println(customLInkedLIst);

//        customerOperations.addProductToCart(ade,store,"milk",3);
//        System.out.println(store.getCustomerPriorityQueue());

        // Ac3 Ef2 Bc2 Cd3
//          Ef2, Bc2, Ac3, Cd3

//        System.out.println("sam's cart --> " +store.getCustomerPriorityQueue());

//        Iterator<Customer> r =store.getCustomerPriorityQueue().iterator();
//        while (!store.getCustomerPriorityQueue().isEmpty()){
//             System.out.println(store.getCustomerPriorityQueue().poll());
//        }
//        internalOperations.sellProducts(cashier,store,sam);
//        System.out.println();
//        System.out.println(Arrays.toString(store.getProductList()));
//        System.out.println("sam's cart --> " +sam.getCartMap());
//        System.out.println(store.getStaffs().size());
//        System.out.println(store.getProductMap());

//        customerOperations.buyProduct(sam,store,milk,12);
//        customerOperations.buyProduct(sam,store,sugar,10);
//        System.out.println(sam.getCartMap());

//        internalOperations.sellProducts(deee,store,sam);
//        System.out.println(store.getProductMap());

//        System.out.println(sam.getCartMap());




//        internalOperations.addProductToStore(manager,store,sugar,11);
//        internalOperations.addProductToStore(manager,store,milk,5);
//        internalOperations.addProductToStore(manager,store,sugar,11);
//        internalOperations.addProductToStore(manager,store,garri,12);
//        System.out.println(store.getProductMap());
//        customerOperations.buyProduct(sam,store,sugar,1);
//        customerOperations.buyProduct(sam,store,sugar,21);
//        customerOperations.buyProduct(sam,store,milk,25);
//        application.apply(applicant,store);
//        recruitment.hire(applicant,manager,store);





//        System.out.println(milk);
//        System.out.println(store.getProductMap());
//        System.out.println(sam.getCartMap());

//
//        Applicant applicant = new Applicant("deenn","lawal","aaa","sdhd", Gender.FEMALE, Qualification.BSC, Role.CASHIER);
//        System.out.println(store.getProductMap());
//        System.out.println(applicant);

//        if (true) {
//             System.out.println("true");
//        }
//        if (false) {
//             System.out.println("false");
//        }

    }
}
