package com.training;

public class OrderChild extends Order{

	public void placeOrder(String item) {
		System.out.println("NON-VEG "+ item + " ordered");
	}
}
