package com.wegrow.rh.controller;
import com.wegrow.rh.service.*;
import com.wegrow.rh.dto.*;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.*;
import org.springframework.data.domain.*;
import org.springframework.data.web.PageableDefault;
import java.util.*;
@RestController @RequestMapping("/api")
public class ContractController {
 private final ContractService service;public ContractController(ContractService service){this.service=service;}
 @PostMapping("/contracts") public ResponseEntity<ContractResponseDTO> create(@Valid @RequestBody ContractRequestDTO dto){return ResponseEntity.status(HttpStatus.CREATED).body(service.create(dto));}
 @PatchMapping("/contracts/{id}/terminate") public ContractResponseDTO terminate(@PathVariable Long id,@Valid @RequestBody TerminateContractDTO dto){return service.terminate(id,dto);}
 @GetMapping("/employees/{employeeId}/contracts") public List<ContractResponseDTO> history(@PathVariable Long employeeId){return service.history(employeeId);}
}
