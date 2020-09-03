package backend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import backend.dao.DaoInterface;
import backend.model.Customer;



@Service
public class ServiceImpl implements ServiceInterface {
	
	@Autowired
	private DaoInterface dao;

	@Transactional
	public List<Customer> getCustomers() {
		
			return dao.getCustomer();
	}
	@Transactional
	public void saveCustomer(Customer theCustomer) {
		dao.saveCustomer(theCustomer);
	}
	@Transactional
	public Customer getCustomers(int theId) {
		
		return dao.getCustomer(theId);
	}
	@Transactional
	public void deleteCustomer(int theId) {
		
		dao.deleteCustomer(theId);
	}
	@Transactional
	public void deleteAllCustomer() {
		// TODO Auto-generated method stub
		dao.deleteAllCustomers();
	}

}
