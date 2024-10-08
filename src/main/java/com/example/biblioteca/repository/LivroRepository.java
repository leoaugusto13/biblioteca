package com.example.biblioteca.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.biblioteca.entity.Livro;

public interface LivroRepository extends JpaRepository <Livro, Long>{
    
}
