package com.example.controlepontoapi.service;

import com.example.controlepontoapi.dto.EmployeeRequestDTO;
import com.example.controlepontoapi.dto.EmployeeResponseDTO;
import com.example.controlepontoapi.model.Employee;
import com.example.controlepontoapi.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;

    public EmployeeResponseDTO create(EmployeeRequestDTO request) {
        Employee newEmployee = this.employeeRepository.save(new Employee(request));
        return new EmployeeResponseDTO(newEmployee);
    }

}