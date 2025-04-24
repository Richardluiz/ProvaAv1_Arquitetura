package com.nome.nome.service;


import com.nome.nome.model.Curso;
import com.nome.nome.repository.CursoRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CursoService {

    @Autowired
    private CursoRepository cursoRepository;

    //  CREATE
    public Curso saveCurso(Curso curso) {
        return cursoRepository.save(curso);
    }

    //  READ ALL
    public List<Curso> getCursos() {
        return cursoRepository.findAll();
    }

    // READ BY ID
    public Curso getCursoById(Long id) {
        return cursoRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Curso não encontrado com ID: " + id));
    }

    // UPDATE
    public Curso atualizarCurso(Long id, Curso cursoAtualizado) {
        Curso curso = getCursoById(id);
        curso.setNome(cursoAtualizado.getNome());
        curso.setDescricao(cursoAtualizado.getDescricao());
        // Adicione outros atributos conforme necessário
        return cursoRepository.save(curso);
    }

    //  DELETE
    public void deleteCurso(Long id) {
        Curso curso = getCursoById(id);
        cursoRepository.delete(curso);
    }
}

