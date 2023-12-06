package com.felipe.crudpoo.service;

import com.felipe.crudpoo.dto.LivroDTO;
import com.felipe.crudpoo.entity.Autor;
import com.felipe.crudpoo.entity.Livro;
import com.felipe.crudpoo.repository.LivroRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;

@Service
public class LivroService {


    private final LivroRepository livroRepository;
    private final AutorService autorService;

    public LivroService(LivroRepository livroRepository, AutorService autorService) {
        this.livroRepository = livroRepository;
        this.autorService = autorService;
    }

    public Livro findById(Integer id) {
        return livroRepository.findById(id).orElse(null);
    }

    public List<Livro> findAll() {
        return livroRepository.findAll(Sort.by("nome"));
    }

    @Transactional
    public Livro create(LivroDTO livroDTO) {
        Autor autor = autorService.findById(livroDTO.getAutorId());
        if (!livroRepository.findAllByAutorAndNome(autor, livroDTO.getNome()).isEmpty()) {
            throw new RuntimeException("Esse autor já possui esse mesmo livro cadastrado");
        }
        if (Objects.isNull(autor)) {
            throw new RuntimeException("Esse autor ainda não foi cadastrado");
        }
        Livro livro = new Livro();
        livro.setNome(livroDTO.getNome());
        livro.setAutor(autor);
        livro.setEditora(livroDTO.getEditora());
        livro.setQtdPaginas(livroDTO.getQtdPaginas());
        livro.setGenero(livroDTO.getGenero());
        return livroRepository.save(livro);
    }

    @Transactional
    public Livro update(LivroDTO livroDTO) {
        if (!livroRepository.existsById(livroDTO.getId())) {
            throw new RuntimeException("Esse livro não existe");
        }
        Livro livro = new Livro();
        BeanUtils.copyProperties(livroDTO, livro);
        return livroRepository.save(livro);
    }

    public boolean deletelivro(Integer id) {
        if (livroRepository.existsById(id)) {
            livroRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
