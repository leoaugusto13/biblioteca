package com.example.biblioteca.service;

import java.util.List;
import java.util.Optional;

import com.example.biblioteca.entity.Livro;

public interface LivroService {

    List<Livro> findAll();

    Optional<Livro> findById(Long id);

    Livro save(Livro livro);

    void deleteById(Long id);
}

