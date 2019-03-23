package com.evryindia.db;

import java.sql.SQLException;
import java.util.Scanner;

import com.evryindia.foundation.domain.Customer;
import com.evryindia.foundation.domain.UserType;
import com.evryindia.user.service.AdminServiceImpl;
import com.evryindia.user.service.CustomerBankTranactionInfoServiceImpl;

public class Manager
{
	public static void main(String[] args) throws SQLException {	
		CustomerBankTranactionInfoServiceImpl customerService =new CustomerBankTranactionInfoServiceImpl();
		AdminServiceImpl adminSrvice =new AdminServiceImpl();
		Customer customer = new Customer();
		UserType userType = new UserType();
		userType.setId(2);//TODO need to get it from data base based on user
		
		int accountId = 0;
		int toAccountId = 0;
		int fromAccountId = 0;

		Scanner sc = new Scanner(System.in);
		System.out.println("Enter email: ");
		String email = sc.next();

		System.out.println("Enter password: ");
		String password = sc.next();

		//TODO user id and password validation is not used

		
		customer.setEmailId(email);
		customer.setUserType(userType);
		//System.out.println(customer.getUserType().getId());
		if(customer.getUserType().getId() == 1) { 
			System.out.println("1. Add Customer");
			System.out.println("2. Delete a Customer");
			System.out.println("3. Customers list");
			System.out.println("4. Customer details");
			System.out.println("5. Add money to any account");
			System.out.println("6. Provide Loan");
			System.out.println("7. Approve tranaction");
			
		}
		else if (customer.getUserType().getId()==2){ 
			System.out.println("8. Add money to own account");
			System.out.println("9. Customer account details");
			System.out.println("10. Send money to another account");
			System.out.println("11. Withdrawal money");
			System.out.println("12. Ask for loan");
		}
		else
		{
			System.out.println("invalid input: Non bank customer not allowed, Must have an account");
		}
		
		Integer choice = sc.nextInt();
		
		switch (choice) {
		case 1:
			adminSrvice.ebAddCustomer(customer);
			break;
		case 2:
			adminSrvice.ebDeleteCustomer(accountId);
			break;
		case 3:
			adminSrvice.ebViewCustomerList();
			break;
		case 4:
			adminSrvice.ebViewCustomerDetails(accountId);
			break;
		case 5:
			adminSrvice.ebAddMoneyToAnyAccount(accountId);
			break;
		case 6:
			adminSrvice.ebApproveTranction(accountId);
			break;
		case 7:
			adminSrvice.ebApprovideLoan(accountId);
			break;
		case 8:     
			customerService.ebAddMoneyToOwnAccount(accountId);
			break;
		case 9:
			customerService.ebViewCustomerDetails(accountId);
			break;
		case 10:
			customerService.ebLoanRequestToBank(accountId);
			break;
		case 11:
			customerService.ebWithdrawMoney(accountId);	     
			break;
		case 12:
			customerService.ebMoneyTransferToAnyAccount(toAccountId, fromAccountId);
			break;
		default: 
			break; 
		}
		
//		int action;
//		if(sc.nextInt() == 1)
//		{
//			adminOperations(sc);
//		}
//		else if(sc.nextInt() == 2)
//		{
//			customerOperation(sc);
//		}
//		else
//		{
//			System.out.println("input is not proper ");
//			System.out.println("input 1 for admin and 2 for customer ");
//		}
	}
}
