package MyServies;

import Interfaces.ManagerInterfaces;
import com.org.kdstore.staffModel.Cashier;

public class ManagerServices implements ManagerInterfaces {
    @Override
    public Boolean hire(Cashier cashier, int points) {
        if (points >= 35) {
            cashier.setHired(true);
            System.out.println(cashier.getName() + " IS HIRED AS THE CASHIER!!!");
            return true;
        } else {
            System.out.println("YOU DO NOT HAVE ENOUGH POINTS TO GET THIS EMPLOYMENT! " + cashier.getName());
        }
        return false;
    }

    @Override
    public void fire(Cashier cashier) {
        if(cashier.isHired()){
            cashier.setHired((false));
            System.out.println(cashier.getName()+" IS FIRED!");
        }else{
            System.out.println("NO RECORD OF CASHIER");
        }
    }
}
