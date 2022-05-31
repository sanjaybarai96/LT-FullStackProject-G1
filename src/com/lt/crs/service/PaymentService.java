package com.lt.crs.service;

import java.util.Random;

import com.lt.crs.constants.InputConstants;
import com.lt.crs.constants.Menu;

public class PaymentService implements PaymentServiceInterface{

	@Override
	public void onlinePayment() {
		// TODO Auto-generated method stub
		System.out.println(Menu.OnlinePaymentMenu);
		InputConstants.optionNumber = InputConstants.sc.nextInt();
		switch (InputConstants.optionNumber) {
		case 1:
			this.cardPayment();
			break;
		case 2:
			break;
		default:
			break;
		}
		
	}

	private void cardPayment() {
		// TODO Auto-generated method stub
		System.out.println("Enter your 12 digit card number");
		String cardNo =  InputConstants.sc.next();
		System.out.println("Enter your CVV");
		String cvv = InputConstants.sc.next();
		this.sendOtp();
		
		System.out.println("Enter otp");
		int otp = InputConstants.sc.nextInt();
		
		System.out.println("Your payment successfully paid");
		
		
	}

	private void sendOtp() {
		int otp = new Random().nextInt(9999);
		System.out.println("Your otp is ::"+otp);
	}

	@Override
	public void cashPayment() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void chequePayment() {
		// TODO Auto-generated method stub
		
	}
}
