package com.example.proyecto01.infrastracture;
import com.example.proyecto01.domain.Tienda;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TiendaRepository extends JpaRepository<Tienda,Long> {

}