package com.wegrow.rh.mapper;
import com.wegrow.rh.entity.Employee;
import com.wegrow.rh.dto.*;
import org.mapstruct.*;
@Mapper(componentModel="spring")
public interface EmployeeMapper {
 @Mapping(target="department",ignore=true) @Mapping(target="manager",ignore=true)
 Employee toEntity(EmployeeRequestDTO dto);
 @Mapping(target="departmentId",source="department.id") @Mapping(target="managerId",source="manager.id")
 EmployeeResponseDTO toDTO(Employee entity);
 @Mapping(target="department",ignore=true) @Mapping(target="manager",ignore=true)
 void update(EmployeeRequestDTO dto,@MappingTarget Employee entity);
}
