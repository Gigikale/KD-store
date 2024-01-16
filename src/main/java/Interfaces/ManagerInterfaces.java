package Interfaces;

import com.org.kdstore.staffModel.Cashier;

public interface ManagerInterfaces {
    Boolean hire(Cashier cashier, int points);
    void fire(Cashier cashier);
}
