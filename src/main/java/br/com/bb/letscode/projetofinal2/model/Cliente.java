package br.com.bb.letscode.projetofinal2.model;

import java.util.List;

public class Cliente<T extends Pessoa> {

    private Pessoa cliente;
    private Endereco endereco;
    private List<Cartao> cartoes;

    public void setCliente(Pessoa cliente) {
        this.cliente = cliente;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public String getNome() {
        return cliente.getNome();
    }

    public String getEndereco() {
        return endereco.toString();
    }

    public List<Cartao> getCartoes() {
        return cartoes;
    }

    public void setCartoes(List<Cartao> cartoes) {
        this.cartoes = cartoes;
    }

    @Override
    public String toString() {
        return "Cliente [cliente=" + cliente + "]";
    }

}
