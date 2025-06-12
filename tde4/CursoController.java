package controller;

import model.*;

import java.util.ArrayList;
import java.util.List;

public class CursoController {
    private List<Curso> cursos;

    public CursoController() {
        cursos = new ArrayList<>();
    }

    public void cadastrarCurso(Curso curso) throws CampoObrigatorioException {
        if (curso.getTitulo() == null || curso.getTitulo().isEmpty()) {
            throw new CampoObrigatorioException("O título do curso é obrigatório.");
        }
        if (curso.getInstrutor() == null) {
            throw new CampoObrigatorioException("O instrutor do curso é obrigatório.");
        }
        cursos.add(curso);
    }

    public List<Curso> listarCursos() {
        return cursos;
    }

    public Curso buscarCursoPorNome(String nome) throws CursoNaoEncontradoException {
        for (Curso c : cursos) {
            if (c.getTitulo().equalsIgnoreCase(nome)) {
                return c;
            }
        }
        throw new CursoNaoEncontradoException("Curso não encontrado: " + nome);
    }

    public void removerCurso(String nome) throws CursoNaoEncontradoException {
        Curso curso = buscarCursoPorNome(nome);
        cursos.remove(curso);
    }
}