/**
 * 
 */
package com.evryindia.common.dao;

import com.evryindia.foundation.domain.Customer;
import com.evryindia.foundation.domain.Transaction;

/**
 * @author rashmi.kiran
 *
 */
public interface CustomerOperationDao {

	void AddMoney(Transaction t);
	Customer viewCustomersDetails(Customer listCust);
	void withdrawMoney(Transaction t);
	void askForLoan(Customer c, Transaction t);

}
