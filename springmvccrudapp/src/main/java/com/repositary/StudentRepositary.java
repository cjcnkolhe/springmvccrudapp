package com.repositary;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.model.Student;


public interface StudentRepositary {

	public void saveStudent(Student s);
	public List<Student> loginCheck(String username, String password);
	public List<Student> deleteStudent(int rollno);
	public Student editStudent(int rollno);
	public List<Student> updateStudent(Student s) ;
	
	
}
