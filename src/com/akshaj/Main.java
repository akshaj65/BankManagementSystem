package com.akshaj;

import java.util.Scanner;
import com.akshaj.storage.MyCache;

public class Main {

    public final static  String ACC_NUMBR="10102";
    public final static  String SU_ACC_NUMBR="10001";
    final static int SIZE=100;
    private static Account accounts[] = new Account[SIZE];
    private static AdminAccount superUsers[] = new AdminAccount[SIZE/10];
	public Account[] getAccounts() {
		return accounts.clone();
	}
	AdminAccount[] getSUAccounts() {
		return superUsers.clone();
	}


	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		superUsers[0]= new AdminAccount(SU_ACC_NUMBR+0,"system","admin@system");
		int accountNum=0;
//		MyCache custFile = new MyCache("", "customers.txt");
		System.out.println("            Akz Bank");
		System.out.println("\n       Welcome to Akz Bank");
		System.out.println("           "+new Time().now());
		System.out.println("\n\nChoose below services :-");
		while(true) {
			System.out.println("\n1.Open a new account \n2.Customer Login\n3.Admin Login\n99.Exit");
			int choice= in.nextInt();
			int custPos=0,admnPos=1;
			String  AccountNumber="";
				switch(choice) {
					case 1:
						String[] BankDetails=new Admin().BANK_DETAILS;
						in.nextLine();
						String[] temp=new Signin().start();
						if(temp==null) break;
						String Name= temp[0];
						String Email=temp[1];
						String PhoneNumber=temp[2];
						String Password=temp[3];
						AccountNumber=ACC_NUMBR+String.valueOf(accountNum);
						accounts[accountNum++]=new Account(AccountNumber,0.0,Name,Email,PhoneNumber,Password,BankDetails);
//						custFile.storeObjArrToFile(accounts);
						System.out.println("\nAccount has been created.\nYour Account number is "+accounts[accountNum-1].getNumber());
						break;
					case 2:
						System.out.println("        Customer Login");
						System.out.println("\nEnter your account number: ");
						in.nextLine();
						AccountNumber= in.nextLine();
						custPos=(AccountNumber.length()>ACC_NUMBR.length())? Integer.valueOf(AccountNumber.replace(ACC_NUMBR,"")):-1; //returns index of the array
						if((custPos<0 || custPos>7 )||accounts[custPos]==null) {
							System.out.println("Incorrect Account Number");
							break;
						}
						System.out.println("Enter your Password (8<password<20): ");
						Password= in.nextLine();
						if(!Password.equals(accounts[custPos].getPassword())) {
							System.out.println("Incorrect Password");
							break;
						}
						accounts[custPos]=new Customer(accounts[custPos]).start();
						break;
					case 3:
						System.out.println("        Admin Login");
						System.out.println("\nEnter your account number: ");
						in.nextLine();
						AccountNumber= in.nextLine();
						admnPos=(AccountNumber.length()>ACC_NUMBR.length())? Integer.valueOf(AccountNumber.replace(SU_ACC_NUMBR,"")):-1; //returns index of the array
						if((admnPos<0 || admnPos>=7 )||superUsers[admnPos]==null) {
							System.out.println("Incorrect Account Number");
							break;
						}
						System.out.println("Enter your Password (8<password<20): ");
						Password= in.nextLine();
						if(!Password.equals(superUsers[admnPos].getPassword())) {
							System.out.println("Incorrect Password");
							break;
						}
						new Admin().start(accountNum,admnPos,superUsers,accounts);
						
						
						break;
					
					case 99 :
				    	System.out.println("\tThank You. Have A Nice Day :)");
				    	System.exit(0);
				    default :
				    	System.out.println("Wrong Choice.");
					
			}		
		}
		
	}

}
