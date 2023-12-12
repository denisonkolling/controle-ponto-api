package com.example.controlepontoapi.dto;

import com.example.controlepontoapi.model.Employee;

import java.util.List;

public record EmployeeRegistersResponseDTO(Long id, String name, String position, Double salary, List<RegisterDTO> registers) {

    public EmployeeRegistersResponseDTO(Employee employee) {
        this(employee.getId(), employee.getName(), employee.getPosition(), employee.getSalary(), employee.getRecordsAsObject());
    }

}
