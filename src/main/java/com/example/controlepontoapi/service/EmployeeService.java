package com.example.controlepontoapi.service;

import com.example.controlepontoapi.dto.*;
import com.example.controlepontoapi.model.Employee;
import com.example.controlepontoapi.model.Register;
import com.example.controlepontoapi.repository.EmployeeRepository;
import com.example.controlepontoapi.repository.RegisterRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;

    @Autowired
    RegisterRepository registerRepository;

    public EmployeeResponseDTO createEmployee(EmployeeRequestDTO request) {
        Employee newEmployee = this.employeeRepository.save(new Employee(request));
        return new EmployeeResponseDTO(newEmployee);
    }

    public Page<EmployeeResponseDTO> listAll(Pageable pageable) {
        return this.employeeRepository.findAll(pageable).map(EmployeeResponseDTO::new);
    }

    public EmployeeRegistersResponseDTO getEmployee(Long id) {
        return this.employeeRepository.findById(id).map(EmployeeRegistersResponseDTO::new)
                .orElseThrow(() -> new IllegalArgumentException("Employee with id not found: " + id));
    }

    public RegisterResponseDTO createRegister(Long id, RegisterRequestDTO request) {
        Employee employee = this.employeeRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Employee with id not found: " + id));

        Register register = new Register(request.type(), employee);

        this.registerRepository.save(register);

        return new RegisterResponseDTO(register);

    }

}
