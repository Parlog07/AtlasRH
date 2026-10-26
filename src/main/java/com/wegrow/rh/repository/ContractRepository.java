package com.wegrow.rh.repository;
import com.wegrow.rh.entity.Contract;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import java.util.*;
import java.time.*;
public interface ContractRepository extends JpaRepository<Contract,Long> { List<Contract> findByEmployeeIdOrderByStartDateDesc(Long employeeId); boolean existsByEmployeeIdAndTerminatedFalseAndStartDateLessThanEqualAndEndDateGreaterThanEqual(Long employeeId, LocalDate date1, LocalDate date2); boolean existsByEmployeeIdAndTerminatedFalseAndStartDateLessThanEqualAndEndDateIsNull(Long employeeId, LocalDate date); }
