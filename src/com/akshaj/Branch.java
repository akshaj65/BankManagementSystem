package com.akshaj;

public class Branch {
	private String IFSC_Code;  //ifsc is 11 digit alpha numeric ist 4 identify bank,fifth is kept 0and last six digit represet bank branch
	private String Name;
	private String Address;
//	private String Branch_id; this could be derived from ifsc code

	
	public Branch(String IFSC_Code, String name, String address) {
		this.IFSC_Code = IFSC_Code;
		this.Name = name;
		this.Address = address;
	}
	
	public String getIFSC_Code() {
		return IFSC_Code;
	}
	public void setIFSC_Code(String IFSC_Code) {
		this.IFSC_Code = IFSC_Code;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getAddress() {
		return Address;
	}
	public void setAddress(String address) {
		Address = address;
	}
	
	
}
