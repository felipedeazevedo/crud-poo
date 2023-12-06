package com.felipe.crudpoo.controller;

import com.felipe.crudpoo.dto.LivroDTO;
import com.felipe.crudpoo.entity.Livro;
import com.felipe.crudpoo.service.LivroService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/livros")
public class LivroController {

    private final LivroService livroService;

    public LivroController(LivroService livroService) {
        this.livroService = livroService;
    }

    @GetMapping(path = "/{id}")
    public Livro findById(@PathVariable Integer id) {
        return livroService.findById(id);
    }

    @GetMapping()
    public List<Livro> findAll() {
        return livroService.findAll();
    }

    @PutMapping(path = "/{id}")
    public Livro update(@RequestBody LivroDTO livro) {
        return livroService.update(livro);
    }

    @PostMapping()
    public Livro create(@RequestBody LivroDTO livro) {
        return livroService.create(livro);
    }

    @DeleteMapping(path = "/{id}")
    public Boolean delete(@PathVariable Integer id) {
        return livroService.deletelivro(id);
    }
}
