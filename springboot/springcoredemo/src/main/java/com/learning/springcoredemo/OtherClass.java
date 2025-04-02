package com.learning.springcoredemo;

import org.springframework.stereotype.Component;

@Component
public class OtherClass {

	private String msg;

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	@Override
	public String toString() {
		return "OtherClass [msg=" + msg + "]";
	}
	
	
}
