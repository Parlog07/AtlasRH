package com.wegrow.rh.mapper;
import com.wegrow.rh.entity.Contract;
import com.wegrow.rh.dto.*;
import org.mapstruct.*;
@Mapper(componentModel="spring")
public interface ContractMapper {
 @Mapping(target="employee",ignore=true) @Mapping(target="terminated",ignore=true)
 Contract toEntity(ContractRequestDTO dto);
 @Mapping(target="employeeId",source="employee.id")
 ContractResponseDTO toDTO(Contract entity);
}
