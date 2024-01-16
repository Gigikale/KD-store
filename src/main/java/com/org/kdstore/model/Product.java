package com.org.kdstore.model;

import com.org.kdstore.Category;

public class Product {
    private Category CAT;
    private String productName;
    private double productPrice;
    private int productQuantity;

    public Product(Category CAT, String productName, double productPrice, int productQuantity) {
        this.CAT = CAT;
        this.productName = productName;
        this.productPrice = productPrice;
        this.productQuantity = productQuantity;
    }

    public Product() {
    }

    public Category getCAT() {
        return CAT;
    }

    public void setCAT(Category CAT) {
        this.CAT = CAT;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(double productPrice) {
        this.productPrice = productPrice;
    }

    public int getProductQuantity() {
        return productQuantity;
    }

    public void setProductQuantity(int productQuantity) {
        this.productQuantity = productQuantity;
    }
}
