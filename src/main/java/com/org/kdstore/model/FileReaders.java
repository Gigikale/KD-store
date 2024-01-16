package com.org.kdstore.model;

import com.org.kdstore.Category;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class FileReaders {
    private Map<String, Product> footwares = new HashMap<String, Product>();
    private Map<String, Product> cloths = new HashMap<String, Product>();

    public FileReaders(Map<String, Product> footwares, Map<String, Product> cloths) {
        this.footwares = footwares;
        this.cloths = cloths;
    }

    public FileReaders() {
    }

    public Map<String, Product> getFootwares() {
        return footwares;
    }

    public void setFootwares(Map<String, Product> footwares) {
        this.footwares = footwares;
    }

    public Map<String, Product> getCloths() {
        return cloths;
    }

    public void setCloths(Map<String, Product> cloths) {
        this.cloths = cloths;
    }

            public boolean reader (){
                File file = new File("src/main/resources/ProductFile.csv");
                try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
//                    reader.read();

                    String line = " ";
                    while ((line = reader.readLine()) != null) {
                        String[] row = line.split(",");

                        if (!row[0].equalsIgnoreCase("FOOTWEARS")) {
                            if (!row[1].equalsIgnoreCase("productName")) {
                                Product product = new Product();
                                product.setCAT(Category.FOOTWEARS);
                                product.setProductName(row[1]);
                                product.setProductPrice(Double.parseDouble(row[2]));
                                product.setProductQuantity(Integer.parseInt(row[3]));
                                ////Adding created product to footwears Map.
                                footwares.put(row[0], product);;
                            }
                            if (!row[1].equalsIgnoreCase("productName")) {
                                Product product = new Product();
                                product.setCAT(Category.CLOTHES);
                                product.setProductName(row[1]);
                                product.setProductPrice(Double.parseDouble(row[2]));
                                product.setProductQuantity(Integer.parseInt(row[3]));
                                //Adding created product to clothes Map.
                                cloths.put(row[0], product);
                            }
                        }
                    }
                    System.out.println("File Read Successfully");
                } catch (IOException e) {
                    System.out.println("File error");
                }
                return true;
            }



    public void writer () throws IOException {
        File file = new File("src/main/resources/ProductFile.csv");
        BufferedWriter writer = new BufferedWriter(new FileWriter(file));

        writer.write(" Footwear,Gucci_shoe,1,500,160\n");
        writer.write("Footwear,Gucci_shoe,1,500,160");
        writer.close();
    }

    public void viewProduct (Map<String, Product> product){
        System.out.println("%-18s %-18s -18s" );
        for (var item : product.values()){
            System.out.printf("%-18s %-18s %-18s",
                    item.getProductName(),
                    item.getProductPrice(),
                    item.getProductQuantity());
            System.out.println();

        }
    }
}
