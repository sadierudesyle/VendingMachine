package com.techelevator.view;

import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.util.*;


public class Inventory {

    List <String[]> inventoryList = new ArrayList<>();
    Map<String, VendingMachineItem> inventoryMap = new TreeMap<>();
    File inventory = new File("vendingmachine.csv");

    //turning vendingmachine.csv into a List of String[]
    public List <String[]> listFromFile() {

        try (Scanner scanner = new Scanner(inventory)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] inventoryArray = line.split("\\|");
                inventoryList.add(inventoryArray);
                }
            } catch (FileNotFoundException e) {
            System.out.println("Sorry, we're having a problem stocking inventory!");
        } catch (Exception ex) {
            System.out.println("Sorry, try again! An error has occurred!");
            //ex.printStackTrace();
        } return inventoryList;
    }

    //turning inventory List<String[]> above into TreeMap (key: slot, value: VMItem)
    public Map<String, VendingMachineItem> mapFromList() {
        for (String[] item : inventoryList) {
            if (item[3].equalsIgnoreCase("Candy")) {
                BigDecimal candyValue = new BigDecimal(item[2]);
                Candy candy = new Candy(item[0], item[1], candyValue);
                inventoryMap.put(item[0], candy);
            } else if (item[3].equalsIgnoreCase("Chip")) {
                BigDecimal chipValue = new BigDecimal(item[2]);
                Chips chips = new Chips(item[0], item[1], chipValue);
                inventoryMap.put(item[0], chips);
            } else if (item[3].equalsIgnoreCase("Drink")) {
                BigDecimal drinkValue = new BigDecimal(item[2]);
                Beverage beverage = new Beverage(item[0], item[1], drinkValue);
                inventoryMap.put(item[0], beverage);
            } else if (item[3].equalsIgnoreCase("Gum")) {
                BigDecimal gumValue = new BigDecimal(item[2]);
                Gum gum = new Gum(item[0], item[1], gumValue);
                inventoryMap.put(item[0], gum);
            }
        } return inventoryMap;
    }

    //Inventory method: display items
    public void displayItems() {
        for (String key : inventoryMap.keySet()) {
            System.out.println(key.toString() + " " + inventoryMap.get(key).getName() +
            " $" + inventoryMap.get(key).getPrice() + " Quantity: " +
                    inventoryMap.get(key).getQuantity());
        }
    }

    public void outOfStock() {
        for (String key : inventoryMap.keySet()) {
            inventoryMap.get(key).getQuantity();
        }

    }

//    public void getDecreaseQuantity() {
//        Integer stock = 5;
//        Integer itemPurchased = stock - 1;
//    }


    }










































//public Map<VendingMachineItem> displayInventory()throws FileNotFoundException{
//        Map<VendingMachineItem> itemList=new TreeMap();
//        File file=new File("vendingmachine.csv");
//        Scanner fileInput=new Scanner(file);
//
//        while(fileInput.hasNextLine()){
//        String line=fileInput.nextLine();
//        String[]inputInfo=line.split("\\|");
//        }
//
//        }


















































//    private String slot;
//    private String name;
//    private Double price;
//    private String type;
//    private TreeMap<String, Double> inventoryMap;

//    public Inventory (TreeMap<String, String> inventoryMap, String slot, String nameAndPrice) {
//        super(slot, nameAndPrice, inventoryMap);
//        this.inventoryMap = inventoryMap;
//        this.slot = slot;
//        this.name = name;
//        this.price = price;
//        this.type = type;

//    public String getSlot() {
//        return slot;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public Double getPrice() {
//        return price;
//    }
//
//    public String getType() {
//        return type;
//    }
//
//    public TreeMap<String, Double> getInventoryMap() {
//        return inventoryMap;
//    }



    //properties
    //private Map = new TreeMap<String, String>();

    //getters/setters? -- optional

    //method
//    public void main(String[] args) {
//
//        File inventory = new File("vendingmachine.csv");
//
//        try (Scanner scanner = new Scanner(inventory)) {
//            while (scanner.hasNextLine()) {
//                String output = scanner.nextLine();
//                System.out.println(output);
//                String[] newItems = output.split("//|");
//                System.out.println(Arrays.toString(newItems));
////                for (int i = 0; i < newItems.length; i++) {
////
////                }
//            }
//        } catch (FileNotFoundException e) {
//            System.out.println(e.getMessage());
//        }
//
//
//    }


//    private void inventoryMap() {
//
//        for (getName : getPrice) {
//
//            String[] inventory = snackLine.split("[|]");
//            String slot = inventory[0];
//            String name = inventory[1];
//            double price = Double.parseDouble((inventory[2]));
//            if (slot.startsWith("A")) {
//                Chips item = new Chips(name, price);
//                (inventoryMap, slot, item);
//            } else if (slot.startsWith("B")) {
//                Candy item = new Candy(name, price);
//                itemLoader(inventoryMap, slot, item);
//            } else if (slot.startsWith("C")) {
//                Beverage item = new Beverage(name, price);
//                itemLoader(inventoryMap, slot, item);
//            } else if (slot.startsWith("D")) {
//                Gum item = new Gum(name, price);
//                itemLoader(inventoryMap, slot, item);
//            }
//
//        }
//
//public void displayItem(TreeMap<String, Double> inventoryMap, String name, Double price) {
//    for (int i = 0; i < 5; i++) {
//        inventoryMap.put(name, price);
//    }
//}
//}




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
