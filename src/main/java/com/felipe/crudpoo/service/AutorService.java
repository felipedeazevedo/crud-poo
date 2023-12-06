package com.felipe.crudpoo.service;

import com.felipe.crudpoo.dto.AutorDTO;
import com.felipe.crudpoo.entity.Autor;
import com.felipe.crudpoo.repository.AutorRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AutorService {


    private final AutorRepository autorRepository;

    public AutorService(AutorRepository autorRepository) {
        this.autorRepository = autorRepository;
    }

    public Autor findById(Integer id) {
        return autorRepository.findById(id).orElse(null);
    }

    public List<Autor> findAll() {
        return autorRepository.findAll(Sort.by("nome"));
    }

    @Transactional
    public Autor create(AutorDTO autorDTO) {
        Autor autor = new Autor();
        BeanUtils.copyProperties(autorDTO, autor);
        return autorRepository.save(autor);
    }

    @Transactional
    public Autor update(AutorDTO autorDTO) {
        Autor autor = new Autor();
        BeanUtils.copyProperties(autorDTO, autor);
        return autorRepository.save(autor);
    }

    public boolean deleteAutor(Integer id) {
        if (autorRepository.existsById(id)) {
            autorRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
