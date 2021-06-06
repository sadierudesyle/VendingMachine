package com.techelevator.view;

public class Beverage extends VendingMachineItem {

    public Beverage(String slot, String name, String price) {
        super(slot, "Beverage", "Glug Glug, Yum!", name, price, 5);
    }

    @Override
    public void dispenseItem() {
        System.out.println("Enjoy your purchase: " + getName() + "for $" + getPrice()
                + "! " + this.getSound());
    }

}
