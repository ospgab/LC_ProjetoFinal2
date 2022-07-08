package br.com.bb.letscode.projetofinal2.model;

public class PessoaJuridica extends Pessoa{

    private String cnpj;

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    @Override
    public String getDocumento() {
        return this.cnpj;
    }

    @Override
    public void setDocumento(String numero) {

    }
}
