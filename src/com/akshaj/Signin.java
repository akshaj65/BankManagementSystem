package com.akshaj;

import java.util.Scanner;

public class Signin {
	String Password = "", cnfPassword = "";
	Scanner in =new Scanner(System.in);
	
	String[] start() {
		System.out.println("Enter your Name: ");
		String Name = in.nextLine();
		System.out.println("Enter your email: ");
		String Email = in.nextLine();
		System.out.println("Enter your mobile number: ");
		String PhoneNumber = in.nextLine();
		boolean isVerified = false;
		for (int i = 0; i < 2; i++) {
			System.out.println("Enter your Password (8<password<20): ");
			Password = in.nextLine();
			System.out.println("Confirm your password: ");
			cnfPassword = in.nextLine();
			if (Password.length() <= 8 || Password.length() >= 20) {
				System.out.println("Password should be greater than 8 and less than 20\n");
			} else if (Password.equals(cnfPassword)) {
				isVerified = true;
				break;
			} else {
				System.out.println("Passwords do not match .\n");
			}
		}
		if (!isVerified) {
			System.out.println("You've reached maximum attempts. Please try again.\n");
			return null;
		}
		return new String[] {Name,Email,PhoneNumber,Password};
		
	}
}
