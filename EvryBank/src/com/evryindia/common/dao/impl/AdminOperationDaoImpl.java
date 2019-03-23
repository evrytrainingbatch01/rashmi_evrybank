/**
 * 
 */
package com.evryindia.common.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.evryindia.common.dao.AdminOperationDao;
import com.evryindia.foundation.domain.Country;
import com.evryindia.foundation.domain.Customer;
import com.evryindia.foundation.domain.Transaction;
import com.evryindia.util.DbUtil;
import com.mysql.cj.protocol.Resultset;
import com.mysql.cj.util.StringUtils;

/**
 * @author rashmi.kiran
 *
 */
public class AdminOperationDaoImpl implements AdminOperationDao {
	String CLASS_NAME =  this.getClass().getName();

	/* (non-Javadoc)
	 * @see com.evryindia.common.dao.AdminOperationDao#addCustomer(com.evryindia.foundation.domain.Customer)
	 */
	@Override
	public void addCustomer(Customer c) throws SQLException {
			String METHOD_NAME = CLASS_NAME+".addCustomer():";
			System.out.println(METHOD_NAME + "*******Starting ****");
			System.out.println(METHOD_NAME + "input : " + c);
			
			Connection conn = null;
			PreparedStatement statement = null;
			
			try {

				conn = DbUtil.getConnection();

				String sql = "INSERT INTO customer (id,firstName, lastName, city,  mobileNumber,emailId,password, countryId)"
						+ " VALUES (?, ?, ?, ?,?, ?, ?, ?)";

				statement =  conn.prepareStatement(sql);
				
				statement.setInt(1, c.getId());
				statement.setString(2, c.getFirstName());
				statement.setString(3, c.getLastName());
				statement.setString(4, c.getCity());
				statement.setString(5, c.getMobileNumber());
				statement.setString(6, c.getEmailId());
				statement.setString(7, c.getPassword());
				statement.setInt(8, c.getCountry().getId());
				
				int rowsInserted = statement.executeUpdate();
				if (rowsInserted > 0) {
					System.out.println("A new user was inserted successfully!");
				}

			} catch (SQLException ex) {
				ex.printStackTrace();
				throw ex;
			}

			finally{
				DbUtil.closeAll(null, statement, conn);
			}
			

			
			System.out.println(METHOD_NAME + "*******Completed ****");

	}

	/* (non-Javadoc)
	 * @see com.evryindia.common.dao.AdminOperationDao#deleteCustomer(com.evryindia.foundation.domain.Customer)
	 */
	@Override
	public void deleteCustomer(Customer c) throws SQLException {
		String METHOD_NAME = CLASS_NAME+".addCustomer():";
		System.out.println(METHOD_NAME + "*******Starting ****");
		System.out.println(METHOD_NAME + "input : " + c);
		
		Connection conn = null;
		PreparedStatement statement = null;
		
		try {
			conn = DbUtil.getConnection();

			//String sql = "SELECT ID,FIRSTNAME,LASTNAME,CITY,COUNTRYID,(SELECT NAME FROM COUNTRY WHERE ID = COUNTRYID) COUNTRYNAME,MOBILENUMBER,EMAILID FROM CUSTOMER WHERE ID = ?" ;
			String sql = "DELETE FROM CUSTOMER WHERE ID = ?";
			statement =  conn.prepareStatement(sql);
			statement.setInt(1, c.getId());

			int rowsDeleted = statement.executeUpdate();
			if (rowsDeleted > 0) {
				System.out.println("A new user was deleted successfully!");
			}
		}catch (SQLException ex) {
			ex.printStackTrace();
			throw ex;
		}

		finally{
			DbUtil.closeAll(null, statement, conn);
		}
	}

	/* (non-Javadoc)
	 * @see com.evryindia.common.dao.AdminOperationDao#addMoney(com.evryindia.foundation.domain.Transaction)
	 */
	@Override
	public void addMoney(Transaction t) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see com.evryindia.common.dao.AdminOperationDao#approveTransaction(com.evryindia.foundation.domain.Transaction)
	 */
	@Override
	public void approveTransaction(Transaction t) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see com.evryindia.common.dao.AdminOperationDao#provideLoan(com.evryindia.foundation.domain.Customer, com.evryindia.foundation.domain.Transaction)
	 */
	@Override
	public void provideLoan(Customer c, Transaction t) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see com.evryindia.common.dao.AdminOperationDao#viewCustomersDetails(java.util.ArrayList)
	 */
	@Override
	public ArrayList<Customer> viewCustomersDetails(ArrayList<Customer> listCust) throws SQLException {

		String METHOD_NAME = CLASS_NAME+".viewCustomersDetails():";
		System.out.println(METHOD_NAME + "*******Starting ****");
		System.out.println(METHOD_NAME + "input : " + listCust);
		if(listCust.size() < 1)
		{
			System.out.println(METHOD_NAME + "No customer id provided" + listCust);

			return null;
		}
		Customer c = null;
		ArrayList<Customer> cList = null; 
		Connection conn = null;
		PreparedStatement statement = null;
		
		try {
			conn = DbUtil.getConnection();

			String sql = "SELECT ID,FIRSTNAME,LASTNAME,CITY,COUNTRYID,(SELECT NAME FROM COUNTRY WHERE ID = COUNTRYID) COUNTRYNAME,MOBILENUMBER,EMAILID FROM CUSTOMER WHERE ID = ?" ;
			statement =  conn.prepareStatement(sql);
			statement.setInt(1, listCust.get(0).getId());

			listCust.clear();
			ResultSet rs = statement.executeQuery();
				while (rs.next()){
					c = new Customer();
					cList = new ArrayList<Customer>(); 

					int ID= rs.getInt("ID");
					String FIRSTNAME= rs.getString("FIRSTNAME");
					String LASTNAME= rs.getString("LASTNAME");
					String CITY= rs.getString("CITY");
					int COUNTRYID= rs.getInt("COUNTRYID");
					String COUNTRYNAME= rs.getString("COUNTRYNAME");
					String MOBILENUMBER= rs.getString("MOBILENUMBER");
					String EMAILID= rs.getString("EMAILID");
					
					c.setId(ID);
					c.setFirstName(FIRSTNAME);
					c.setLastName(LASTNAME);
					c.setCity(CITY);
					Country co = new Country(COUNTRYID,COUNTRYNAME);
					c.setCountry(co);
					c.setMobileNumber(MOBILENUMBER);
					c.setEmailId(EMAILID);
					cList.add(c);

				}
		}catch (SQLException ex) {
			ex.printStackTrace();
			throw ex;
		}

		finally{
			DbUtil.closeAll(null, statement, conn);
		}
	
		return cList;
	}

	/* (non-Javadoc)
	 * @see com.evryindia.common.dao.AdminOperationDao#listAllCustomers()
	 */
	@Override
	public ArrayList<Customer> listAllCustomers() throws SQLException {

		String METHOD_NAME = CLASS_NAME+".listAllCustomers():";
		System.out.println(METHOD_NAME + "*******Starting ****");

		Customer c = null;
		ArrayList<Customer> cList = new ArrayList<Customer>(); ; 
		Connection conn = null;
		PreparedStatement statement = null;
		
		try {
			conn = DbUtil.getConnection();

			String sql = "SELECT ID,FIRSTNAME,LASTNAME,CITY,COUNTRYID,(SELECT NAME FROM COUNTRY WHERE ID = COUNTRYID) COUNTRYNAME,MOBILENUMBER,EMAILID FROM CUSTOMER" ;
			statement =  conn.prepareStatement(sql);

			ResultSet rs = statement.executeQuery();
			while (rs.next()){
				System.out.println("rs" + rs);

				c = new Customer(); 

				int ID= rs.getInt("ID");
				String FIRSTNAME= rs.getString("FIRSTNAME");
				String LASTNAME= rs.getString("LASTNAME");
				String CITY= rs.getString("CITY");
				int COUNTRYID= rs.getInt("COUNTRYID");
				String COUNTRYNAME= rs.getString("COUNTRYNAME");
				String MOBILENUMBER= rs.getString("MOBILENUMBER");
				String EMAILID= rs.getString("EMAILID");
				
				System.out.println(METHOD_NAME + ID + FIRSTNAME + LASTNAME +CITY +COUNTRYID + COUNTRYNAME + EMAILID + MOBILENUMBER);
				c.setId(ID);
				c.setFirstName(FIRSTNAME);
				c.setLastName(LASTNAME);
				c.setCity(CITY);
				Country co = new Country(COUNTRYID,COUNTRYNAME);
				c.setCountry(co);
				c.setMobileNumber(MOBILENUMBER);
				c.setEmailId(EMAILID);
				
				cList.add(c);

			}
		}catch (SQLException ex) {
			ex.printStackTrace();
			throw ex;
		}

		finally{
			DbUtil.closeAll(null, statement, conn);
		}
			return cList;
	}

}
