package com.techelevator;

import java.util.Scanner;

public class Menu {

    public void diplayMenu()
    {
        Scanner scanner = new Scanner(System.in);
        boolean exit = true;
        System.out.println("*****************************");
        System.out.println("*      Vending Machine      *");
        System.out.println("*****************************");

        System.out.println("(1) Display Vending Machine Items");
        System.out.println("(2) Purchase");
        System.out.println("(3) Exit");
        System.out.println("Please enter your choice !");
        while (exit) {
            int choice=scanner.nextInt();
            switch (choice){

                case 1:
                    VendingMachine vendingmachine =new VendingMachine();
                    vendingmachine.loadItemsFromFile("*\\vendingmachine.csv");
                    vendingmachine.displayItems();

                    break;
                case 2 :

                    System.out.println("2");
                    break;
                case 3 :

                    System.out.println("Exiting the program. Have a nice day!");
                    exit=false;
                    break;
                default:
                    System.out.println("invalid number try again plase ");


            }

        }

    }


}

