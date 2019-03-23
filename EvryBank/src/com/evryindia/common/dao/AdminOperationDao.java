/**
 * 
 */
package com.evryindia.common.dao;

import java.sql.SQLException;
import java.util.ArrayList;

import com.evryindia.foundation.domain.Customer;
import com.evryindia.foundation.domain.Transaction;

/**
 * @author rashmi.kiran
 *
 */
public interface AdminOperationDao {

	void addCustomer(Customer customerId) throws SQLException;
	void deleteCustomer (Customer customerId) throws SQLException;
	void addMoney(Transaction t);
	void approveTransaction(Transaction t);
	void provideLoan(Customer customerId,Transaction t);
	ArrayList<Customer> viewCustomersDetails(ArrayList<Customer> customerList) throws SQLException;
	ArrayList<Customer> listAllCustomers() throws SQLException;

	
	
}
