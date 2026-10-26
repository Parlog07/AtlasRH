package com.wegrow.rh.service;
import com.wegrow.rh.dto.*;
import com.wegrow.rh.entity.*;
import com.wegrow.rh.enums.ContractType;
import com.wegrow.rh.repository.*;
import com.wegrow.rh.mapper.ContractMapper;
import com.wegrow.rh.exception.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.time.LocalDate;
import java.util.*;
@Service
public class ContractService {
 private final ContractRepository contracts;private final EmployeeRepository employees;private final ContractMapper mapper;
 public ContractService(ContractRepository contracts,EmployeeRepository employees,ContractMapper mapper){this.contracts=contracts;this.employees=employees;this.mapper=mapper;}
 @Transactional public ContractResponseDTO create(ContractRequestDTO dto){
  Employee employee=employees.findById(dto.employeeId()).orElseThrow(()->new NotFoundException("Employee not found"));
  if(dto.endDate()!=null&&dto.endDate().isBefore(dto.startDate()))throw new IllegalArgumentException("End date precedes start date");
  if(dto.type()!=ContractType.CDI&&dto.endDate()==null)throw new IllegalArgumentException("CDD and STAGE require an end date");
  for(Contract old:contracts.findByEmployeeIdOrderByStartDateDesc(employee.getId())){
   if(!old.isTerminated()&&overlaps(old.getStartDate(),old.getEndDate(),dto.startDate(),dto.endDate()))throw new ConflictException("An overlapping active contract exists");
  }
  Contract contract=mapper.toEntity(dto);contract.setEmployee(employee);return mapper.toDTO(contracts.save(contract));
 }
 @Transactional public ContractResponseDTO terminate(Long id,TerminateContractDTO dto){
  Contract c=contracts.findById(id).orElseThrow(()->new NotFoundException("Contract not found"));
  if(c.isTerminated())throw new ConflictException("Contract already terminated");
  if(dto.endDate().isBefore(c.getStartDate()))throw new IllegalArgumentException("Termination precedes contract start");
  if(dto.endDate().isAfter(LocalDate.now()))throw new IllegalArgumentException("Termination cannot be in the future");
  if(c.getEndDate()!=null&&dto.endDate().isAfter(c.getEndDate()))throw new IllegalArgumentException("Termination exceeds original end date");
  c.setEndDate(dto.endDate());c.setTerminated(true);return mapper.toDTO(contracts.save(c));
 }
 @Transactional(readOnly=true) public List<ContractResponseDTO> history(Long employeeId){
  if(!employees.existsById(employeeId))throw new NotFoundException("Employee not found");
  return contracts.findByEmployeeIdOrderByStartDateDesc(employeeId).stream().map(mapper::toDTO).toList();
 }
 private boolean overlaps(LocalDate a,LocalDate b,LocalDate c,LocalDate d){return (d==null||!a.isAfter(d))&&(b==null||!c.isAfter(b));}
}
