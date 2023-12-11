package com.example.controlepontoapi.dto;

import com.example.controlepontoapi.model.Employee;

public record EmployeeResponseDTO(Long id, String name, String position, Double salary) {

    public EmployeeResponseDTO(Employee employee) {
        this(employee.getId(), employee.getName(), employee.getPosition(), employee.getSalary());
    }

}
