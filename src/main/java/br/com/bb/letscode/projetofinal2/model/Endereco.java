package br.com.bb.letscode.projetofinal2.model;

public class Endereco {

    private String rua;
    private String lote;
    private String numero;
    private String tipoDoEndereco;
    private String bairro;
    private String cidade;
    private String estado;


    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getLote() {
        return lote;
    }

    public void setLote(String lote) {
        this.lote = lote;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getTipoDoEndereco() {
        return tipoDoEndereco;
    }

    public void setTipoDoEndereco(String tipoDoEndereco) {
        this.tipoDoEndereco = tipoDoEndereco;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }


}
