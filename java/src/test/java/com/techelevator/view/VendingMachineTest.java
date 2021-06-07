package com.techelevator.view;

import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.List;

public class VendingMachineTest {

    Inventory inventoryTest = new Inventory();
    Money moneyTest = new Money();

    //test: happy path add money
    @Test
    public void vendingMachine_addsMoney_shouldReturnCorrectAmount() {
        //step 1 -- expected
        BigDecimal expected = new BigDecimal("5.00");

        //step 2 -- result
        BigDecimal result = moneyTest.addMoney(new BigDecimal("5.00"));

        //step 3 -- assert
        Assert.assertEquals(expected, result);
    }

    //test: happy path subtract money
    @Test
    public void vendingMachine_subtractsMoney_shouldReturnCorrectAmount() {
        //step 1
        BigDecimal expected = new BigDecimal("3.00");

        // result
        moneyTest.addMoney(new BigDecimal("5.00"));
        BigDecimal result = moneyTest.subtractMoney(new BigDecimal("2.00"));

        //assert
        Assert.assertEquals(expected, result);

    }


    //test: bad path--subtract less money than you have
    @Test
    public void vendingMachine_subtractMoreThanYouHave_shouldNotGoBelowZero() {
        //expected
        BigDecimal expected = new BigDecimal("1.00");

        //result
        moneyTest.addMoney(new BigDecimal("1.00"));
        BigDecimal result = moneyTest.subtractMoney(new BigDecimal("2.00"));

        //assert
        Assert.assertEquals(expected, result);
    }


    //test: happy path--select an item, check inventory
    @Test
    public void vendingMachine_selectItemPrice_shouldShowPrice() {
        //expected
        String expected = "3.05";

        //result
        String result = "";
        List<String[]> inventoryTestList = inventoryTest.inventoryList;
        for (String [] item : inventoryTestList) {
            if (item[0].equals("A1")) {
                result = item[2];
                Assert.assertEquals(expected, result);
            }
        }


//        //assert
//        Assert.assertEquals(expected, result);
    }


}









//test: bad path--try to select a product that doesn't exist
//    @Test
//    public void vendingMachine_selectInvalidProduct_shouldDeny() {
//        //expected
//        String expected = "";
//
//        //result
//        List<String[]> inventoryTestList = inventoryTest.inventoryList;
//        for (String [] item : inventoryTestList) {
//            inventoryTestList.
//        }
//
//        //assert
//    }
