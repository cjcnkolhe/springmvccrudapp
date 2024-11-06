package com.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.model.Student;
import com.serviceimpi.HomeServiceI;

@Controller
public class HomeController {

	@Autowired
	HomeServiceI hsi;
	
	@RequestMapping("/")
	public String preLogin() {
		System.out.println("call method");     
		return "login";
	}

	@RequestMapping("/openreg")
	public String preRegister() {
		return "register";
	}

	@RequestMapping("/save")
	public String saveStudent(@ModelAttribute Student s) {
		hsi.saveStudent(s);
		return "login";
	}

	@RequestMapping("/log")
	public String loginStudent(@RequestParam("username") String username,@RequestParam("password") String password,Model m) {
	
		List<Student> list=hsi.loginCheck(username,password);
				if(list!=null) {
					m.addAttribute("data", list);
				return "success";
			}  else {
				return "login";
			}
	}
	
	@RequestMapping("/delete")
	public String deleteStudent(@RequestParam("rollno") int rollno,Model m) {
		     List<Student> list= hsi.deleteStudent(rollno);
		     if(list!=null) {
					m.addAttribute("data", list);
				return "success";
			} else {
				return "login";
			}
	}
	
	
	@RequestMapping("/edit")
	public String editStudent(@RequestParam("rollno") int rollno,Model m) {
		     Student s= hsi.editStudent(rollno);
		     if(s!=null) {
					m.addAttribute("stu", s);
				return "edit";
			}else {
			return "login"; 
	}
	}
	
	@RequestMapping("/update")
	public String updateStudent(@ModelAttribute Student s,Model m) {
		 List<Student> list=hsi.updateStudent(s);
		 m.addAttribute("data", list);
		return "success";
	}
	
	
}
