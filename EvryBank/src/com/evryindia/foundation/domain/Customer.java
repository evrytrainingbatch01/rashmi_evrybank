package com.evryindia.foundation.domain;

import com.evryindia.foundation.domain.UserType;

public class Customer {
	private int id;
	private String firstName;
	private String lastName;
	private String city;
	private Country country;
	private String mobileNumber;
	private String emailId;
	private UserType userType;
	private String password;
	private AccountDetails accountDetails;
	
	
	public Customer(int accountId) {
		this.setId(accountId); 
	}
	public Customer() {
	}
	public AccountDetails getAccountDetails() {
		return accountDetails;
	}
	public void setAccountDetails(AccountDetails accountDetails) {
		this.accountDetails = accountDetails;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public Country getCountry() {
		return country;
	}
	public void setCountry(Country country) {
		this.country = country;
	}
	public String getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public UserType getUserType() {
		return userType;
	}
	public void setUserType(UserType userType) {
		this.userType = userType;
	}
	@Override
	public String toString()
	{
		StringBuilder sb  = new StringBuilder();
		sb.append("\n Customer ID : ");
		sb.append(this.getId());
		
		sb.append(" \n First Name : ");
		sb.append(this.getFirstName());
		
		sb.append("\n Last Name : ");
		sb.append(this.getLastName());
		
		sb.append( "\n city : " );
		sb.append( this.city );
		
		sb.append( "\n country : " );
		sb.append( this.country == null ? null : this.country.getId()  );
		
		sb.append( "\n mobileNumber : " );
		sb.append( this.mobileNumber );
		
		sb.append( "\n emailId : " );
		sb.append( this.emailId );
		
		sb.append( "\n userType : ");
		sb.append( this.userType );
		
		sb.append( "\n accountDetails : ");
		sb.append( this.accountDetails );
		return sb.toString();
	}
}