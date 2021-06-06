package com.techelevator.view;

import java.math.BigDecimal;

public class Candy extends VendingMachineItem {

    public Candy(String slot, String name, BigDecimal price) {
        super(slot, "Candy", "Munch Much, Yum!", name, price, 5);
    }

    @Override
    public void dispenseItem() {

        System.out.println("\nEnjoy your purchase: " + getName() + " for $" + getPrice()
        + "! " + this.getSound());
    }

}
