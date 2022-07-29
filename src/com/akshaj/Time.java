package com.akshaj;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Time {
	
	public String now() {
//		SimpleDateFormat formatter =  new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
		SimpleDateFormat formatter =  new SimpleDateFormat("dd-MM-yyyy");
		Date date= new Date();
		return formatter.format(date);
	}

}
