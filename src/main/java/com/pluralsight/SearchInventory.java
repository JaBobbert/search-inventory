package com.pluralsight;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

// Starter for Search Inventory (Workbook 3a, Section 3-2 Using an ArrayList, Exercise 1).
// main is done: it asks getInventory() for the list and prints every product.
// Your job is getInventory(): fill the list with at least 5 products.
public class SearchInventory {
    public static void main(String[] args) {
        ArrayList<Product> inventory = getInventory();

        for (Product product : inventory) {
            System.out.println(product);
        }

        inventory.sort(Comparator.comparing(Product::getName));
        for (int i = 0; i < inventory.size() ; i++) {
            System.out.println((i+1) + ". " + inventory.get(i));

        }

    }

    public static ArrayList<Product> getInventory() {
        ArrayList<Product> inventory = new ArrayList<>();

        String fileName = "inventory.csv";
        List<String[]> records = new ArrayList<>();

        try {
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            String line;

            while ((line = reader.readLine()) != null){
                String[] items = line.split("\\|");
                records.add(items);

            }
        } catch (IOException e) {
            System.err.println("Something is not correct " + e.getMessage());
        }

        for (String[] row : records){
            System.out.println(java.util.Arrays.toString(row));
        }

        return inventory;
    }
}
