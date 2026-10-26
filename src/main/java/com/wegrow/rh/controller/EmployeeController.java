package com.wegrow.rh.controller;
import com.wegrow.rh.service.*;
import com.wegrow.rh.dto.*;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.*;
import org.springframework.data.domain.*;
import org.springframework.data.web.PageableDefault;
import java.util.*;
@RestController @RequestMapping("/api/employees")
public class EmployeeController {
 private final EmployeeService service;public EmployeeController(EmployeeService service){this.service=service;}
 @PostMapping public ResponseEntity<EmployeeResponseDTO> create(@Valid @RequestBody EmployeeRequestDTO dto){return ResponseEntity.status(HttpStatus.CREATED).body(service.create(dto));}
 @PutMapping("/{id}") public EmployeeResponseDTO update(@PathVariable Long id,@Valid @RequestBody EmployeeRequestDTO dto){return service.update(id,dto);}
 @GetMapping("/{id}") public EmployeeResponseDTO get(@PathVariable Long id){return service.get(id);}
 @GetMapping public Page<EmployeeResponseDTO> search(@RequestParam(required=false) String name,@RequestParam(required=false) Long departmentId,@PageableDefault(size=10,sort="lastName") Pageable pageable){return service.search(name,departmentId,pageable);}
 @GetMapping("/{id}/team") public List<EmployeeResponseDTO> team(@PathVariable Long id){return service.team(id);}
}
