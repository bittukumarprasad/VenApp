package com.nt.domain;

public class PhoneNumbers {
	//==========peoperty==============//
	private long phone;
	private String numbertype;
	private String provider;
	
	
	//============Getter & Setter=============//
	public long getPhone() {
		return phone;
	}
	public void setPhone(long phone) {
		this.phone = phone;
	}
	public String getNumbertype() {
		return numbertype;
	}
	public void setNumbertype(String numbertype) {
		this.numbertype = numbertype;
	}
	public String getProvider() {
		return provider;
	}
	public void setProvider(String provider) {
		this.provider = provider;
	}
	

	//==========toString()===============//

	@Override
	public String toString() {
		return "PhoneNumbers [phone=" + phone + ", numbertype=" + numbertype + ", provider=" + provider + "]";
	}
	
	
	

	
	
	
	
	

}
