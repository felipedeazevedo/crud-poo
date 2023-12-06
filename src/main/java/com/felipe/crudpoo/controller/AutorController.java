package com.felipe.crudpoo.controller;

import com.felipe.crudpoo.dto.AutorDTO;
import com.felipe.crudpoo.entity.Autor;
import com.felipe.crudpoo.service.AutorService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/autores")
public class AutorController {

    private final AutorService autorService;

    public AutorController(AutorService autorService) {
        this.autorService = autorService;
    }

    @GetMapping(path = "/{id}")
    public Autor findById(@PathVariable Integer id) {
        return autorService.findById(id);
    }

    @GetMapping()
    public List<Autor> findAll() {
        return autorService.findAll();
    }

    @PutMapping(path = "/{id}")
    public Autor update(@RequestBody AutorDTO autor) {
        return autorService.update(autor);
    }

    @PostMapping()
    public Autor create(@RequestBody AutorDTO autor) {
        return autorService.create(autor);
    }

    @DeleteMapping(path = "/{id}")
    public Boolean delete(@PathVariable Integer id) {
        return autorService.deleteAutor(id);
    }
}
