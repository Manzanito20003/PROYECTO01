package com.example.proyecto01.infraestructure;

import com.example.proyecto01.domain.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente,Long> {
}
