package com.pluralsight;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

// Starter for Search Inventory (Workbook 3a, Section 3-2 Using an ArrayList, Exercise 1).
// main is done: it asks getInventory() for the list and prints every product.
// Your job is getInventory(): fill the list with at least 5 products.
public class SearchInventory {
    public static void main(String[] args) {
        ArrayList<Product> inventory = getInventory();

        for (Product product : inventory) {
            System.out.println(product);
        }

        System.out.println("Sorted Version");
        Collections.sort(inventory, Comparator.comparing(Product::getName));
        for (int i = 0; i < inventory.size() ; i++) {
            System.out.println((i+1) + ". " + inventory.get(i));

        }

    }

    public static ArrayList<Product> getInventory() {
        ArrayList<Product> inventory = new ArrayList<>();

        String fileName = "inventory.csv";


        try {
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            String line;

            while ((line = reader.readLine()) != null){
                String[] items = line.split("\\|");
                int id = Integer.parseInt(items[0]);
                String name = items[1];
                double price = Double.parseDouble(items[2]);
                inventory.add(new Product(id, name, price));
            }
            reader.close();

        } catch (IOException e) {
            System.err.println("Something is not correct " + e.getMessage());
        }




        return inventory;
    }
}
