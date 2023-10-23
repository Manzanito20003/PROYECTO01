package com.example.proyecto01.infrastracture;
import com.example.proyecto01.domain.Maquina;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MaquinaRepository extends JpaRepository<Maquina,Long> {
}
