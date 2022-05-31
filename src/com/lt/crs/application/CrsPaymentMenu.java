package com.lt.crs.application;

import com.lt.crs.bean.Payment;
import com.lt.crs.constants.InputConstants;
import com.lt.crs.constants.Menu;
import com.lt.crs.service.PaymentService;
import com.lt.crs.service.PaymentServiceInt;
import com.lt.crs.utils.Utils;

public class CrsPaymentMenu {
	
	

	
	private PaymentServiceInt coursePayment = new PaymentService();

	public void createMenu(Payment studentId)
	{   
		if(studentId.equals(studentId))
		{	
		Utils.printStatement("Select Payment Mode");
		
		InputConstants.optionNumber=InputConstants.sc.nextInt();	
		
		switch (InputConstants.optionNumber)
		{
		case 1:
			//Online --> 1.NetBanking  2.CardPayment.
			break;
		case 2:
			//Cash
			break;
		case 3:
			// Cheque
			break;
		case 4:
			//Scolarship
			break;
			
		default:
			break;
		}
	 }
		
		
		
    	}
		
	}
	
