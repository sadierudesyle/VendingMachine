package com.techelevator.view;

import java.math.BigDecimal;

public class Beverage extends VendingMachineItem {

    public Beverage(String slot, String name, BigDecimal price) {
        super(slot, "Beverage", "Glug Glug, Yum!", name, price, 5);
    }

    @Override
    public void dispenseItem() {
        System.out.println("\nEnjoy your purchase: " + getName() + " for $" + getPrice()
                + "! " + this.getSound());
    }

}
