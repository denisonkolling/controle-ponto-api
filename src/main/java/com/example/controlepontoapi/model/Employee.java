package com.example.controlepontoapi.model;

import com.example.controlepontoapi.dto.EmployeeRequestDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String position;

    private Double salary;

    @OneToMany(mappedBy = "employee", orphanRemoval = true, cascade = {CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    private List<Register> registers;

    public Employee(EmployeeRequestDTO createEmployeeDTO) {
        this.name = createEmployeeDTO.name();
        this.position = createEmployeeDTO.position();
        this.salary = createEmployeeDTO.salary();
    }
}
