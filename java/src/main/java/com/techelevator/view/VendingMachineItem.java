package com.techelevator.view;

import org.w3c.dom.ls.LSOutput;

import java.math.BigDecimal;

public abstract class VendingMachineItem {

    //properties
    private String slot;
    private String type;
    private String sound;
    private String name;
    private BigDecimal price;
    private int quantity;


    //constructor
    public VendingMachineItem(String slot, String type, String sound, String name,
                              BigDecimal price, int quantity) {
        this.slot = slot;
        this.type = type;
        this.sound = sound;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    //getters

    public String getSlot() {
        return this.slot;
    }

    public String getType() {
        return this.type;
    }

    public String getSound() {
        return this.sound;
    }

    public String getName() {
        if (quantity == 0) {
            return "SOLD OUT!";
        }
        return this.name;
    }

    public BigDecimal getPrice() {
        return this.price;
    }

    public int getQuantity() {
        return this.quantity;
    }

    //setters
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    //methods
    public int reduceQuantity() {
        if (quantity > 0) {
            this.quantity -= 1;
        }
        else {
            System.out.println(("SORRY, SOLD OUT!"));
        } return quantity;
    }

    //abstract methods--each item has to call this separately
    public abstract void dispenseItem();


    }


















































//    public void splitItems(String[] items) {
//
//        for (String slots : items) {
//
//            String[] inventory = slots.split("[|]");
//            String slot = inventory[0];
//            String name = inventory[1];
//            String price = ((inventory[2]));
//            if (slot.startsWith("A")) {
//                String chips = new String(name + price);
//                displayItem(inventoryMap, slot, chips);
//            } else if (slot.startsWith("B")) {
//                String candy = new String(name + price);
//                displayItem(inventoryMap, name, candy);
//            } else if (slot.startsWith("C")) {
//                String beverage = new String(name + price);
//                displayItem(inventoryMap, slot, beverage);
//            } else if (slot.startsWith("D")) {
//                String gum = new String(name + price);
//                displayItem(inventoryMap, slot, gum);
//            }
//
//        }
//    }
//
//    public void displayItem(TreeMap<String, String> inventoryMap, String slot, String nameAndPrice) {
//        for (int i = 0; i < 5; i++) {
//            inventoryMap.put(slot, nameAndPrice);
//        }
//    }
//}


















































//    public void displayMenu(String[] args) {
//
//        File inventory = new File("vendingmachine.csv");
//
//        try (Scanner scanner = new Scanner(inventory)) {
//            try (PrintWriter writer = new PrintWriter(String.valueOf(inventoryMap))) {
//                while (scanner.hasNextLine()) {
//                    String line = scanner.nextLine();
//                    System.out.println(line);
//                    writer.append(line);
//                    System.out.println(inventoryMap);
//                }
//            }
////                for (int i = 0; i < newItems.length; i++) {
////
////                }
//            } catch (FileNotFoundException e) {
//            System.out.println(e.getMessage());
//
//        }
//
//
//    }
//
//}


        //do we need methods for 1. dispense 2. has item 3. subtract item 4. sold out exception

