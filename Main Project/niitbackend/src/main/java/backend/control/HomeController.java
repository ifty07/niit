package backend.control;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import backend.model.Customer;
import backend.service.ServiceInterface;



@RestController
@RequestMapping("/customer")
public class HomeController {
	
	@Autowired
	private ServiceInterface service;
	
	ModelAndView mv = new ModelAndView();
	
	@GetMapping("/list")
	public ModelAndView add(Model model)
	{
		
		List<Customer> theCustomer = service.getCustomers();
		
		model.addAttribute("customerdetails",theCustomer);
		
		
		mv.setViewName("list");
		
		return mv;
	}
	
	@GetMapping("/showAddForm")
	public ModelAndView addForm(Model model)
	{
		Customer theCustomer = new Customer();
		
		model.addAttribute("customer", theCustomer);
		
		mv.setViewName("form");
		
		return mv;
	}
	
	@PostMapping("/saveCustomer")
	public String addForm(@ModelAttribute("customer") Customer theCustomer)
	{
		service.saveCustomer(theCustomer);
	
		return "redirect:/customer/list";
		
	}

	@GetMapping("/showUpdate")
	public ModelAndView updateForm(@RequestParam("customerId") int theId, Model model)
	{
		Customer theCustomer = service.getCustomers(theId);
		
		model.addAttribute("customer",theCustomer);
		
		mv.setViewName("form");
		
		return mv;
	}
	
	@GetMapping("/delete")
	public String deleteForm(@RequestParam("customerId") int theId)
	{
		service.deleteCustomer(theId);
		
		//mv.setViewName("list");
		
		return "redirect:/customer/list";
	}
	
	@GetMapping("/deleteall")
	public String deleteAll()
	{
		service.deleteAllCustomer();
		
		//mv.setViewName("list");
		
		return "redirect:/customer/list";
	}
	
}
