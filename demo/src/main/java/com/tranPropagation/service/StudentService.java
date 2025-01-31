package com.tranPropagation.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;

import com.tranPropagation.dto.StudentDTO;
import com.tranPropagation.model.Department;
import com.tranPropagation.model.Student;
import com.tranPropagation.repository.StudentRepository;

import org.springframework.transaction.annotation.Transactional;

@Service
public class StudentService {

	private Student student;
	
	@Autowired
	private StudentRepository repository;
	
	public List<Student> listOfStudent() {
		return repository.findAll();
	}

	public Student getStudentById(int studentId) {
		return repository.getById(studentId);
	}

	@Transactional(propagation = Propagation.REQUIRES_NEW, rollbackFor = Exception.class)
	public void saveStudentDetail(StudentDTO studentDTO, Department dept) throws Exception {
		student = new Student();
		if(studentDTO.getStudentName().equalsIgnoreCase("Admin")) {
			throw new Exception("Admin User can added once!!");
		}
		student.setStudentName(studentDTO.getStudentName());
		student.setAddress(studentDTO.getAddress());
		student.setDept(dept);
		Student student1 = repository.save(student);
		System.out.println("Detail of Student Save is : " +student1);
	}
}
