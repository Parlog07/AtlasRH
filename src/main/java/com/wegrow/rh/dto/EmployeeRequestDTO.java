package com.wegrow.rh.dto;
import jakarta.validation.constraints.*;
import java.time.LocalDate;
import java.math.BigDecimal;
import com.wegrow.rh.enums.ContractType;
public record EmployeeRequestDTO(@NotBlank String matricule, @NotBlank String firstName, @NotBlank String lastName, @NotBlank @Email String email, @NotBlank String position, @NotNull LocalDate hireDate, @NotNull Long departmentId, Long managerId) {}
