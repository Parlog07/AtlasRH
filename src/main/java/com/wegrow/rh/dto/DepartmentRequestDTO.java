package com.wegrow.rh.dto;
import jakarta.validation.constraints.*;
import java.time.LocalDate;
import java.math.BigDecimal;
import com.wegrow.rh.enums.ContractType;
public record DepartmentRequestDTO(@NotBlank String name, String description) {}
