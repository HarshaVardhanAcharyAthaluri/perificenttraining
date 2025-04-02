package com.training.springcoredemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import com.learning.springcoredemo.OtherClass;

@ComponentScan(basePackages = {"com.training.springcoredemo","com.learning.springcoredemo"})
@SpringBootApplication
public class SpringcoredemoApplication {

	public static void main(String[] args) {
		ApplicationContext ioc = SpringApplication.run(SpringcoredemoApplication.class, args);
		
		OtherClass other = ioc.getBean(OtherClass.class);
		other.setMsg("Hello ALL");
		System.out.println(other);
		
		Person p1 = ioc.getBean(Person.class);
		p1.setName("vivek");
		
		Adress addr = ioc.getBean(Adress.class);
		addr.setCity("NY");
		addr.setState("CAL");
		addr.setZip("123454");
		
		System.out.println("P1 Object : "+p1);
		
		
		
	}

}
