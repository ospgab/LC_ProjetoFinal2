package br.com.bb.letscode.projetofinal2.model;

import java.time.LocalDate;


public class Cartao extends BaseModel<Long> {

    private int numero;
    private int cvv;
    private LocalDate validade;

    public Cartao(int numero, int cvv, LocalDate validade) {
        this.numero = numero;
        this.cvv = cvv;
        this.validade = validade;
    }

    public int getNumero() {
        return numero;
    }

    public Cartao setNumero(int numero) {
        this.numero = numero;
        return this;
    }

    public int getCvv() {
        return cvv;
    }

    public Cartao setCvv(int cvv) {
        this.cvv = cvv;
        return this;
    }

    public LocalDate getValidade() {
        return validade;
    }

    public Cartao setValidade(LocalDate validade) {
        this.validade = validade;
        return this;
    }

    
}
