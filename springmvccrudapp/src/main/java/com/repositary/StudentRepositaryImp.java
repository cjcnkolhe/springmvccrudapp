package com.repositary;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import org.springframework.stereotype.Repository;

import com.model.Student;

@Repository
public class StudentRepositaryImp implements StudentRepositary {

	static List<Student> l = new ArrayList<Student>();

	@Override
	public void saveStudent(Student s) {
		l.add(s);
	}

	@Override
	public List<Student> loginCheck(String username, String password) {
		for (Student student : l) {
			if (username.equals(student.getUsername()) && password.equals(student.getPassword())) {
				return l;
			}
		}

		return null;
	}

	@Override
	public List<Student> deleteStudent(int rollno) {

		for (Student student : l) {
			if(student.getRollno()==rollno) {
			l.remove(student);
				return l;
		}
		}
		return null;
	}

	@Override
	public Student editStudent(int rollno) {
		for (Student student : l) {
			if(student.getRollno()==rollno) {
				return student;
			}
		}
		
		
		return null;
	}

	@Override
	public List<Student> updateStudent(Student s) {
		for (Student student : l) {
			if (student.getRollno()==s.getRollno()) {
				int index=l.indexOf(student);
				l.set(index, s);
			}
		}
		return l;
	}

}
