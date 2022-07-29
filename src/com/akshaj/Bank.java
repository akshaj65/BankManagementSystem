package com.akshaj;

class Bank {
	private String Name;
	private String Code;
	
	public Bank(String name, String code) {
		this.Name = name;
		this.Code = code;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getCode() {
		return Code;
	}

	public void setCode(String code) {
		Code = code;
	}

}
