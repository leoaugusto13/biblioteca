package com.example.biblioteca.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.biblioteca.entity.Livro;
import com.example.biblioteca.repository.LivroRepository;

@Service
public class LivroServiceImpl implements LivroService {

     @Autowired
    private LivroRepository livroRepository;

    @Override
    public List<Livro> findAll() {
        return livroRepository.findAll();
    }

    @Override
    public Optional<Livro> findById(Long id) {
        return livroRepository.findById(id);
    }

    @Override
    public Livro save(Livro livro) {
        return livroRepository.save(livro);
    }

    @Override
    public void deleteById(Long id) {
        livroRepository.deleteById(id);
    }
    
}
