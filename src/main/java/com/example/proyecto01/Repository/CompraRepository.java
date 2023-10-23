package com.example.proyecto01.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.proyecto01.domain.Compra;


@Repository
public interface CompraRepository extends JpaRepository<Compra,Long> {
}

