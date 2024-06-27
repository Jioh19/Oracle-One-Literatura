package com.alura.literatura.service;

import com.alura.literatura.model.Autor;
import com.alura.literatura.model.DatosAutor;
import com.alura.literatura.model.Libro;
import com.alura.literatura.repository.AutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AutorService {

    @Autowired
    AutorRepository repository;

    public boolean checkAutor(String nombre) {
        return repository.checkAutor(nombre);
    }

    public Autor agregarAutor(DatosAutor datosAutor, Libro libro) {
        List<Libro> libros = new ArrayList<>();
        Autor autor = new Autor();
        if (checkAutor(datosAutor.name())) {
            System.out.println("Autor ya ingresado: " + datosAutor.name());
            autor = repository.findByName(datosAutor.name());
            libros = autor.getLibros();
            libros.add(libro);
            autor.setLibros(libros);
            repository.save(autor);
            return autor;
        }
        System.out.println("Ingresando autor: " + datosAutor.name());

        libros.add(libro);
        autor.setName(datosAutor.name());
        autor.setBirth_year(datosAutor.birth_year());
        autor.setDeath_year(datosAutor.death_year());
        autor.setLibros(libros);
        repository.save(autor);
        return autor;
    }

    public void listarAutores() {
        List<Autor> autores = repository.findAll();
        System.out.println(autores);
    }

    public void autorVivo(int anio) {
        System.out.println(repository.yearAutor(anio));
    }
}
