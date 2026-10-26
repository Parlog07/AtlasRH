package com.wegrow.rh.dto;
import jakarta.validation.constraints.*;
import java.time.LocalDate;
import java.math.BigDecimal;
import com.wegrow.rh.enums.ContractType;
public record DepartmentResponseDTO(Long id, String name, String description) {}
