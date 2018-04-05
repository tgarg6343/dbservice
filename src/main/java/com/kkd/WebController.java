package com.kkd;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/customer")
public class WebController {
	@Autowired
	private CustomerRepository customerRepository;

	@GetMapping("demo")
	public String demo() {
		return "success";
	}
	
	@GetMapping("/all")
	public List<Customer> getAll() {
		return customerRepository.findAll();
	}

	@PostMapping("/user")
	public void createUser(@RequestBody Customer customer) {
		customer.getPrimaryAddress().setPincode(null);
		customer.getPrimaryAddress().setAddressLine(null);
		customer.getPrimaryAddress().setCity(null);
		customer.getPrimaryAddress().setDistrict(null);
		customer.getPrimaryAddress().setState(null);
		customer.getAddresses().add(customer.getPrimaryAddress());
		customerRepository.save(customer);
	}
	
	@GetMapping("/user/{customer_id}")
	public Optional<Customer> findCustomer(@PathVariable String customer_id) {
		return customerRepository.findByCustomerId(customer_id);
	}
	
	@PostMapping("/user/{customer_id}")
	public void updateCustomer(@RequestBody Customer customer) {
		customerRepository.save(customer);
	}
	
	@GetMapping("/user/{customer_id}")
	public Optional<Customer> findCustomerByMobile(@PathVariable String mobile) {
		return customerRepository.findByMobileNo(mobile);
	}
	
	@DeleteMapping("/user/{customer_id}")
	public void deleteCustomer(@PathVariable String customer_id) {
		Optional<Customer> customer=customerRepository.findByCustomerId(customer_id);
		if(customer.isPresent()) {
			customerRepository.delete(customer.get());
		}
		
	}
	
}
