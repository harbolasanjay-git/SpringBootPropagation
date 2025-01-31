package com.tranPropagation.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.tranPropagation.dto.StudentDTO;
import com.tranPropagation.model.Department;
import com.tranPropagation.repository.DepartmentRepositorty;

@Service
public class DepartmentService {
	
	private Department department;

	@Autowired
	private StudentService studentService;
	
	@Autowired
	private DepartmentRepositorty repository;
	
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public String saveDepartment(StudentDTO studentDTO) throws Exception{
		department = new Department();
		department.setDepartmentName(studentDTO.getDepartment());
		repository.save(department);
		if(department.getDepartmentName().equalsIgnoreCase("it")) {
			throw new Exception();
		}
		studentService.saveStudentDetail(studentDTO,department);
		
		return "Data Saved Successfully!!" + studentDTO.getStudentName();
	}
}
