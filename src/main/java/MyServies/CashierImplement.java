package MyServies;

import com.org.kdstore.model.Customer;
import com.org.kdstore.model.FileReaders;
import com.org.kdstore.model.Product;
import com.org.kdstore.staffModel.Cashier;

import java.io.FileReader;
import java.io.IOException;
import java.util.Map;

public class CashierImplement {
    private Cashier cashier;

    public CashierImplement(Cashier cashier) {
        this.cashier = cashier;
    }

    public CashierImplement() {
    }

    public boolean addToStock (){
        boolean success = false;
       try{
           success = new FileReaders().reader();
           if(success){
               System.out.println("Product added successfully");
           }else{
               System.out.println( "Error adding product");
           }
       }catch(Exception e){
           System.out.println("error occurred"+ e);
       }
       return success;
    }

    public boolean dispenseReceipt(Customer customer) {
        double sum = 0;
        for (Map.Entry<String, Product> good : customer.getPurchaseCat().entrySet()){
            System.out.println(good.getKey()+ " "+good.getValue()+ "\n");
            sum += good.getValue().getProductQuantity() + good.getValue().getProductPrice();
        }
        System.out.println("TOTAL BILL FOR PURCHASE: "+sum+"\n");
        System.out.println("REQUEST MADE!!!!");
        System.out.println( "THANKS FOR YOUR PATRONAGE HIGHLY ESTEEMED. "+customer.getName());
        return  true;
    }
}
