package com.techelevator.view;

public class Candy extends VendingMachineItem {

    public Candy(String slot, String name, String price) {
        super(slot, "Candy", "Munch Much, Yum!", name, price, 5);
    }

    @Override
    public void dispenseItem() {

        System.out.println("Enjoy your purchase: " + getName() + "for $" + getPrice()
        + "! " + this.getSound());
    }

}
