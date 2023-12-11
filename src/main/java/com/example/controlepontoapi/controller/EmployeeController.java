package com.example.controlepontoapi.controller;

import com.example.controlepontoapi.dto.EmployeeRequestDTO;
import com.example.controlepontoapi.dto.EmployeeResponseDTO;
import com.example.controlepontoapi.service.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
