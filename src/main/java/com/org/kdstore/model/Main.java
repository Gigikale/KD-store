package com.org.kdstore.model;

import MyServies.CashierImplement;
import MyServies.CustomerActions;
import MyServies.ManagerServices;
import com.org.kdstore.staffModel.Cashier;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        FileReaders fileReaders = new FileReaders();
//        fileReaders.writer();
        fileReaders.reader();
//        fileReaders.viewProduct;

        Cashier first = new Cashier();
        Cashier second = new Cashier();
        first.setName("Kale");
        second.setName("Gberegene");

        ManagerServices managerServices = new ManagerServices();
        managerServices.hire(first,12);
        managerServices.hire(second,50);

        managerServices.fire(first);
        CashierImplement cashierImplement = new CashierImplement();
        cashierImplement.addToStock();

        Customer customer = new Customer();
        CustomerActions firstbuyer = new CustomerActions();
        firstbuyer.makePurchase("Kadi", 5);

        firstbuyer.buy(customer);

//        cashierImplement.dispenseReceipt();
    }
}
