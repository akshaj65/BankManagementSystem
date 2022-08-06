package com.akshaj;

import java.io.Serializable;
import java.util.ArrayList;

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
	public void depositMoney(double DepositedMoney) {
		this.Balance+=DepositedMoney;
		System.out.println("Deposit is Successful, New Balance is "+this.Balance);
	}
	public void withdrawMoney(double WithdrawalMoney) {
		if(this.Balance-WithdrawalMoney<0) {
			System.out.println("Withdraw Unsuccessful only "+this.Balance+" is left");
		}else {
			this.Balance-=WithdrawalMoney;
			System.out.println("Withdraw Successful, Current Balance is "+ this.Balance);
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
