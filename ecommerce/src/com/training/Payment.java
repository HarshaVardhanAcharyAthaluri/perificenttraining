package com.training;

public class Payment {
	
	public int carnum = 1234567;
	public String cardname = "amex";
	public String holdername = "vivek";
	
	public void makePayment() {
		System.out.println("Payment success :: "+ holdername + " card :: " + carnum + " :: " + cardname);
	}

}
