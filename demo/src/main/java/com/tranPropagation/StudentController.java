package com.tranPropagation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tranPropagation.dto.StudentDTO;
import com.tranPropagation.service.DepartmentService;

@RestController
@RequestMapping("/api")
public class StudentController {
	
	@Autowired
	private DepartmentService departmentService;
	
	@PostMapping("/save")
	public String saveStudentDetail(@RequestBody StudentDTO studentDTO) throws Exception{
		return departmentService.saveDepartment(studentDTO);
	}
}
