package com.wegrow.rh.dto;
import jakarta.validation.constraints.*;
import java.time.LocalDate;
import java.math.BigDecimal;
import com.wegrow.rh.enums.ContractType;
public record ContractResponseDTO(Long id, Long employeeId, ContractType type, LocalDate startDate, LocalDate endDate, BigDecimal grossSalary, boolean terminated) {}
