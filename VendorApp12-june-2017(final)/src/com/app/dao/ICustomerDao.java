package com.app.dao;

import com.app.model.Customer;

public interface ICustomerDao {

	public int saveCustomer(Customer cust);
	public Customer getCustomerByEmail(String custEmail);
	
	
	
}
