package com.restint.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.restint.model.Employee;


@Repository
public interface EmployeeDao extends JpaRepository<Employee,Long>{

}
