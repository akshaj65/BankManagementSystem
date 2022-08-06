package com.akshaj;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Scanner;
import com.akshaj.storage.MyCache;
import com.google.gson.Gson;

public class Admin {


	MyCache bnk=new MyCache("","bankDetails.txt");
	public String[] BANK_DETAILS=bnk.getArrFromFile();
	
	
	void start(int admAccNum,ArrayList<AdminAccount> SUAccounts,ArrayList<Account> CustAccounts) {
		Scanner in = new Scanner(System.in);
		System.out.println("\nHi " + SUAccounts.get(admAccNum).getName());
		MyCache custCache = new MyCache("", "customers.txt");
		MyCache admnCache= new MyCache("","adminUsers.txt");
		boolean exit=false;
		char opt;
		while (!exit) {
			System.out.println(
					"\nChoose the below services:-\n\n1.Enter Bank details: .\n2.Add new admin account.\n3.Print accounts opened in our bank.\n4.Print admin accounts.\n5.Backup Data.\n6.Restore Data.\n7.Wipe Data.\n99.Back");
			int choice = in.nextInt();
			switch (choice) {
			case 1:
				System.out.println("Fill the below details: ");
				Bank bank = new Bank("AKZ BANK", "100");
				in.nextLine();
				System.out.println("Enter your branch: ");
				String Branch = in.nextLine();
				System.out.println("Enter your IFSC code: ");
				String IfSC = in.nextLine();
				System.out.println("Enter your address: ");
				String Address = in.nextLine();
				Branch bankBranch = new Branch(IfSC, Branch, Address);
				String[] arr=new AdminAccount().getBankInfo(bank,bankBranch);
				bnk.storeArrToFile(arr);
				System.out.println("\n\tBank details updated");
				break;
			case 2:
				in.nextLine();
				String[] temp = new Signin().start();
				if (temp == null)
					break;
				String Name = temp[0];
				String Email = temp[1];
				String PhoneNumber = temp[2];
				String Password = temp[3];
				AdminAccount newAcc=new AdminAccount(Name, Email, PhoneNumber, Password);
				SUAccounts.add(newAcc);
				System.out.println(
						"\nAccount has been created.\nYour Account number is " + newAcc.getNumber());
				continue;
			case 3:
				System.out.println("\n            Accounts opened in our bank\n");
				Iterator<Account>  custIttr= CustAccounts.iterator();
				if(!custIttr.hasNext())System.out.println("Not yet opened");
				while(custIttr.hasNext()) {
					System.out.println(custIttr.next().toString() + "\n"); // toString method is created in accounts
																			// class
				}
				break;
			case 4:
				System.out.println("\n           Admin Accounts\n");
				Iterator<AdminAccount>  suIttr= SUAccounts.iterator();
				while(suIttr.hasNext()) {
					System.out.println(suIttr.next().toString() + "\n"); // toString method is created in accounts
																			// class
				}
				break;
			case 5:
				System.out.println("Do you want to Backup? [yes='y'or no='n']");
				opt=in.next().charAt(0);
				if(opt!='y') {
					System.out.println("\nOperation Cancelled\n");
					break;
				}
				//backup customer accounts
				custCache.storeArrToFile(custCache.convertToJson(CustAccounts,CustAccounts.get(0).getNoOfAccounts()));
				//backup admin accounts
				admnCache.storeArrToFile(admnCache .convertToJson(SUAccounts,SUAccounts.get(0).getNoOfAccounts()));
				System.out.println("\nBackup Complete\n");
				break;
			case 6:
				System.out.println("Do you want to restore the whole data? [yes='y'or no='n']");
				opt=in.next().charAt(0);
				if(opt!='y') {
					System.out.println("\nOperation Cancelled\n");
					break;
				}
				String[] cust=custCache.getArrFromFile();
				String[] admn=admnCache.getArrFromFile();
				//restore customer accounts
				CustAccounts=new Account().convertToObject(cust[1]);
				CustAccounts.get(0).setNoOfAccounts(Integer.parseInt(cust[0]));
				new Main().setAccounts(CustAccounts);
				//restore admin accounts
				SUAccounts=new AdminAccount().convertToObject(admn[1]);
				SUAccounts.get(0).setNoOfAccounts(Integer.parseInt(admn[0]));
				new Main().setSUAccounts(SUAccounts);
				System.out.println("Data Restored\n");
				break;
			case 7:
				System.out.println("Do you want to erase the whole data? [yes='y'or no='n']");
				opt=in.next().charAt(0);
				if(opt=='y') {
					CustAccounts.clear();
					SUAccounts.clear();
					admnCache.remove();
					custCache.remove();
					bnk.remove();
					System.out.println("Data Erased Successfuly\n");
				}else{
					System.out.println("\nOperation Cancelled\n");
				}
				break;
			case 99:
				System.out.println("\tLogout successful");
				exit=true;
				break;
			default:
				System.out.println("Wrong Choice.");
			}
		}
	}

}
