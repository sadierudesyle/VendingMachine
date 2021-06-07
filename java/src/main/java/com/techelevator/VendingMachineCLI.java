package com.techelevator;

import com.techelevator.view.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.Map;
import java.util.Scanner;

public class VendingMachineCLI {

	//Main Menu
	private static final String MAIN_MENU_OPTION_DISPLAY_ITEMS = "Display Vending Machine Items";
	private static final String MAIN_MENU_OPTION_PURCHASE = "Purchase";
	private static final String MAIN_MENU_OPTION_EXIT = "Exit";
	private static final String[] MAIN_MENU_OPTIONS = { MAIN_MENU_OPTION_DISPLAY_ITEMS,
			MAIN_MENU_OPTION_PURCHASE, MAIN_MENU_OPTION_EXIT };

	//Purchase Menu
	private static final String PURCHASE_MENU_OPTION_FEED_MONEY = "Feed Money";
	private static final String PURCHASE_MENU_OPTION_SELECT_PRODUCT = "Select Product";
	private static final String PURCHASE_MENU_OPTION_FINISH_TRANSACTION = "Finish Transaction";
	private static final String[] PURCHASE_MENU_OPTIONS = { PURCHASE_MENU_OPTION_FEED_MONEY,
	PURCHASE_MENU_OPTION_SELECT_PRODUCT, PURCHASE_MENU_OPTION_FINISH_TRANSACTION};

	//Feed Money Menu
	private static final String ONE_DOLLAR_BILL = "$1";
	private static final String TWO_DOLLAR_BILL = "$2";
	private static final String FIVE_DOLLAR_BILL = "$5";
	private static final String TEN_DOLLAR_BILL = "$10";
	private static final String TWENTY_DOLLAR_BILL = "$20";
	private static final String FIFTY_DOLLAR_BILL = "$50";
	private static final String HUNDRED_DOLLAR_BILL = "$100";
	private static final String BACK_TO_MENU = "Back to Purchase Menu";
	private static final String[] FEED_MONEY_MENU_OPTIONS = {ONE_DOLLAR_BILL, TWO_DOLLAR_BILL,
	FIVE_DOLLAR_BILL, TEN_DOLLAR_BILL, TWENTY_DOLLAR_BILL, FIFTY_DOLLAR_BILL,
	HUNDRED_DOLLAR_BILL, BACK_TO_MENU};


	private Inventory inventory = new Inventory();
	private Money money = new Money();
	private Logger logger = new Logger();


	private Menu menu;
	public VendingMachineCLI(Menu menu) {
		this.menu = menu;
	}




	public void run() {
		inventory.listFromFile();
		inventory.mapFromList(); //restocking
		System.out.println("\nTry the new Vendo-Matic 800, presented by Umbrella Corp.!");
		while (true) {
			String choice = (String) menu.getChoiceFromOptions(MAIN_MENU_OPTIONS);

			if (choice.equals(MAIN_MENU_OPTION_DISPLAY_ITEMS)) {
				inventory.displayItems();

			} else if (choice.equals(MAIN_MENU_OPTION_PURCHASE)) {
				boolean purchase = true;
				while (purchase) {
					money.displayCurrentBalance();
					String purchaseChoice = (String) menu.getChoiceFromOptions(PURCHASE_MENU_OPTIONS);


					if (purchaseChoice.equals(PURCHASE_MENU_OPTION_FEED_MONEY)) {
						boolean feed = true;
						while (feed) {
							money.displayCurrentBalance();
							String feedChoice = (String) menu.getChoiceFromOptions(FEED_MONEY_MENU_OPTIONS);
							if (feedChoice.equals(ONE_DOLLAR_BILL)) {
								logger.log("FEED MONEY: ", "1.00",
										money.getUserBalance().add(BigDecimal.valueOf(1.00)).toString());
								money.addMoney(BigDecimal.valueOf(1.00));
							} else if (feedChoice.equals(TWO_DOLLAR_BILL)) {
								logger.log("FEED MONEY: ", "2.00",
										money.getUserBalance().add(BigDecimal.valueOf(2.00)).toString());
								money.addMoney(BigDecimal.valueOf(2.00));
							} else if (feedChoice.equals(FIVE_DOLLAR_BILL)) {
								logger.log("FEED MONEY: ", "5.00",
										money.getUserBalance().add(BigDecimal.valueOf(5.00)).toString());
								money.addMoney(BigDecimal.valueOf(5.00));
							} else if (feedChoice.equals(TEN_DOLLAR_BILL)) {
								logger.log("FEED MONEY: ", "10.00",
										money.getUserBalance().add(BigDecimal.valueOf(10.00)).toString());
								money.addMoney(BigDecimal.valueOf(10.00));
							} else if (feedChoice.equals(TWENTY_DOLLAR_BILL)) {
								logger.log("FEED MONEY: ", "20.00",
										money.getUserBalance().add(BigDecimal.valueOf(20.00)).toString());
								money.addMoney(BigDecimal.valueOf(20.00));
							} else if (feedChoice.equals(FIFTY_DOLLAR_BILL)) {
								logger.log("FEED MONEY: ", "50.00",
										money.getUserBalance().add(BigDecimal.valueOf(50.00)).toString());
								money.addMoney(BigDecimal.valueOf(50.00));
							} else if (feedChoice.equals(HUNDRED_DOLLAR_BILL)) {
								logger.log("FEED MONEY: ", "100.00",
										money.getUserBalance().add(BigDecimal.valueOf(100.00)).toString());
								money.addMoney(BigDecimal.valueOf(100.00));
							} else if (feedChoice.equals(BACK_TO_MENU)) {
								feed = false;
							}
						}
					}




					else if (purchaseChoice.equals(PURCHASE_MENU_OPTION_SELECT_PRODUCT)) {
						//Select product options

						inventory.displayItems();

						Scanner scanner = new Scanner(System.in);

						System.out.print("\nPlease input product slot: ");
						String userSelection = scanner.nextLine().toUpperCase();

						boolean validSlot = false;

						for (Map.Entry<String, VendingMachineItem> entry : inventory.mapFromList().entrySet()) {
							if (userSelection.equalsIgnoreCase(entry.getKey())) {
								validSlot = true;
							}
						}

						if (validSlot) {

							for (VendingMachineItem key : inventory.mapFromList().values()) {

								if (key.getSlot().equalsIgnoreCase(userSelection)) {

									if (key.getPrice().compareTo(money.getUserBalance()) >= 0) {
										System.out.println("\nSorry, you have insufficient funds. Add more money to proceed.");
										break;
									} else if (key.getQuantity() <= 0) {
										System.out.println("Sorry, we're sold out!");
										break;
									} else {
										key.dispenseItem();
										key.reduceQuantity();
										this.money.subtractMoney(key.getPrice());
//										if (key.getQuantity() > 0) {
//											key.dispenseItem();
//											this.money.subtractMoney(key.getPrice());
//											try (PrintWriter write = new PrintWriter(String.valueOf(inventory))) {
//												write.println(userSelection.replaceAll(String.valueOf(key.getQuantity()), String.valueOf(key.reduceQuantity())));
//											} catch (FileNotFoundException e) {
//												System.out.println(e.getMessage());
//											}
//										}

//									key.setQuantity(key.reduceQuantity());

//									System.out.println("Your current balance is $" + this.money.getUserBalance());
//									logger.log(key.getName() + " " + key.getSlot(), this.money.getUserBalance().toString(),
//											this.money.getUserBalance().subtract(key.getPrice()).toString());
//									menu.getChoiceFromOptions(PURCHASE_MENU_OPTIONS);
									}
								}
							}


							} else if (!validSlot) {
								System.out.println("\nOops! Invalid slot entry.");
							}


						}







					else if (purchaseChoice.equals(PURCHASE_MENU_OPTION_FINISH_TRANSACTION)) {
						//Finish transaction--makes you hit this button twice?
						logger.log("GIVE CHANGE", money.getUserBalance().toString(), "0.00");
						money.giveChange(money);
						System.out.println("\nTransaction complete. Back to Main Menu:");
						purchase = false;
					}
				}


			} else if (choice.equals(MAIN_MENU_OPTION_EXIT)) {
				System.out.println("\nTransaction complete.\nThank you for stopping by!");
				System.exit(0);
			}
		}
	}


	public static void main(String[] args) {
		Menu menu = new Menu(System.in, System.out);
		VendingMachineCLI cli = new VendingMachineCLI(menu);
		cli.run();
	}



	//call purchase menu (extend menu):
	//1. Feed Money (calls from Money class)
	//2. Select Product (calls from Items class)
	//3. Finish transaction (calls from Money class--gives change) & return to Main menu


}
