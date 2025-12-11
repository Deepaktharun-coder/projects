package com.example.demo;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class EmployeeController {
	
	@Autowired
	private EmployeeRepository repo;
	
	@GetMapping("/")
	public String showForm(Model m)
	{
		m.addAttribute("employee",new employee());
		return "index";
	}
	@PostMapping("/")
	public String submitForm(@ModelAttribute employee employee)
	{
		repo.save(employee);
		return "redirect:/view";
	}
	@GetMapping("/view")
	public String showList(Model m)
	{
		List<employee> li=repo.findAll();
		m.addAttribute("list",li);
		return "view";
	}
	@GetMapping("/edit/{id}")
	public String showEditForm(@PathVariable int id,Model m)
	{
		Optional<employee> li=repo.findById(id);
		m.addAttribute("employee",li.get());
		return "edit";
	}
	@PostMapping("/update")
	public String updateForm(@ModelAttribute employee employee)
	{
		repo.save(employee);
		return "redirect:/view"; 
	}
	
	@GetMapping("/delete/{id}")
	public String deleteList(@PathVariable int id)
	{
		repo.deleteById(id);
		return "redirect:/view";
	}}