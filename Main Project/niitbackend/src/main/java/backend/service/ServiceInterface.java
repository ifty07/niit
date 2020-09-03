package backend.service;

import java.util.List;

import backend.model.Customer;



public interface ServiceInterface {
	
	public List<Customer> getCustomers();

	public void saveCustomer(Customer theCustomer);

	public Customer getCustomers(int theId);

	public void deleteCustomer(int theId);

	public void deleteAllCustomer();

}
