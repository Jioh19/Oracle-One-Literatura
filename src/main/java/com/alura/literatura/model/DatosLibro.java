package com.alura.literatura.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DatosLibro(
    @JsonAlias("id") int id,
    @JsonAlias("title") String title,
    @JsonAlias("authors") List<DatosAutor> authors,
    @JsonAlias("download_count") int download_count) {
}

