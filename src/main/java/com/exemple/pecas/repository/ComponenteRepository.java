package com.exemple.pecas.repository;

import com.example.pecas.model.Componente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ComponenteRepository extends JpaRepository<Componente, Long> {
    List<Componente> findByPecaCodigo(String codigo);
}
