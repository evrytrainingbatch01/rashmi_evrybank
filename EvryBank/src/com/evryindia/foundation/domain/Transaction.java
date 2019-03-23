/**
 * 
 */
package com.evryindia.foundation.domain;

import java.util.ArrayList;

/**
 * @author rashmi.kiran
 *
 */
public class Transaction {
	Customer cust;

	String operation;
	String transId;
	String approvedBy;
	String approvalStatus;
	String approvedWhen;
	String transTime;
	
	public Customer getCust() {
		return cust;
	}
	public void setCust(Customer cust) {
		this.cust = cust;
	}
	public String getOperation() {
		return operation;
	}
	public void setOperation(String operation) {
		this.operation = operation;
	}
	public String getTransId() {
		return transId;
	}
	public void setTransId(String transId) {
		this.transId = transId;
	}
	public String getApprovedBy() {
		return approvedBy;
	}
	public void setApprovedBy(String approvedBy) {
		this.approvedBy = approvedBy;
	}
	public String getApprovalStatus() {
		return approvalStatus;
	}
	public void setApprovalStatus(String approvalStatus) {
		this.approvalStatus = approvalStatus;
	}
	public String getApprovedWhen() {
		return approvedWhen;
	}
	public void setApprovedWhen(String approvedWhen) {
		this.approvedWhen = approvedWhen;
	}
	public String getTransTime() {
		return transTime;
	}
	public void setTransTime(String transTime) {
		this.transTime = transTime;
	}
	public static ArrayList<String> getTransOperType() {
		return TRANS_OPER_TYPE;
	}
	public static final ArrayList<String> TRANS_OPER_TYPE = new ArrayList<String>();
	static {
		TRANS_OPER_TYPE.add("DEPOSIT");
		TRANS_OPER_TYPE.add("WITHDRAW");
	}
	

}
