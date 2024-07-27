package com.techelevator.vend;

import com.techelevator.Vending;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import com.techelevator.vend.Chip;

public class Inventory {

    private static final String DEFAULT_INVENTORY_FILEPATH = "vendingmachine.csv";
    //private Map<String, Slot> slots = new HashMap<>();

    public Inventory() {
    }

    /*public void addSlot(Slot slot){
        this.slots.put(slot.getName(), slot);
    } */

    public static Map<String, Slot> generateSlots(String filename) {
        Map<String, Slot> slots = new LinkedHashMap<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] splitLine = line.split("\\|");
                Slot slot = generateFilledSlot(splitLine);
                slots.put(slot.getName(), slot);
            }
        } catch (IOException | IllegalAccessException e) {
            System.err.println(e.getMessage());
        } catch (ClassNotFoundException e) {
            System.err.println("Class not found: " + e.getMessage());
        } catch (InstantiationException e) {
            System.err.println("Instantiation problem: " + e.getMessage());
        }

        return slots;
    }

    public static Map<String, Slot> generateSlots() {
        return generateSlots(DEFAULT_INVENTORY_FILEPATH);
    }


    public static Slot generateFilledSlot(String[] splitLine) throws ClassNotFoundException, InstantiationException, IllegalAccessException {

        String slotName = splitLine[0];
        String itemName = splitLine[1];
        Double itemPrice = Double.parseDouble(splitLine[2]);
        String itemSubclassName = splitLine[3];
        Item item = null;

        if(itemSubclassName.equals("Chip")){
            item = new Chip();
        }

        if(itemSubclassName.equals("Candy")){
            item = new Candy();
        }

        if(itemSubclassName.equals("Gum")){
            item = new Gum();
        }

        if(itemSubclassName.equals("Drink")){
            item = new Drink();
        }

        item.setName(itemName);
        item.setPrice(itemPrice);

        /*String className = splitLine[3].strip();
        Class<?> itemClass = Class.forName(className);
        Object item = itemClass.newInstance();
        if(item instanceof Item){
            ((Item) item).setName(splitLine[1]);
            ((Item) item).setPrice(Double.parseDouble(splitLine[2]));

        } */

        Slot slot = new Slot(slotName, item);

        return slot;
    }


}
