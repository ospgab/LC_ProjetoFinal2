package br.com.bb.letscode.projetofinal2.model;

public abstract class Pessoa {

    private String nome;
    private int senha;



    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getSenha() {
        return senha;
    }

    public void setSenha(int senha) {
        this.senha = senha;
    }
}
