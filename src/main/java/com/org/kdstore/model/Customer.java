package com.org.kdstore.model;

import java.util.Map;

public class Customer {

    private String name;
    private Map<String, Product> purchaseCat;
    private int quantity;

    public Customer(String name, Map<String, Product> purchaseCat) {
        this.name = name;
        this.purchaseCat = purchaseCat;
        this.quantity = calculateCartQuantity();
    }

    public Customer() {

    }

    // Other getters and setters...


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Map<String, Product> getPurchaseCat() {
        return purchaseCat;
    }

    public void setPurchaseCat(Map<String, Product> purchaseCat) {
        this.purchaseCat = purchaseCat;
    }

    private int calculateCartQuantity() {
        if (purchaseCat != null) {
            for (var item : purchaseCat.values()) {
                quantity += item.getProductQuantity();
            }
            return quantity;
        } else {
            return 0;
        }
    }
}

//    private String name;
//    private Map<String, Product> purchaseCat;
//    private int quantity;
//
//
//    public Customer(String name, Map<String, Product> purchaseCat) {
//        this.name = name;
//        this.purchaseCat = purchaseCat;
//        this.quantity = getCartQuantity();
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public Map<String, Product> getPurchaseCat() {
//        return purchaseCat;
//    }
//
//    public void setPurchaseCat(Map<String, Product> purchaseCat) {
//        this.purchaseCat = purchaseCat;
//    }
//
//    public int getQuantity() {
//        return quantity;
//    }
//
//    public void setQuantity(int quantity) {
//        this.quantity = quantity;
//    }
//
//    private int getCartQuantity() {
//        if (purchaseCat != null) {
//            for (var item : purchaseCat.values()) {
//                quantity += item.getProductQuantity();
//            }
//            return quantity;
//        } else {
//            return 0;
//        }
//    }}

