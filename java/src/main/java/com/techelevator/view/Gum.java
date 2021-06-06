package com.techelevator.view;

public class Gum extends VendingMachineItem {

    public Gum(String slot, String name, String price) {
        super(slot, "Gum", "Chew Chew, Yum!", name, price, 5);
    }

    @Override
    public void dispenseItem() {
        System.out.println("Enjoy your purchase: " + getName() + "for $" + getPrice()
                + "! " + this.getSound());
    }

}
