package model;

public abstract class Conteudo implements Exibivel {
    protected String titulo;

    public Conteudo(String titulo) {
        this.titulo = titulo;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public abstract void exibir();
}