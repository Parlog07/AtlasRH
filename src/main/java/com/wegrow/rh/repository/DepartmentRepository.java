package com.wegrow.rh.repository;
import com.wegrow.rh.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import java.util.*;
import java.time.*;
public interface DepartmentRepository extends JpaRepository<Department,Long> { boolean existsByNameIgnoreCase(String name); boolean existsByNameIgnoreCaseAndIdNot(String name, Long id); }
