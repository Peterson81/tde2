package model;

import java.util.ArrayList;
import java.util.List;

public class Curso extends Conteudo {
    private List<Aula> aulas;
    private Instrutor instrutor;

    public Curso(String titulo, Instrutor instrutor) {
        super(titulo);
        this.instrutor = instrutor;
        this.aulas = new ArrayList<>();
    }

    public void adicionarAula(Aula aula) {
        aulas.add(aula);
    }

    public void removerAula(Aula aula) {
        aulas.remove(aula);
    }

    public List<Aula> getAulas() {
        return aulas;
    }

    public Instrutor getInstrutor() {
        return instrutor;
    }

    public void setInstrutor(Instrutor instrutor) {
        this.instrutor = instrutor;
    }

    @Override
    public void exibir() {
        System.out.println("Curso: " + titulo);
        System.out.println("Instrutor: " + instrutor.getNome());
        System.out.println("Aulas:");
        for (Aula aula : aulas) {
            aula.exibir();
        }
        System.out.println("------------------------");
    }
}