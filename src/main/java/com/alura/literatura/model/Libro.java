package com.alura.literatura.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.Set;

@Entity
@Table(name="libros")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Libro {
    @Id
    private int id;
    private String title;
    private int download_count;
    private String languages;
    @ManyToMany(mappedBy = "libros", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Autor> autores;


    @Override
    public String toString() {
        return "\n" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", languages=" + languages +
                ", download_count=" + download_count +
                ", autores=" + autores;
    }
}
