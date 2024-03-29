package com.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.app.entity.Employee;

public interface IEmployeeRepository extends JpaRepository<Employee, Integer>{
	//Login query of Employee 
	@Query("select e from Employee e where e.username=:username and e.password=:password")
	Employee validateEmployee(String username, String password);
}
