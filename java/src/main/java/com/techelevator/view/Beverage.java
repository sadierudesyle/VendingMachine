package com.techelevator.view;

public class Beverage extends VendingMachineItem {

    public Beverage(String name, double price, String type, String slotLocation, String message) {
        super(name, price, "Beverage", slotLocation, "Glug Glug, Yum!");
    }

}
