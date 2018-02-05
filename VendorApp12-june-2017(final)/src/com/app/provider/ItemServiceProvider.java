package com.app.provider;

import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.app.model.Customer;
import com.app.service.ICustomerService;

@Component
@Path("/item")
public class ItemServiceProvider {
	@Autowired
	private ICustomerService custService;
	
	@POST
	@Path("/saveItem")
	public String saveItem(
	 @HeaderParam("userName")String un,		
	 @HeaderParam("password")String pwd,		
	 @HeaderParam("token")String token,
	 String itemJson){
		
		/**1.basic input validations*/
		if(un == null || "".equals(un.trim()))
			 return "User name Can not be empty/null";
		if(pwd == null || "".equals(pwd.trim()))
			return "Password can not be null or empty";
		if(token == null || "".equals(token.trim()))
			return "Token can not be null or empty";
		if(itemJson == null || "".equals(itemJson.trim()))
			return "Item(JSON) can not be null or empty";
		
		/**2. user name(Customer exist) check*/
		Customer cust=custService.getCustomerByEmail(un);
		if(cust==null)
			return "Invalid Customer(Customer not exist)";
		/**
		 * 3. Request pwd,token matching with DB pwd,token
		 * 4. Customer type should be Seller
		 */
		
		
		
		return "valid inputs";
	}
	
	
	
}
