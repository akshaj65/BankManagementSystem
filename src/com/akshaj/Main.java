package com.akshaj;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

import com.akshaj.storage.MyCache;

public class Main {

    public final static  int ACC_NUMBR=10102;
    public final static  int SU_ACC_NUMBR=10001;
    private static ArrayList<Account> Accounts=new ArrayList<Account>();
    private static ArrayList<AdminAccount> SuperUsers=new ArrayList<AdminAccount>();
	public void setAccounts(ArrayList<Account> accounts) {
		Accounts=accounts;
	}
	public void setSUAccounts(ArrayList<AdminAccount> superusers) {
		SuperUsers=superusers;
	}

    
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("            Akz Bank");
		System.out.println("\n       Welcome to Akz Bank");
		System.out.println("           "+new Time().now());
		while(true) {
			System.out.println("\n\nChoose the below services :-");
			System.out.println("\n1.Open a new account \n2.Customer Login\n3.Admin Login\n99.Exit");
			String choice= in.nextLine();
			int custPos=0,admnPos=1;
			String  AccountNumber="";
			String accNumStr="";
				switch(choice) {
					case "1":
						String[] BankDetails=new Admin().BANK_DETAILS;
						if(BankDetails.length==0) {	
							System.out.println("\n      Please contact Admin [Bank Details not filled]");
							break;
						}
						String[] temp=new Signin().start();
						if(temp==null) break;
						String Name= temp[0];
						String Email=temp[1];
						String PhoneNumber=temp[2];
						String Password=temp[3];
						Account newAcc=new Account(0.0,Name,Email,PhoneNumber,Password,BankDetails);
						Accounts.add(newAcc);
						System.out.println("\nAccount has been created.\nYour Account number is "+newAcc.getNumber());
						break;
					case "2":
						System.out.println("        Customer Login");
						System.out.println("\nEnter your account number: ");
						try {
							AccountNumber= in.nextLine();
							accNumStr=Integer.toString(ACC_NUMBR);
							custPos=(AccountNumber.length()>accNumStr.length())? Integer.valueOf(AccountNumber.replace(accNumStr,"")):-1; //returns index of the array
							if(custPos<0 || custPos>=Accounts.size()) {
								System.out.println("Incorrect Account Number");
								break;
							}
							System.out.println("Enter your Password (8<password<20): ");
							Password= in.nextLine();
							if(!Password.equals(Accounts.get(custPos).getPassword())) {
								System.out.println("Incorrect Password");
								break;
							}
							Accounts.set(custPos, new Customer(Accounts.get(custPos)).start());
						}catch(NumberFormatException e){
							System.out.println("Data Incorrect {NumberFormatException}");
						}
						break;
					case "3":
						if(SuperUsers.isEmpty()) SuperUsers.add(new AdminAccount("system","admin@system"));
						System.out.println("        Admin Login");
						System.out.println("\nEnter your account number: ");
						try {
							AccountNumber= in.nextLine();
							accNumStr=Integer.toString(SU_ACC_NUMBR);
							admnPos=(AccountNumber.length()>accNumStr.length())? Integer.valueOf(AccountNumber.replace(accNumStr,"")):-1; //returns index of the array
							if(admnPos<0 || admnPos>SuperUsers.size()) {
								System.out.println("Incorrect Account Number");
								break;
							}
							System.out.println("Enter your Password (8<password<20): ");
							Password= in.nextLine();
							if(!Password.equals(SuperUsers.get(admnPos).getPassword())) {
								System.out.println("Incorrect Password");
								break;
							}
							new Admin().start(admnPos,SuperUsers,Accounts);
						}catch(NumberFormatException e){
							System.out.println("Data Incorrect " +e);
						}	
						break;
					
					case "99" :
				    	System.out.println("\tThank You. Have A Nice Day :)");
				    	System.exit(0);
					default :
				    	System.out.println("Wrong Choice.");
					
			}	
		
		
	}
  }
}
