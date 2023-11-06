package com.example.proyecto01.infrastracture;
import com.example.proyecto01.domain.Cafe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CafeRepository extends JpaRepository<Cafe,Long> {

}