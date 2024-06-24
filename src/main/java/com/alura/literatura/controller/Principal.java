package com.alura.literatura.controller;

import com.alura.literatura.model.DatosLibro;
import com.alura.literatura.service.LibroService;

import java.util.Optional;
import java.util.Scanner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class Principal {

    @Autowired
    LibroService libroService;

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
                        System.out.println("Entre a la opcion 2");
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
