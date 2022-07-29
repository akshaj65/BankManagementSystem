package com.akshaj;

import java.io.Serializable;

public class AdminAccount implements Serializable{


	private static final long serialVersionUID = 1L;
	private String Number, Name, Password;
	private String PhoneNumber;
	private String Email;
//	Bank bank;
//	Branch BankBranch;
	
	public AdminAccount() {

	}

	public AdminAccount(String Number, String Name, String Password) {
		this.Name = Name;
		this.Password = Password;
		this.Number = Number;
	}
	public AdminAccount(String Number, String Name,String Email,String PhoneNumber, String Password) {
		this.Name = Name;
		this.Password = Password;
		this.Number = Number;
		this.PhoneNumber=PhoneNumber;
		this.Email=Email;
	}

	public String toString() {
		return "Account Number: "+getNumber()+"\nName: "+getName()+"\nEmail: "+getEmail()+"\nMobile Number: "+getPhoneNumber();
	}
	public String getNumber() {
		return Number;
	}

	public void setNumber(String number) {
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


}
