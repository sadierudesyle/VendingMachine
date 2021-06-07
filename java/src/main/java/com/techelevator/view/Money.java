package com.techelevator.view;

import java.math.BigDecimal;

public class Money {

    //properties
    private BigDecimal userBalance;

    //constructor
    public Money () {
        this.userBalance = BigDecimal.valueOf(0.00).setScale(2);
    }

    //getter
    public BigDecimal getUserBalance() {
        return this.userBalance;
    }

    //Methods
    //Display balance
    public void displayCurrentBalance() {
        System.out.println("Current Money Provided: $" + getUserBalance());
    }

    //Add money
    public BigDecimal addMoney(BigDecimal addedMoney) {
        this.userBalance = this.userBalance.add(addedMoney);
        return userBalance;
    }

    //Subtract money
    public BigDecimal subtractMoney(BigDecimal moneySpent) {
        if (userBalance.compareTo(moneySpent) >= 0) {
            this.userBalance = userBalance.subtract(moneySpent);
            return userBalance;
        } else {
            System.out.println("Insufficient funds... your current balance is " +
                    userBalance + ". Please add money to proceed.");
        } return userBalance;
    }

    //Give change
    public void giveChange (Money money) {
            BigDecimal quarter = new BigDecimal("0.25");
            BigDecimal dime = new BigDecimal("0.10");
            BigDecimal nickel = new BigDecimal("0.05");

            BigDecimal quartersChange = this.userBalance.divideToIntegralValue(quarter);
            BigDecimal quarterRemainder = this.userBalance.remainder(quarter);
            BigDecimal dimesChange = quarterRemainder.divideToIntegralValue(dime);
            BigDecimal dimeRemainder = this.userBalance.remainder(dime);
            BigDecimal nickelsChange = dimeRemainder.divideToIntegralValue(nickel);

            System.out.println("\nYour change is: " + quartersChange + " Quarters, " +
                    dimesChange + " Dimes, and " + nickelsChange + " Nickels.");

            this.userBalance = BigDecimal.valueOf(0.00).setScale(2);
        }
    }


    //methods:
    //add money
    //subtract money
    //show balance
    //get change