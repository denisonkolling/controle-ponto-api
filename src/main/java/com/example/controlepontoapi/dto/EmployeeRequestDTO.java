package com.example.controlepontoapi.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record EmployeeRequestDTO(@NotBlank String name, @NotBlank String position, @NotNull Double salary) {

}
