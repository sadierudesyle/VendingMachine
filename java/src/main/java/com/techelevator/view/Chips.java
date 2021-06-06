package com.techelevator.view;

import java.math.BigDecimal;

public class Chips extends VendingMachineItem {

    public Chips(String slot, String name, BigDecimal price) {
        super(slot, "Chips", "Crunch Crunch, Yum!", name, price, 5);
    }

    @Override
    public void dispenseItem() {
        System.out.println("\nEnjoy your purchase: " + getName() + " for $" + getPrice()
                + "! " + this.getSound());
    }

}
