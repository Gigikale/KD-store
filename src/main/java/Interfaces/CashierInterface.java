package Interfaces;

import com.org.kdstore.model.Product;

import java.util.Map;

public interface CashierInterface {
void sellingOfGoods(String item, double price, int quantity);
void dispenseReceipt(Map<String, Product> purchaseCat, String name);

}
