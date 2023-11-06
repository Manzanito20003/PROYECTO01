package com.example.proyecto01.infrastracture;
import com.example.proyecto01.domain.Snack;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SnackRepository extends JpaRepository<Snack,Long> {

}
