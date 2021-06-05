package com.techelevator.view;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Inventory {

    //properties
    //private Map = new TreeMap<String, String>();

    //getters/setters? -- optional

    //method
    public static void main(String[] args) {

        File inventory = new File("vendingmachine.csv");

        try (Scanner scanner = new Scanner(inventory)) {
            while (scanner.hasNextLine()) {
                String output = scanner.nextLine();
                System.out.println(output);
            }
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }

    }

    //displayInventory()

}



    //Map iventoryItems = new TreeMap<>
    //restock() VendingMachine when program is called
    //[SLOT] | [NAME] | [PRICE] | [ITEM TYPE]
    // method: display items / has item ?


    //CLASSES NEEDED:
    //is customer $$ balance its own class?



    //Exception classes needed (maybe)--SoldOutException, NotEnoughMoney



    //MENU METHODS NEEDED:
    //[1] Method to display items using inventory info above.
    //Add this method [1] to CLI.


    //[2] Customer chooses to purchase an item.
    // This triggers another menu to run (need to create menu from Menu object):
    //Menu option #1: method to feed money. Goes to Log.txt.
    //Menu option #2: method to select product -- followed by a method to dispense IF successful. If successful, add to Log.txt.
    //Menu option #3: method to finish transaction -- followed by a method to make change. Add to Log.txt.
    // Add this method [2] to CLI.

    // [3] Exit
    // This closes the program.
    // Add this method [3] to CLI.



    //updates inventory with user input

    //Value for current balance--holds customer's money

    //
