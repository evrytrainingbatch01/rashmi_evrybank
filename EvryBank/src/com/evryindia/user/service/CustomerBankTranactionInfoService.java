package com.evryindia.user.service;

import com.evryindia.foundation.domain.Customer;

public interface CustomerBankTranactionInfoService {
	
	public int ebAddMoneyToOwnAccount(int accountId);
	public Customer ebViewCustomerDetails(int accountId);
	public int ebLoanRequestToBank(int accountId);
	public int ebWithdrawMoney(int accountId);
	public int ebMoneyTransferToAnyAccount(int ownAccountId, int beneficiaryAccountId);
} 
 