package com.example.biblioteca;

import com.example.biblioteca.controller.LivroController;
import com.example.biblioteca.entity.Livro;
import com.example.biblioteca.service.LivroService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;


class LivroControllerTest {

    @InjectMocks
    private LivroController livroController;

    @Mock
    private LivroService livroService;

    private Livro livro;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
        livro = new Livro();
        livro.setId(1L);
        livro.setTitulo("Livro Teste");
        livro.setAutor("Autor Teste");
        
    }

    @Test
    void testGetLivroById() {
        when(livroService.findById(1L)).thenReturn(Optional.of(livro));

        ResponseEntity<Livro> response = livroController.getLivroById(1L);

        assertEquals(200, response.getStatusCode());
        assertEquals(livro, response.getBody());
        verify(livroService, times(1)).findById(1L);
    }

    @Test
    void testCreateLivro() {
        when(livroService.save(any(Livro.class))).thenReturn(livro);

        Livro novoLivro = new Livro();
        novoLivro.setTitulo("Novo Livro");
        novoLivro.setAutor("Novo Autor");
        

        Livro response = livroController.createLivro(novoLivro);

        assertEquals("Novo Livro", response.getTitulo());
        verify(livroService, times(1)).save(any(Livro.class));
    }
}