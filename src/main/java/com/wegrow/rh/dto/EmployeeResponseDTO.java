package com.wegrow.rh.dto;
import jakarta.validation.constraints.*;
import java.time.LocalDate;
import java.math.BigDecimal;
import com.wegrow.rh.enums.ContractType;
public record EmployeeResponseDTO(Long id, String matricule, String firstName, String lastName, String email, String position, LocalDate hireDate, Long departmentId, Long managerId) {}
