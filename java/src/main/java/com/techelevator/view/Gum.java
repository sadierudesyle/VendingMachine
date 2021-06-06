package com.techelevator.view;

import java.math.BigDecimal;

public class Gum extends VendingMachineItem {

    public Gum(String slot, String name, BigDecimal price) {
        super(slot, "Gum", "Chew Chew, Yum!", name, price, 5);
    }

    @Override
    public void dispenseItem() {
        System.out.println("\nEnjoy your purchase: " + getName() + " for $" + getPrice()
                + "! " + this.getSound());
    }

}
