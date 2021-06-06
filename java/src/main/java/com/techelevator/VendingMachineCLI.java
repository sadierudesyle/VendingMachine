package com.techelevator;

import com.techelevator.view.Inventory;
import com.techelevator.view.Menu;
import com.techelevator.view.Money;

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
	//private Logger logger = new Logger();


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
				// do purchase
			} else if (choice.equals(MAIN_MENU_OPTION_EXIT)) {
				// close program
				System.out.println("\nTransaction complete.\nThank you for stopping by!");
				System.exit(1);
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
