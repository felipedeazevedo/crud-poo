package com.felipe.crudpoo.repository;

import com.felipe.crudpoo.entity.Autor;
import com.felipe.crudpoo.entity.Livro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LivroRepository extends JpaRepository<Livro, Integer> {
    List<Livro> findAllByAutorAndNome(Autor autor, String nome);
}
