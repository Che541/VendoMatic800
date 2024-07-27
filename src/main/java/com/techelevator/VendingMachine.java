package com.techelevator;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class VendingMachine {
    private List<Vending> items;

    public VendingMachine() {
        this.items = new ArrayList<>();
    }

    public void loadItemsFromFile(String filename) {
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split("\\|");
                if (parts.length == 4) {
                    String slot = parts[0];
                    String productName = parts[1];
                    double price = Double.parseDouble(parts[2]);
                    String type = parts[3];
                    Vending item = new Vending(slot, productName, price, type);
                    addItem(item);
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading the file: " + e.getMessage());
        }
    }
    public void addItem(Vending item) {
        items.add(item);
    }
    public void displayItems() {
        for (Vending item : items) {
            item.diplayVending();
        }
    }

}
