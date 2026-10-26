package com.wegrow.rh.mapper;
import com.wegrow.rh.entity.Department;
import com.wegrow.rh.dto.*;
import org.mapstruct.*;
@Mapper(componentModel="spring")
public interface DepartmentMapper {
 Department toEntity(DepartmentRequestDTO dto);
 DepartmentResponseDTO toDTO(Department entity);
 void update(DepartmentRequestDTO dto, @MappingTarget Department entity);
}
