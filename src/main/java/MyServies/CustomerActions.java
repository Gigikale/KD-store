package MyServies;

import com.org.kdstore.Category;
import com.org.kdstore.model.Customer;
import com.org.kdstore.model.FileReaders;
import com.org.kdstore.model.Product;

import java.util.HashMap;
import java.util.Map;

public class CustomerActions {
    private Customer customer;
    private Map<String, Product> customerCart = new HashMap<>();
    private FileReaders fileReaders;

    public CustomerActions(Customer customer, FileReaders fileReaders) {
        this.customer = customer;
        this.fileReaders = fileReaders;
    }

    public CustomerActions(FileReaders fileReaders) {
        this.fileReaders = fileReaders;
    }

    public CustomerActions() {
        this.fileReaders = new FileReaders(); // Initialize fileReaders here
    }

    private Category getCategory(String item) {
        if (fileReaders.getFootwares() != null && fileReaders.getFootwares().containsKey(item)) {
            return Category.FOOTWEARS;
        } else if (fileReaders.getCloths() != null && fileReaders.getCloths().containsKey(item)) {
            return Category.CLOTHES;
        } else {
            return null;
        }
    }
    private int getProductQuantity(FileReaders fileReaders, Category category, String item){
        return switch (category) {
            case FOOTWEARS -> fileReaders.getFootwares().get(item).getProductQuantity();
            case CLOTHES -> fileReaders.getCloths().get(item).getProductQuantity();
        };
    }
    private double getThePrices(FileReaders fileReaders, Category category, String item){
        return switch (category) {
            case FOOTWEARS -> fileReaders.getFootwares().get(item).getProductPrice();
            case CLOTHES -> fileReaders.getCloths().get(item).getProductPrice();
        };
    }

    private void processProducts(String item, Category category, int quantity) {

        if ((getProductQuantity(fileReaders, category, item) - quantity) >= 0) {
            if (customerCart.containsKey(item)) {
                customerCart.get(item).setProductQuantity(customerCart.get(item).getProductQuantity() + quantity);
            } else {
                Product nProduct = new Product();
                nProduct.setProductName(item);
                nProduct.setCAT(category);
                nProduct.setProductPrice(getThePrices(fileReaders, category, item));
                nProduct.setProductQuantity(quantity);
                customerCart.put(item, nProduct);
            }
            getProductQuantity(fileReaders, category, item);
            System.out.println(item + " order made");
            System.out.println();
        } else {
            System.out.println("OUT OF STOCK");
            System.out.println();
        }
    }

    public void makePurchase(String item, int quantity) {
        Category category = getCategory(item);
        if (category != null) {
            switch (category) {
                case FOOTWEARS:
                    processProducts(item, Category.FOOTWEARS, quantity);
                    break;
                case CLOTHES:
                    processProducts(item, Category.CLOTHES, quantity);
                    break;
                default:
                    System.out.println("WE DO NOT SELL " + item + " HERE");
                    System.out.println();
            }
        } else {
            System.out.println("Invalid item: " + item);
        }
    }

    public void buy(Customer customer) {
        if (customer != null) {
            customer.setPurchaseCat(customerCart);
        } else {
            System.out.println("Error: Customer is null");
        }
    }
}
