package model;

import service.Pagamento;

public class Cliente <T extends Pessoa>{

    private Pessoa cliente;
    private Endereco endereco;
    private Pagamento pagamento;


    public Cliente(Pessoa cliente, Endereco endereco) {
        this.cliente = cliente;
        this.endereco = endereco;
    }

    public String getNome() {
        return cliente.getNome();
    }

    public String getEndereco() {
        return endereco.toString();
    }

}
