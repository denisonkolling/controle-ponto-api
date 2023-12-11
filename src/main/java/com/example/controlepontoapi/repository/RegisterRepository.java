package com.example.controlepontoapi.repository;

import com.example.controlepontoapi.model.Register;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Repository
public interface RegisterRepository extends JpaRepository<Register, Long> {
}
