package com.alura.literatura.repository;

import com.alura.literatura.model.Libro;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LibroRepository extends JpaRepository<Libro, Integer> {

    List<Libro> findByLanguages(String languages);
}
