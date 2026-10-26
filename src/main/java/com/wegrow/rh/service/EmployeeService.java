package com.wegrow.rh.service;
import com.wegrow.rh.dto.*;
import com.wegrow.rh.entity.*;
import com.wegrow.rh.repository.*;
import com.wegrow.rh.mapper.EmployeeMapper;
import com.wegrow.rh.exception.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.data.domain.*;
import org.springframework.data.jpa.domain.Specification;
import jakarta.persistence.criteria.*;
import java.util.*;
@Service
public class EmployeeService {
 private final EmployeeRepository employees; private final DepartmentRepository departments; private final EmployeeMapper mapper;
 public EmployeeService(EmployeeRepository employees,DepartmentRepository departments,EmployeeMapper mapper){this.employees=employees;this.departments=departments;this.mapper=mapper;}
 @Transactional public EmployeeResponseDTO create(EmployeeRequestDTO dto){validateUnique(dto,null);Employee e=mapper.toEntity(dto);assignRelations(e,dto,null);return mapper.toDTO(employees.save(e));}
 @Transactional public EmployeeResponseDTO update(Long id,EmployeeRequestDTO dto){Employee e=find(id);validateUnique(dto,id);mapper.update(dto,e);assignRelations(e,dto,id);return mapper.toDTO(employees.save(e));}
 @Transactional(readOnly=true) public EmployeeResponseDTO get(Long id){return mapper.toDTO(find(id));}
 @Transactional(readOnly=true) public List<EmployeeResponseDTO> team(Long managerId){find(managerId);return employees.findByManagerId(managerId).stream().map(mapper::toDTO).toList();}
 @Transactional(readOnly=true) public Page<EmployeeResponseDTO> search(String name,Long departmentId,Pageable pageable){
  Specification<Employee> spec=(root,query,cb)->cb.conjunction();
  if(name!=null&&!name.isBlank()){String pattern="%"+name.toLowerCase()+"%";spec=spec.and((root,query,cb)->cb.or(cb.like(cb.lower(root.get("firstName")),pattern),cb.like(cb.lower(root.get("lastName")),pattern)));}
  if(departmentId!=null)spec=spec.and((root,query,cb)->cb.equal(root.get("department").get("id"),departmentId));
  return employees.findAll(spec,pageable).map(mapper::toDTO);
 }
 private void validateUnique(EmployeeRequestDTO dto,Long id){
  if(id==null?employees.existsByMatricule(dto.matricule()):employees.existsByMatriculeAndIdNot(dto.matricule(),id))throw new ConflictException("Matricule already exists");
  if(id==null?employees.existsByEmailIgnoreCase(dto.email()):employees.existsByEmailIgnoreCaseAndIdNot(dto.email(),id))throw new ConflictException("Email already exists");
 }
 private void assignRelations(Employee e,EmployeeRequestDTO dto,Long id){
  e.setDepartment(departments.findById(dto.departmentId()).orElseThrow(()->new NotFoundException("Department not found")));
  if(dto.managerId()==null){e.setManager(null);return;}
  if(dto.managerId().equals(id))throw new ConflictException("Employee cannot manage themselves");
  Employee manager=find(dto.managerId());
  Employee cursor=manager;
  while(cursor!=null){if(id!=null&&id.equals(cursor.getId()))throw new ConflictException("Manager hierarchy cycle");cursor=cursor.getManager();}
  e.setManager(manager);
 }
 private Employee find(Long id){return employees.findById(id).orElseThrow(()->new NotFoundException("Employee not found"));}
}
