package model;

public class Aula extends Conteudo {
    private int duracao; // duração em minutos

    public Aula(String titulo, int duracao) {
        super(titulo);
        this.duracao = duracao;
    }

    public int getDuracao() {
        return duracao;
    }

    public void setDuracao(int duracao) {
        this.duracao = duracao;
    }

    @Override
    public void exibir() {
        System.out.println("  Aula: " + titulo + " (" + duracao + " min)");
    }
}