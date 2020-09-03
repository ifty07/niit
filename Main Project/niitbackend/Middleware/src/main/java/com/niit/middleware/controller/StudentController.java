package com.niit.middleware.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.niit.backend.Student;
import com.niit.backend.StudentService;



@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/student")
public class StudentController {
	
	@Autowired
	private StudentService studService;
	
	@GetMapping
	public List<Student> listAllFact()
	{
		List<Student> fact = studService.getStudentList();
		return fact;
	}
	
	@PostMapping
	public ResponseEntity<Void> addFact(@RequestBody Student stud)
	{
		if(studService.getStudentid(stud.getId())==null)
		{
			studService.addStudent(stud);
			return new ResponseEntity<Void>(HttpStatus.CREATED);
		}
		else
		{
			return new ResponseEntity<Void>(HttpStatus.CONFLICT);
		}
	}
	
	@PutMapping
	public ResponseEntity<Void> updateFact(@RequestBody Student stud)
	{
		if(studService.getStudentid(stud.getId())!=null)
		{
			studService.updateStudent(stud);
			return new ResponseEntity<Void>(HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}
	}
	
	@DeleteMapping("/{factId}")
	public ResponseEntity<Student> deleteById(@PathVariable("factId") int studid)
	{
		Student stud = null;
		studService.deleteStudent(studid);
		return new ResponseEntity<Student>(HttpStatus.OK);
	}
	
	@DeleteMapping("/delete")
	public boolean deleteAll()
	{
		studService.deleteAll();
		return true;
	}
	
	@GetMapping("/{factId}")
	public ResponseEntity<Student> getById(@PathVariable("factId") int studid)
	{
		Student stud = null;
		return new ResponseEntity<Student>(studService.getStudentid(studid),HttpStatus.OK);
	}
	

}
