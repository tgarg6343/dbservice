package com.kkd;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CustomerDetailsServiceApplication implements CommandLineRunner{

	

	private int pincode;
	private String addressLine;
	private String city;
	private String district;
	private String state;
	
	
	@Autowired
	private CustomerRepository customerRepository;
	public static void main(String[] args) {
		SpringApplication.run(CustomerDetailsServiceApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("starting -------------------------------------------------------");
		customerRepository.save(new Customer("hgbhj", "hgbhj","hgbhj","hgbhj", "hgbhj", null, null));
		List<Address> addresses=new ArrayList<Address>();
		addresses.add(new Address(132039, "assandh house no. 58", "assandh", "karnal", "haryana"));
		customerRepository.save(new Customer("hgbhjjgbcfjbf", "hgbhj", "hgbhj","hgbhj", "hgbhj",addresses,
				new Address(132039, "assandh house no. 58", "assandh", "karnal", "haryana")));
		
		//customerRepository.save(new Cust)
	}
}
