package com.akshaj;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Scanner;
import com.akshaj.storage.MyCache;
import com.google.gson.Gson;

public class Admin {


	private final String SU_ACC_NUMBR = Main.SU_ACC_NUMBR;
//	public Account CustAccounts[] = new Main().getAccounts();
//	public AdminAccount SUAccounts[] =new Main().getSUAccounts();
	MyCache bnk=new MyCache("","bankDetails.txt");
	public String[] BANK_DETAILS=bnk.getArrFromFile();
	
	
	void start(int custAccNum,int admAccNum,ArrayList<AdminAccount> SUAccounts,ArrayList<Account> CustAccounts) {
		Scanner in = new Scanner(System.in);
		int accountNum=1;
		System.out.println("\nHi " + SUAccounts.get(admAccNum).getName());
//		MyCache custCache = new MyCache("", "customers.txt");
//		MyCache admnCache= new MyCache("","adminUsers.txt");
		boolean exit=false;
		while (!exit) {
			System.out.println(
					"\nChoose the below services:-\n\n1.Enter Bank details: .\n2.Add new admin account.\n3.Print accounts opened in our bank.\n4.Print admin accounts.\n99.Back");
			int choice = in.nextInt();
			String AccountNumber="";
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
				
//				System.out.println(bnk.convertObjToJson(CustAccounts));
//				System.out.println(Arrays.toString(bnk.getArrFromFile()));
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
				AccountNumber=SU_ACC_NUMBR+String.valueOf(accountNum);
				SUAccounts.add(new AdminAccount(AccountNumber, Name, Email, PhoneNumber, Password));
				accountNum++;
//				superUsers[accountNum++] =new AdminAccount(AccountNumber, Name, Email, PhoneNumber, Password); //calling same class from same file
//				admnCache.storeObjArrToFile(SUAccounts);
				System.out.println(
						"\nAccount has been created.\nYour Account number is " + SUAccounts.get(accountNum-1).getNumber());
				continue;
			case 3:
				System.out.println("\n            Accounts opened in our bank\n");
				if(custAccNum==0) System.out.println("Not yet opened");
				Iterator<Account>  custIttr= CustAccounts.iterator();
				while(custIttr.hasNext()) {
					System.out.println(custIttr.next().toString() + "\n"); // toString method is created in accounts
																			// class
				}
				break;
			case 4:
				System.out.println("\n           Admin Accounts\n");
//				for (int i = 0; i < accountNum; i++) {
//					System.out.println(superUsers[i].toString() + "\n"); // toString method is created in accounts
//																			// class
//				}
				Iterator<AdminAccount>  suIttr= SUAccounts.iterator();
				while(suIttr.hasNext()) {
					System.out.println(suIttr.next().toString() + "\n"); // toString method is created in accounts
																			// class
				}
				break;
			case 5:
				System.out.println("\nTake Backup\n");
				/*under construction*/
				System.out.println("\nBackup Complete\n");
				break;
			case 6:
				System.out.println("\n Restore Backup\n");
				/*under construction*/
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
