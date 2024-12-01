package com.tranPropagation.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tranPropagation.model.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {

}
