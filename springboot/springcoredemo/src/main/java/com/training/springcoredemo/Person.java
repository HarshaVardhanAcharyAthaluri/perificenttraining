package com.training.springcoredemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
public class Person {

	private String name;
	
	@Autowired
	private Adress addr;
	
	@Autowired
	public Person(Adress addr) {
		this.addr = addr;
	}
	
	
	public Adress getAddr() {
		return addr;
	}
	
	@Autowired
	public void setAddr(Adress addr) {
		this.addr = addr;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public String toString() {
		return "Person [name=" + name + ", addr=" + addr + "]";
	}
	
	
	
}
