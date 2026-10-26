package com.wegrow.rh.controller;
import com.wegrow.rh.service.*;
import com.wegrow.rh.dto.*;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.*;
import org.springframework.data.domain.*;
import org.springframework.data.web.PageableDefault;
import java.util.*;
@RestController @RequestMapping("/api/departments")
public class DepartmentController {
 private final DepartmentService service; public DepartmentController(DepartmentService service){this.service=service;}
 @PostMapping public ResponseEntity<DepartmentResponseDTO> create(@Valid @RequestBody DepartmentRequestDTO dto){return ResponseEntity.status(HttpStatus.CREATED).body(service.create(dto));}
 @GetMapping public List<DepartmentResponseDTO> all(){return service.all();}
 @GetMapping("/{id}") public DepartmentResponseDTO get(@PathVariable Long id){return service.get(id);}
 @PutMapping("/{id}") public DepartmentResponseDTO update(@PathVariable Long id,@Valid @RequestBody DepartmentRequestDTO dto){return service.update(id,dto);}
 @DeleteMapping("/{id}") public ResponseEntity<Void> delete(@PathVariable Long id){service.delete(id);return ResponseEntity.noContent().build();}
}
