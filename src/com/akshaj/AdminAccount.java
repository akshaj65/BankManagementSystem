package com.akshaj;

import java.io.Serializable;
import java.util.ArrayList;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class AdminAccount implements Serializable{


	private static final long serialVersionUID = 1L;
	private static int NoOfAcc=0;
    private static int Acc_Num=Main.SU_ACC_NUMBR*10;
	private int Number;
	private String Name, Password;
	private String PhoneNumber;
	private String Email;
	public AdminAccount() {

	}

	public AdminAccount( String Name, String Password) {
		this.Number=Acc_Num+NoOfAcc;
		NoOfAcc++;
		this.Name = Name;
		this.Password = Password;
		this.PhoneNumber="null";
		this.Email="null";
	}
	public AdminAccount(String Name,String Email,String PhoneNumber, String Password) {
		this.Number=Acc_Num+NoOfAcc;
		NoOfAcc++;
		this.Name = Name;
		this.Password = Password;
		this.PhoneNumber=PhoneNumber;
		this.Email=Email;
	}
	public int getNoOfAccounts() {
		return NoOfAcc;
	}
	public void setNoOfAccounts(int noOfAcc) {
		NoOfAcc=noOfAcc;
	}
	public String toString() {
		return "Account Number: "+getNumber()+"\nName: "+getName()+"\nEmail: "+getEmail()+"\nMobile Number: "+getPhoneNumber();
	}
	public int getNumber() {
		return Number;
	}

	public void setNumber(int number) {
		Number = number;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getPassword() {
		return Password;
	}

	public void setPassword(String password) {
		Password = password;
	}
	public String getPhoneNumber() {
		return PhoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		PhoneNumber = phoneNumber;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}


	String[] getBankInfo(Bank bank,Branch BankBranch ) {
		return new String[] { bank.getName(), bank.getCode(), BankBranch.getIFSC_Code(), BankBranch.getName(),
				BankBranch.getAddress() };
	}
	public ArrayList<AdminAccount> convertToObject(String str) {
		Gson gson =new Gson();
		return gson.fromJson(str,new TypeToken<ArrayList<AdminAccount>>() {}.getType());
	}

}
