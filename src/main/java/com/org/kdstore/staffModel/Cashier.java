package com.org.kdstore.staffModel;

public class Cashier extends Staff {

    private boolean hired;
    public Cashier(String name, String phoneNumber, String role) {
        super(name, phoneNumber, role);
    }

    public Cashier() {
    }

    public boolean isHired() {
        return hired;
    }

    public void setHired(boolean hired) {
        this.hired = hired;
    }
}
