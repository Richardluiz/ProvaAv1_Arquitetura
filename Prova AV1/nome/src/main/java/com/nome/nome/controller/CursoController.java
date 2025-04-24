package com.nome.nome.controller;

import com.nome.nome.model.Curso; // Certifique-se de importar o modelo correto
import com.nome.nome.service.CursoService; // Certifique-se de importar o serviço correto
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/cursos")
public class CursoController {

    @Autowired
    private CursoService cursoService;

    // Criar um novo curso
    @PostMapping
    public ResponseEntity<Curso> createCurso(@RequestBody Curso curso) {
        Curso novoCurso = cursoService.saveCurso(curso);
        return new ResponseEntity<>(novoCurso, HttpStatus.CREATED);
    }

    // Buscar todos os cursos
    @GetMapping
    public ResponseEntity<List<Curso>> getAllCursos() {
        List<Curso> cursos = cursoService.getCursos();
        return new ResponseEntity<>(cursos, HttpStatus.OK);
    }

    // Buscar um curso por ID
    @GetMapping("/{id}")
    public ResponseEntity<Curso> getCursoById(@PathVariable Long id) {
        Optional<Curso> curso = cursoService.getCursoById(id);
        if (curso.isPresent()) {
            return new ResponseEntity<>(curso.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Atualizar um curso
    @PutMapping("/{id}")
    public ResponseEntity<Curso> updateCurso(@PathVariable Long id, @RequestBody Curso curso) {
        Optional<Curso> cursoExistente = cursoService.getCursoById(id);
        if (cursoExistente.isPresent()) {
            curso.setId(id);
            Curso cursoAtualizado = cursoService.saveCurso(curso);
            return new ResponseEntity<>(cursoAtualizado, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Deletar um curso por ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCurso(@PathVariable Long id) {
        Optional<Curso> cursoExistente = cursoService.getCursoById(id);
        if (cursoExistente.isPresent()) {
            cursoService.deleteCurso(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
