package br.com.bb.letscode.projetofinal2.model;

import br.com.bb.letscode.projetofinal2.service.Pagamento;

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

    @Override
    public String toString() {
        return "Cliente [cliente=" + cliente + "]";
    }

}
