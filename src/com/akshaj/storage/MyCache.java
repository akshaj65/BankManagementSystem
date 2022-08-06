package com.akshaj.storage;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import com.akshaj.Account;
import com.akshaj.AdminAccount;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.reflect.TypeToken;
import java.io.ObjectInputStream;
import java.io.FileInputStream;

public class MyCache {
	private String Path;
	private String Fname;
	
	
	public MyCache(String path, String fname) {
		super();
		Path = path;
		Fname = fname;
		run(Fname) ;
	}


	private void run(String fname) {
		boolean result=false;
		try {
			if(!result) {
				File file = new File(fname);
				result= file.createNewFile();
			}
			
		}catch(IOException e) {
			e.printStackTrace();
		}
		
	}

    public String[] convertToJson(ArrayList<?> accounts,int num) { //question mark refers to wildcard in generic programming
    	ArrayList<String> arr = new ArrayList<>();
    	arr.add(Integer.toString(num));
    	Gson gson = new GsonBuilder().create();
    	String json=gson.toJson(accounts, new TypeToken<ArrayList<?>>() {}.getType());
    	arr.add(json);
    	return arr.toArray(new String[arr.size()]);
    }
    
    public JsonArray convertObjToJson(ArrayList<?> accounts) {
    	JsonArray arr= new JsonArray();
    	for(Object object: accounts) {
    		arr.add(new Gson().toJson(object));
    		System.out.println(new Gson().toJson(object));
    		
    	}
		return arr;
    	
    }
    public void storeStringToFile(String str) {
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter(this.Fname,false));
			
				writer.write(str.toString());
				writer.newLine();
			
			writer.close();
			System.out.println("File saved");
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	public void storeArrToFile(String[] arr) {
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter(this.Fname,false));
			for(int i=0;i<arr.length;i++) {
				writer.write(arr[i].toString());
				writer.newLine();
			}
			writer.close();
			System.out.println("File saved");
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	public String[] getArrFromFile() {
		ArrayList<String> lines = new ArrayList<>();
		try {
			BufferedReader reader = new BufferedReader(new FileReader(this.Fname));
			String line=null;
			while((line=reader.readLine()) !=null) {
				lines.add(line);
			}
			reader.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return lines.toArray(new String[lines.size()]);
		
	}
	public void storeObjToFile(Object obj) {
		try {
			FileOutputStream fout = new FileOutputStream(this.Fname);
			ObjectOutputStream objOut= new ObjectOutputStream(fout);
			objOut.writeObject(obj);
			objOut.close();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	public void storeObjArrToFile(Object[] obj) {
		try {
			FileOutputStream fout = new FileOutputStream(this.Fname);
			ObjectOutputStream objOut= new ObjectOutputStream(fout);
			objOut.writeObject(obj);
			objOut.close();
//			System.out.println("Object saved to file ");
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	public Object getObjFromFile() {
		Object obj=null;
		try {
			ObjectInputStream objIn= new ObjectInputStream(new FileInputStream(this.Fname));
			 obj=(Object)objIn.readObject();
			 objIn.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return obj;
	}
	public Object[] getObjArrFromFile() {
		Object[] obj=null;
		try {
			ObjectInputStream objIn= new ObjectInputStream(new FileInputStream(this.Fname));
			 obj=(Object[])objIn.readObject();
			objIn.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return obj;
	}
	public void remove() {
		new AdminAccount().setNoOfAccounts(0);
		new Account().setNoOfAccounts(0);
		if(new File(this.Fname).delete()) {
			System.out.println(this.Fname+" file deleted.");
		}else {
			System.out.println("Failed to delete "+ this.Fname);
		}
	}
}