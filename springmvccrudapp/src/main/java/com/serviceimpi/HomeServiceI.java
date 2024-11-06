package com.serviceimpi;

import java.util.List;

import com.model.Student;

public interface HomeServiceI {

	public void saveStudent(Student s);

	public List<Student> loginCheck(String username, String password);

	public List<Student> deleteStudent(int rollno);

	public Student editStudent(int rollno);

	public List<Student> updateStudent(Student s);

}
