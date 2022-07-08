package br.com.bb.letscode.projetofinal2.model;

public class PessoaFisica extends Pessoa{

    private String cpf;



    @Override
    public String getDocumento() {
        return this.cpf;
    }

    @Override
    public void setDocumento(String numero) {
        this.cpf = numero;
    }
}
