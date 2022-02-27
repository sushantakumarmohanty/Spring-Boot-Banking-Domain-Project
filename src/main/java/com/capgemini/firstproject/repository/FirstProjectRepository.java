package com.capgemini.firstproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capgemini.firstproject.entity.Employee;

@Repository
public interface FirstProjectRepository extends JpaRepository<Employee, Integer> {
 
}