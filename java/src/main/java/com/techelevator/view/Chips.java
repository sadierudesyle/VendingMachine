package com.techelevator.view;

import java.util.TreeMap;

public class Chips extends VendingMachineItem {

    public Chips(String slot, String nameAndPrice, TreeMap<String, String> inventoryMap) {
        super(slot, nameAndPrice, inventoryMap);
    }
}
