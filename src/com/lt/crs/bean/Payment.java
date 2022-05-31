package com.lt.crs.bean;

public class Payment {
	
	public String refernceId;
	private String studentId;
	public int amount;
	private boolean status;
	public String paymentType;
	
	
	public String getRefernceId() {
		return refernceId;
	}
	public void setRefernceId(String refernceId) {
		this.refernceId = refernceId;
	}
	public String getStudentId() {
		return studentId;
	}
	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public String getPaymentType() {
		return paymentType;
	}
	public void setPaymentType(String paymentType) {
		this.paymentType = paymentType;
	}
	
	
	public String toString() 
	{
		return "paymentType[refernceId ," + refernceId + "studentId ," + studentId +
				"amount ," +amount+"status ,"+ status +"paymentType ,"+ paymentType +"]";
		
	}
	
	

}
