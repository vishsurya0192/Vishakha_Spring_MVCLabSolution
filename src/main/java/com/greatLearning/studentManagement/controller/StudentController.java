package com.greatLearning.studentManagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.greatLearning.studentManagement.entity.Student;
import com.greatLearning.studentManagement.service.StudentService;

@Controller
@RequestMapping("/student")
public class StudentController {
	
	@Autowired
	private StudentService studentService;
	
	//add ampping for "/list"
	
	@RequestMapping("/list")
	public String listBooks(Model theModel) {
		System.out.println("request received");
		
		//get books from db
		List<Student> theStudents = studentService.findAll();
		
		//add to the spring model
		theModel.addAttribute("Students", theStudents);
		return "list-Students";
	}
	
	@RequestMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel){
		//create model attribute to bind from data
		Student theStudent = new Student();
		
		theModel.addAttribute("Student" ,theStudent);
		return "Student-form";	
	}
	
	@RequestMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("studentId") int theId, Model theModel) {
		
		//get the book from the service
		Student theStudent = studentService.findById(theId);
		
		//set book as a model attribute to pre-populate the form
		theModel.addAttribute("Student" , theStudent);
		
		//send over to our form
		return "Student-form";		
		
	}
	
	@PostMapping("/save")
	public String saveBook(@RequestParam("id") int id, @RequestParam("name") String name, 
			@RequestParam("department") String department, @RequestParam("country") String country) {
		System.out.println(id);
		Student theStudent;
		if(id != 0) {
			theStudent = studentService.findById(id);
			theStudent.setName(name);
			theStudent.setDepartment(department);
			theStudent.setCountry(country);
		}else
			theStudent = new Student(name, department, country);
		
		//save the book
		studentService.save(theStudent);
		
		//use a redirect to prevent duplicate submissions
		return "redirect:/student/list";
	}
	
	@RequestMapping("/delete")
	public String delete(@RequestParam("studentId") int theId){
		//delete the book
		studentService.deleteById(theId);
		
		//redirect to /Books/list
		return "redirect:/student/list";
		
	}
	

}
