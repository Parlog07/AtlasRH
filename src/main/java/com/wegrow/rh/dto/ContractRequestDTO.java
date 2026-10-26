package com.wegrow.rh.dto;
import jakarta.validation.constraints.*;
import java.time.LocalDate;
import java.math.BigDecimal;
import com.wegrow.rh.enums.ContractType;
public record ContractRequestDTO(@NotNull Long employeeId, @NotNull ContractType type, @NotNull LocalDate startDate, LocalDate endDate, @NotNull @DecimalMin("0.01") BigDecimal grossSalary) {}
