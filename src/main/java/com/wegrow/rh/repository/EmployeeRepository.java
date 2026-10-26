package com.wegrow.rh.repository;
import com.wegrow.rh.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import java.util.*;
import java.time.*;
public interface EmployeeRepository extends JpaRepository<Employee,Long>, JpaSpecificationExecutor<Employee> { boolean existsByMatricule(String matricule); boolean existsByMatriculeAndIdNot(String matricule, Long id); boolean existsByEmailIgnoreCase(String email); boolean existsByEmailIgnoreCaseAndIdNot(String email, Long id); boolean existsByDepartmentId(Long departmentId); List<Employee> findByManagerId(Long managerId); }
