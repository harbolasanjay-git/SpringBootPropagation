package com.tranPropagation.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tranPropagation.model.Department;

@Repository
public interface DepartmentRepositorty extends JpaRepository<Department, Integer>{

}
