package com.techelevator.view;

import java.util.TreeMap;

public class Candy extends VendingMachineItem {

    public Candy(String slot, String nameAndPrice, TreeMap<String, String> inventoryMap) {
        super(slot, nameAndPrice, inventoryMap);
    }
}
