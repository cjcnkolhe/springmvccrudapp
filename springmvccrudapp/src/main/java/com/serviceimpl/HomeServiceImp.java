package com.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.model.Student;
import com.repositary.StudentRepositary;
import com.serviceimpi.HomeServiceI;

@Service
public class HomeServiceImp implements HomeServiceI{

	@Autowired
	StudentRepositary sr;
	
	@Override
	public void saveStudent(Student s) {
		sr.saveStudent(s);
	}

	@Override
	public List<Student> loginCheck(String username, String password) {
		return sr.loginCheck(username, password);
	}

	@Override
	public List<Student> deleteStudent(int rollno) {
		return sr.deleteStudent(rollno);
	}

	@Override
	public Student editStudent(int rollno) {
		return sr.editStudent(rollno);
	}

	@Override
	public List<Student> updateStudent(Student s) {
		return sr.updateStudent(s);
	}

}
