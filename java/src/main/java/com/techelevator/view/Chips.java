package com.techelevator.view;

public class Chips extends VendingMachineItem {

    public Chips(String slot, String name, String price) {
        super(slot, "Chips", "Crunch Crunch, Yum!", name, price, 5);
    }

    @Override
    public void dispenseItem() {
        System.out.println("Enjoy your purchase: " + getName() + "for $" + getPrice()
                + "! " + this.getSound());
    }

}
