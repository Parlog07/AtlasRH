package com.wegrow.rh.service;
import com.wegrow.rh.dto.*;
import com.wegrow.rh.entity.Department;
import com.wegrow.rh.repository.*;
import com.wegrow.rh.mapper.DepartmentMapper;
import com.wegrow.rh.exception.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.*;
@Service
public class DepartmentService {
 private final DepartmentRepository departments; private final EmployeeRepository employees; private final DepartmentMapper mapper;
 public DepartmentService(DepartmentRepository departments,EmployeeRepository employees,DepartmentMapper mapper){this.departments=departments;this.employees=employees;this.mapper=mapper;}
 @Transactional public DepartmentResponseDTO create(DepartmentRequestDTO dto){if(departments.existsByNameIgnoreCase(dto.name()))throw new ConflictException("Department name already exists");return mapper.toDTO(departments.save(mapper.toEntity(dto)));}
 @Transactional(readOnly=true) public List<DepartmentResponseDTO> all(){return departments.findAll().stream().map(mapper::toDTO).toList();}
 @Transactional(readOnly=true) public DepartmentResponseDTO get(Long id){return mapper.toDTO(find(id));}
 @Transactional public DepartmentResponseDTO update(Long id,DepartmentRequestDTO dto){Department d=find(id);if(departments.existsByNameIgnoreCaseAndIdNot(dto.name(),id))throw new ConflictException("Department name already exists");mapper.update(dto,d);return mapper.toDTO(departments.save(d));}
 @Transactional public void delete(Long id){find(id);if(employees.existsByDepartmentId(id))throw new ConflictException("Department contains employees");departments.deleteById(id);}
 private Department find(Long id){return departments.findById(id).orElseThrow(()->new NotFoundException("Department not found"));}
}
