package com.akshaj;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.InputMismatchException;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

//alt +shift+ s for automatically creating getters and setters
//sysout then ctrl+ space
public class Account implements Serializable{

	private static final long serialVersionUID = 1L;
	private static int NoOfAcc=0;
    private static int Acc_Num=Main.ACC_NUMBR*10;
	private  int Number;
	private double Balance;
	private String Name;
	private String Email;
	private String PhoneNumber;
	private String Password;
	private String[] BankDetails=new Admin().BANK_DETAILS;
	
	public Account() {
		
	}
	public Account(double Balance, String Name, String Email,String PhoneNumber,String Password,String[] BankDetails) {
		this.Number=Acc_Num+NoOfAcc;
		NoOfAcc++;
		this.Balance=Balance;
		this.Name=Name;
		this.Email=Email;
		this.PhoneNumber=PhoneNumber;
		this.Password=Password;
		this.BankDetails=BankDetails;
	}
	
	public int getNoOfAccounts() {
		return NoOfAcc;
	}
	public void setNoOfAccounts(int noOfAcc) {
		NoOfAcc=noOfAcc;
	}
	public void depositMoney(String DepMoney) {
		try {
			double DepositedMoney=Double.parseDouble(DepMoney);
			this.Balance+=DepositedMoney;
			System.out.println("Deposited  Successfuly, New Balance is "+this.Balance);
		}catch(NumberFormatException eh) {
			System.out.println("Failed to Deposit, Amount Incorrect {NumberFormatException}");
		}
	}
	public void withdrawMoney(String amnt) {
		try {
			double amount=Double.parseDouble(amnt);
			if(this.Balance-amount<0) {
				System.out.println("Withdrawal Unsuccessful only "+this.Balance+" is left");
			}else {
				this.Balance-=amount;
				System.out.println("Withdrawal Successful, Current Balance is "+ this.Balance);
			}
		}catch(NumberFormatException eh) {
			System.out.println("Failed to Withdraw, Amount Incorrect {NumberFormatException}");
		}
	}

	public String toString() {
		return "Account Number: "+getNumber()+"\nName: "+getName()+"\nBalance: "+getBalance()+"\nEmail: "+getEmail()+"\nMobile Number: "+getPhoneNumber()+"\nBank Details: "+getBankDetails();
	}
	public String getBankDetails() {
		int n=this.BankDetails.length;
		String temp=BankDetails[0]+"\n",space="               ";
		for(int var=1;var<n-1;var++) {
			temp+=space+BankDetails[var]+"\n";
		}
		return temp+space+BankDetails[n-1];	
		
	}
	public int getNumber() {
		return Number;
	}
	public void setNumber(int number) {
		Number = number;
	}
	public double getBalance() {
		return Balance;
	}
	public void setBalance(double balance) {
		Balance = balance;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		this.Email = email;
	}
	public String getPhoneNumber() {
		return PhoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		PhoneNumber = phoneNumber;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}
	
	public ArrayList<Account> convertToObject(String str) {
		Gson gson =new Gson();
		return gson.fromJson(str,new TypeToken<ArrayList<Account>>() {}.getType());
	}
}
