package model;

import java.time.LocalDate;


public class Cartao {

    private int numero;
    private int cvv;
    private LocalDate validade;

    public Cartao(int numero, int cvv, LocalDate validade) {
        this.numero = numero;
        this.cvv = cvv;
        this.validade = validade;
    }
}
