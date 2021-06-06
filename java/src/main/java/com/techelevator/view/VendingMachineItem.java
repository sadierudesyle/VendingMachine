package com.techelevator.view;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;
import java.util.TreeMap;

public abstract class VendingMachineItem {

    private String slot;
    private String nameAndPrice;
    private TreeMap<String, String> inventoryMap;


    public VendingMachineItem(String slot, String nameAndPrice, TreeMap<String, String> inventoryMap) {
        this.slot = slot;
        this.nameAndPrice = nameAndPrice;
        this.inventoryMap = inventoryMap;
    }

    public String getSlot() {
        return slot;
    }

    public String getNameAndPrice() {
        return nameAndPrice;
    }

    public TreeMap<String, String> getInventoryMap() {
        return inventoryMap;
    }

    public void splitItems(String[] items) {

        for (String slots : items) {

            String[] inventory = slots.split("[|]");
            String slot = inventory[0];
            String name = inventory[1];
            String price = ((inventory[2]));
            if (slot.startsWith("A")) {
                String chips = new String(name + price);
                displayItem(inventoryMap, slot, chips);
            } else if (slot.startsWith("B")) {
                String candy = new String(name + price);
                displayItem(inventoryMap, name, candy);
            } else if (slot.startsWith("C")) {
                String beverage = new String(name + price);
                displayItem(inventoryMap, slot, beverage);
            } else if (slot.startsWith("D")) {
                String gum = new String(name + price);
                displayItem(inventoryMap, slot, gum);
            }

        }
    }

    public void displayItem(TreeMap<String, String> inventoryMap, String slot, String nameAndPrice) {
        for (int i = 0; i < 5; i++) {
            inventoryMap.put(slot, nameAndPrice);
        }
    }

    public void displayMenu(String[] args) {

        File inventory = new File("vendingmachine.csv");

        try (Scanner scanner = new Scanner(inventory)) {
            try (PrintWriter writer = new PrintWriter(String.valueOf(inventoryMap))) {
                while (scanner.hasNextLine()) {
                    String line = scanner.nextLine();
                    System.out.println(line);
                    writer.append(line);
                    System.out.println(inventoryMap);
                }
            }
//                for (int i = 0; i < newItems.length; i++) {
//
//                }
            } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());

        }


    }

}


        //do we need methods for 1. dispense 2. has item 3. subtract item 4. sold out exception

