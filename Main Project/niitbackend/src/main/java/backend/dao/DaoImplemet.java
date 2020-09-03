package backend.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import backend.model.Customer;



@Repository
public class DaoImplemet implements DaoInterface {
	
	@Autowired
	private SessionFactory session;
	
	public List<Customer> getCustomer() {
		
		Session current = session.getCurrentSession();
		System.out.println("in dao");
		Query theQuery = current.createQuery("from Customer order by Id");
		
		List<Customer> customer = theQuery.list();
		
		return customer;
	}

	public void saveCustomer(Customer theCustomer) {
		Session current = session.getCurrentSession();
		current.saveOrUpdate(theCustomer);
	
	}

	public Customer getCustomer(int theId) {
		
		Session current = session.getCurrentSession();
		
		Customer theCustomer = (Customer) current.get(Customer.class, theId);	
		
		return theCustomer;
	}

	public void deleteCustomer(int theId) {
		Session current = session.getCurrentSession();
		
		Query theQuery = current.createQuery("delete from Customer where id=:customerId");
		
		theQuery.setParameter("customerId",theId);
		
		theQuery.executeUpdate();
		
	}

	public void deleteAllCustomers() {
		
		Session current = session.getCurrentSession();
		
		Query theQuery = current.createSQLQuery("Truncate table customer");
		
		theQuery.executeUpdate();
		
	}

}
