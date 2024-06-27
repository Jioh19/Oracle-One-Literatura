package com.alura.literatura.controller;

import com.alura.literatura.model.DatosLibro;
import com.alura.literatura.service.AutorService;
import com.alura.literatura.service.LibroService;

import java.util.Optional;
import java.util.Scanner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class Principal {

    @Autowired
    LibroService libroService;
    @Autowired
    AutorService autorService;

    public void muestraApi() {

        String menu = """
                
                Elija la opción a través de su número:
                1- Buscar libro por título
                2- Listar libros registrados
                3- Listar autores registrados
                4- Listar autores vivos en un determinado año
                5- Lista libros por idioma
                0- Salir""";
        boolean continuar = true;
        while (continuar) {
            System.out.println(menu);
            Scanner sc = new Scanner(System.in);
            try {
                int option = sc.nextInt();
                sc.nextLine();
                switch (option) {
                    case 1:
                        libroService.buscarLibro(sc);
                        break;
                    case 2:
                        libroService.listarLibros();
                        break;
                    case 3:
                        autorService.listarAutores();
                        break;
                    case 4:
                        System.out.println("Ingrese año");
                        int anio = sc.nextInt();
                        autorService.autorVivo(anio);
                        break;
                    case 0:
                        continuar = false;
                        break;
                    default:
                        System.out.println("Ingrese una opción válida");
                        break;

                }
            } catch (Exception err) {
                System.out.println("Error, " + err.getMessage());
            }

        }

    }

}
