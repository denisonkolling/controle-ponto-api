package com.example.controlepontoapi.dto;

import com.example.controlepontoapi.model.RegisterType;
import jakarta.validation.constraints.NotNull;

public record RegisterRequestDTO(@NotNull RegisterType type) {
}