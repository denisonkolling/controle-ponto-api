package com.example.controlepontoapi.controller;

import com.example.controlepontoapi.dto.EmployeeRegistersResponseDTO;
import com.example.controlepontoapi.dto.EmployeeRequestDTO;
import com.example.controlepontoapi.dto.EmployeeResponseDTO;
import com.example.controlepontoapi.model.Employee;
import com.example.controlepontoapi.service.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @PostMapping
    public ResponseEntity<EmployeeResponseDTO> create(@RequestBody @Valid EmployeeRequestDTO request) {
        EmployeeResponseDTO response = this.employeeService.create(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping
    public ResponseEntity<Page<EmployeeResponseDTO>> list(@PageableDefault(size = 12, sort = "name") Pageable pageable) {
        Page<EmployeeResponseDTO> response = this.employeeService.listAll(pageable);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EmployeeRegistersResponseDTO> getById(@PathVariable("id") Long id) {
        EmployeeRegistersResponseDTO response = this.employeeService.getEmployee(id);
        return ResponseEntity.ok(response);
    }

}
