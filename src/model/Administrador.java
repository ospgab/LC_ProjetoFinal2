package model;

import java.math.BigDecimal;

public class Administrador extends Empregados implements Funcionario{

    private String login;
    private Endereco endereco;
    //Adicionar salario aqui




    @Override
    public BigDecimal getSalario() {
        return salarioBase.add(BigDecimal.valueOf(1500));
    }
}
