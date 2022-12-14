package com.akshaj;

import java.util.Scanner;

public class Customer {
	Scanner in = new Scanner(System.in);
	private Account CustomerAccount;

	public Customer(Account customer) {
		this.CustomerAccount = customer;
	}

	Account start() {
		System.out.println("\nHi " + CustomerAccount.getName()+",");
		while (true) {
			System.out.println(
					"\nChoose the below services:-\n\n1.Deposit money.\t\t2.Withdraw money.\n3.Print Current Balance.\t99.Logout");
			System.out.print("\n>>");
			String choice = in.nextLine();
			String amount = "0";
			  switch (choice) {
				case "1":
					System.out.println("Enter amount to be deposited: ");
					amount = in.nextLine();
					CustomerAccount.depositMoney(amount);
					break;
				case "2":
					System.out.println("Enter amount to withdraw: ");
					amount = in.nextLine();
					CustomerAccount.withdrawMoney(amount);
					break;
				case "3":
					System.out.println("Current Balance: Rs." + CustomerAccount.getBalance());
					break;
				case "99":
					System.out.println("\tLogout successful");
					return CustomerAccount;
				default:
					System.out.println("Wrong Choice.");
					continue;
			  }
			
		}
		
	}
}
