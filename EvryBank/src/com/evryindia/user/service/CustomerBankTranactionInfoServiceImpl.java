package com.evryindia.user.service;

import com.evryindia.foundation.domain.Customer;
import com.evryindia.user.service.CustomerBankTranactionInfoService;

public class CustomerBankTranactionInfoServiceImpl implements CustomerBankTranactionInfoService{

	public int ebAddMoneyToOwnAccount(int accountId) {
		return 0;
	}
	public Customer ebViewCustomerDetails(int accountId) {
		Customer customer = null;
		return customer;
	}
	public int ebLoanRequestToBank(int accountId) {
		return 0;
	}
	public int ebWithdrawMoney(int accountId) {
		return 0;
	}
	public int ebMoneyTransferToAnyAccount(int ownAccountId, int beneficiaryAccountId) {
		return 0;
	}
	
}
