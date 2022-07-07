package model;

import service.Pagamento;

public class Cliente <T extends Pessoa>{

    private Pessoa cliente;
    private Endereco endereco;
    private Pagamento pagamento;

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

}
