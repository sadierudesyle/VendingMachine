package com.techelevator.view;

public abstract class VendingMachineItem {

    private String name;
    private double price;
    private String type;
    private String slotLocation;
    private String message;

    public VendingMachineItem(String name, double price, String type, String slotLocation, String message) {
        this.name = name;
        this.price = price;
        this.type = type;
        this.slotLocation = slotLocation;
        this.message = message;
    }

    public String getName() {
        return this.name;
    }

    public double getPrice() {
        return this.price;
    }

    public String getType() {
        return this.type;
    }

    public String getSlotLocation() {
        return this.slotLocation;
    }


    //do we need methods for 1. dispense 2. has item 3. subtract item 4. sold out exception

}
