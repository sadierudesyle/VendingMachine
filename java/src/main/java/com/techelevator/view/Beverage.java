package com.techelevator.view;

import java.util.TreeMap;

public class Beverage extends VendingMachineItem {

    public Beverage(String slot, String nameAndPrice, TreeMap<String, String> inventoryMap) {
        super(slot, nameAndPrice, inventoryMap);
    }
}
