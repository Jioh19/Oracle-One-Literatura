package com.alura.literatura.service;

import com.alura.literatura.model.*;
import com.alura.literatura.repository.LibroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@Service
public class LibroService {

    private final String URL_BASE = "https://gutendex.com/books/?search=";

    @Autowired
    private ConsumoApi api;
    @Autowired
    private LibroRepository repository;
    @Autowired
    private AutorService autorService;

    public void buscarLibro(Scanner sc) {
        var conversor = new ConvierteDatos();
        System.out.println("Ingrese título");
        String nombreLibro = sc.nextLine();
        var json = api.obtenerDatos(URL_BASE + nombreLibro.replace(" ", "+"));
        var libros = conversor.obtenerDatos(json, JsonResult.class);
        agregarLibro(libros.datosLibros());

    }

    public void agregarLibro(List<DatosLibro> datosLibros) {
        if (datosLibros.isEmpty()) {
            System.out.println("Libro no encontrado");
            return;
        }
        DatosLibro datosLibro = datosLibros.getFirst();
        System.out.println(datosLibro);
        if (repository.existsById(datosLibro.id())) {
            //System.out.println("Libro ya ingresado: " + datosLibro.title());
            return;
        }
        //System.out.println("Ingresando libro: " + datosLibro.title());
        Libro libro = new Libro();
        libro.setTitle(datosLibro.title());
        libro.setDownload_count(datosLibro.download_count());
        libro.setId(datosLibro.id());
        repository.save(libro);
        List<Autor> autores = new ArrayList<>();
        for (DatosAutor datosAutor : datosLibro.authors()) {
            Autor autor = autorService.agregarAutor(datosAutor, libro);
            autores.add(autor);
        }
        libro.setAutores(autores);
        //System.out.println("El libro ingresado es: " +libro);

    }

    public void listarLibros() {
        List<Libro> libros = repository.findAll();
        System.out.println(libros);
    }
}
