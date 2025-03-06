package com.crudcarros;

public class Modelo {
    private String nome;
    private Fabricante fabricante;
    private Cor cor;

    public Modelo(String nome, Fabricante fabricante, Cor cor) {
        this.nome = nome;
        this.fabricante = fabricante;
        this.cor = cor;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Fabricante getFabricante() {
        return fabricante;
    }

    public void setFabricante(Fabricante fabricante) {
        this.fabricante = fabricante;
    }

    public Cor getCor() {
        return cor;
    }

    public void setCor(Cor cor) {
        this.cor = cor;
    }

    @Override
    public String toString() {
        return "Modelo: " + nome + ", " + fabricante + ", " + cor;
    }
}
