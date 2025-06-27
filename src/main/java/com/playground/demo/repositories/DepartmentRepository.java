package com.playground.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.playground.demo.entities.Department;

public interface DepartmentRepository extends JpaRepository<Department, Long>{

}