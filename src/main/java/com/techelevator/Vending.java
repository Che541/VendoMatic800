package com.techelevator;

public class Vending {

    private String slot;
    private String productName;
    private double price;
    private String type ;

    //constructor


    public Vending(String slot, String productName, double price, String type) {
        this.slot = slot;
        this.productName = productName;
        this.price = price;
        this.type = type;
    }
    //getters

    public String getSlot() {
        return slot;
    }

    public String getProductName() {
        return productName;
    }

    public double getPrice() {
        return price;
    }

    public String getType() {
        return type;
    }


    public void diplayVending(){

        System.out.println(getSlot()+"|"+getProductName()+"|"+getPrice()+"|"+getType());
    }

}
