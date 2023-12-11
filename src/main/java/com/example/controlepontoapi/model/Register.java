package com.example.controlepontoapi.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class Register {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "employee_id", nullable = false, referencedColumnName = "id")
    private Employee employee;

    private LocalDateTime registeredAt;

    private RegisterType type;

    public Register(RegisterType type, Employee employee) {
        this.registeredAt = LocalDateTime.now();
        this.type = type;
        this.employee = employee;
    }

}
