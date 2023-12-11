package com.example.controlepontoapi.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class Register {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "employee_id", nullable = false, referencedColumnName = "id")
    private Employee employee;

    private LocalDateTime registeredAt;

    private RegisterType type;

}
