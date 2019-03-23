package com.evryindia.user.service;

import java.sql.SQLException;
import java.util.List;

import com.evryindia.foundation.domain.Customer;

public interface AdminService {
	public int ebAddCustomer(Customer customer) throws SQLException;
	public int ebDeleteCustomer(int customerId) throws SQLException;
	public List<Customer> ebViewCustomerList() throws SQLException;
	public Customer ebViewCustomerDetails(int  accountId) throws SQLException;
	
	public int ebAddMoneyToAnyAccount(int accountId);
	public boolean ebApproveTranction(int customerId);
	public boolean ebApprovideLoan(int customerId);

}