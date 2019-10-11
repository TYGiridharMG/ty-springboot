package com.tyss.tyspringboot.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.tyss.tyspringboot.dto.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
	public List<Employee> findByName(String name);
	
	@Transactional
	@Modifying
	@Query("update Employee e set e.name=:name, e.password=:password where e.id=:id")
	public void update(@Param("name")String name, @Param("password")String password, @Param("id")int id);
}
