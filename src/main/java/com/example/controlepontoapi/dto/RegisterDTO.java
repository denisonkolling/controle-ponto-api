package com.example.controlepontoapi.dto;

import com.example.controlepontoapi.model.Register;
import com.example.controlepontoapi.model.RegisterType;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDateTime;

public record RegisterDTO(Long id, @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss") LocalDateTime registeredAt, RegisterType type) {

    public RegisterDTO(Register register) {
        this(register.getId(), register.getRegisteredAt(), register.getType());
    }
}
