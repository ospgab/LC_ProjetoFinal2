package br.com.bb.letscode.projetofinal2.model;

import java.math.BigDecimal;

public class Operador extends Empregados implements Funcionario{

    private String login;
    private Endereco endereco;



    @Override
    public BigDecimal getSalario() {
        return salarioBase.add(BigDecimal.valueOf(750));
    }




}
