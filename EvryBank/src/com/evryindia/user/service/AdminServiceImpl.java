package com.evryindia.user.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.evryindia.common.dao.AdminOperationDao;
import com.evryindia.common.dao.impl.AdminOperationDaoImpl;
import com.evryindia.db.DbDao;
import com.evryindia.foundation.domain.Country;
import com.evryindia.foundation.domain.Customer;
import com.evryindia.foundation.domain.UserType;
import com.evryindia.user.dao.AdminDao;
import com.evryindia.util.CryptographyUtil;
import com.evryindia.util.DbUtil;
import com.evryindia.util.KeyGenerator;
import com.mysql.cj.xdevapi.Statement;

public class AdminServiceImpl implements AdminService {
	String CLASS_NAME = this.getClass().getName();

	Country country;

	@Override
	public int ebAddCustomer(Customer customer) throws SQLException {
		String METHOD_NAME = CLASS_NAME + ".ebAddCustomer():";
		System.out.println(METHOD_NAME+"Starting >>>>>>>>");
		if (customer != null) {
			AdminOperationDao adminDao = new AdminOperationDaoImpl();
				Scanner sc = new Scanner(System.in);
//					UserType userType = null;
//					Country country = null;

				// to do account id generation, auto-generation

				System.out.println("Enter customer fname");
				customer.setId(15);//TODO need to generate id
				customer.setFirstName(sc.next());
				System.out.println("Entr Last name");
				customer.setLastName(sc.next());
				System.out.println("Entr city");
				customer.setCity(sc.next());
				// System.out.println("ent country");
//					customer.setCountry(country);
				System.out.println("Entr email");
				customer.setEmailId(sc.next());
				// System.out.println("ntr usertype: ADMIN/CUSTOMER");
//					customer.setUserType(userType);	
				System.out.println("Entr mob. no.");
				customer.setMobileNumber(sc.next());
				System.out.println("Entr password");

				String encryptpass = CryptographyUtil.generateDigest(sc.next());
				customer.setPassword(encryptpass);
				customer.setCountry(new Country(1,"India"));

				adminDao.addCustomer(customer);

			/*
			 * if (customer.getId() <= 0) { adminDao.addCustomer(customer); } else {
			 * //adminDao.ebUpdateCustomer(customer); }
			 */
				sc.close();
				System.out.println("New Customer Created");
				System.out.println(METHOD_NAME+"Completed <<<<<<<<");
				


			}

		return 0;
	}

	public int ebDeleteCustomer(int customerId) throws SQLException {
		String METHOD_NAME = CLASS_NAME + ".ebDeleteCustomer():";
		System.out.println(METHOD_NAME+"Starting >>>>>>>>");
		
		Customer customer = new Customer();
		AdminOperationDao adminDao = new AdminOperationDaoImpl();
		Scanner sc = new Scanner(System.in);
		
		System.out.println("\n Enter customer ID : ");
		customer.setId(Integer.valueOf(sc.next()));
		adminDao.deleteCustomer(customer);
		System.out.println(METHOD_NAME+"Completed <<<<<<<<");

		return 0;
	}

	public List<Customer> ebViewCustomerList() throws SQLException {
		String METHOD_NAME = CLASS_NAME + ".ebViewCustomerList():";
		System.out.println(METHOD_NAME+"Starting >>>>>>>>");
		
		AdminOperationDao adminDao = new AdminOperationDaoImpl();
		
		List<Customer> customerList = adminDao.listAllCustomers();
		if(customerList != null )
		{
			for(int i=0; i< customerList.size();i++)
			{
				Customer c = customerList.get(i);
				System.out.println("\n"+c);
			}
		}
		
		System.out.println(METHOD_NAME+"Completed <<<<<<<<");

		return customerList;
	}

	public Customer ebViewCustomerDetails(int accountId) throws SQLException {
		
		String METHOD_NAME = CLASS_NAME + ".ebViewCustomerList():";
		System.out.println(METHOD_NAME+"Starting >>>>>>>>");
		
		
		AdminOperationDao adminDao = new AdminOperationDaoImpl();
		Customer c = new Customer( accountId );
				
		Scanner sc = new Scanner(System.in);
		
		System.out.println("\n Enter customer ID : ");
		c.setId(Integer.valueOf(sc.next()));
		
		ArrayList<Customer> customerList= new ArrayList<Customer>();
		customerList.add(c);
		
		ArrayList<Customer> returnedCustomerList = adminDao.viewCustomersDetails(customerList);
		
		if(returnedCustomerList != null && !returnedCustomerList.isEmpty() )
		{
			/*
			 * for(int i=0; i< customerList.size();i++) {
			 */
				c = returnedCustomerList.get(0);
				System.out.println("\n"+c);
			//}
		}
		else
			return null;
		
		System.out.println(METHOD_NAME+"Completed <<<<<<<<");

		return c;
	}

	public int ebAddMoneyToAnyAccount(int accountId) {
		return 0;
	}

	public boolean ebApproveTranction(int customerId) {
		return true;
	}

	public boolean ebApprovideLoan(int customerId) {
		return true;
	}


}