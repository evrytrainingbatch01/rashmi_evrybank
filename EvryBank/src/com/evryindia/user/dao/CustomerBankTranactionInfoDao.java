package com.evryindia.user.dao;

import com.evryindia.foundation.domain.Customer;

public interface CustomerBankTranactionInfoDao {
	public int ebAddMoneyToOwnAccount(int accountId);
	public Customer ebViewCustomerDetails(int accountId);
	public int ebLoanRequestToBank(int accountId);
	public int ebWithdrawMoney(int accountId);
	public int ebMoneyTransferToAnyAccount(int ownAccountId, int beneficiaryAccountId);

}
//ownAccountId = from account, beneficiaryAccountId = to account

