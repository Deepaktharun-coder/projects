package com.example.demo;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class Studentcontroller {
	@Autowired
	private Studentrepo repo;
	@GetMapping("/")
	public String addstudents(Model m) {
		m.addAttribute("st",new Student() );
		return "index";
		
	}
	@PostMapping("/")
	public String adddata(@ModelAttribute Student std) {
		repo.save(std);
		return "redirect:/view";
	}
	@GetMapping("/view")
	public String view(Model m) {
		List<Student> li=repo.findAll();
		m.addAttribute("viewlist",li);
		return "view";
	}
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable int id) {
		repo.deleteById(id);
		return "redirect:/view";
	}
	@GetMapping("/edit/{id}")
	public String update(@PathVariable int id,Model m) {
		Optional<Student> li= repo.findById(id);
		m.addAttribute("up",li.get());
	return "edit";
	}
	@PostMapping("/update")
	public String submit(@ModelAttribute Student std) {
		repo.save(std);
		return "redirect:/view";
	}
	


}
