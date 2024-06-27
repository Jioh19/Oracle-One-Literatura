package com.alura.literatura.repository;

import com.alura.literatura.model.Autor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AutorRepository extends JpaRepository<Autor, Integer> {

    @Query("SELECT CASE WHEN count(*)> 0 then true ELSE false end FROM Autor WHERE name= :name")
    boolean checkAutor(@Param("name") String name);

    Autor findByName(String name);

    @Query("SELECT a FROM Autor a WHERE birth_year < :year AND death_year > :year")
    List<Autor> yearAutor(int year);
}
