package com.techelevator;

import com.techelevator.vend.VendingMachine;
import com.techelevator.vend.Menu;


import java.time.LocalDateTime;
import java.util.Scanner;

import static com.techelevator.vend.VendLog.*;

public class Application {

	public static void main(String[] args) {


		VendingMachine vendingMachine = new VendingMachine();
		Menu menu = new Menu(vendingMachine);
		menu.mainMenu();

		//generateSalesReport(vendingMachine.getSTARTING_TIMESTAMP());

		//System.out.println(vendingMachine.getSlots().get("C1").getSlottedItem().getSoundEffect());
		//System.out.println(vendingMachine.slotsToString());
		//System.out.println(vendingMachine.getSlots());
		//log(generateMessage(LocalDateTime.now(), "Test2: ", 11.235, 1.0));
		 //Menu menu=new Menu();
		 //menu.diplayMenu();

	}
}