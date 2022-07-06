package model;

import java.math.BigDecimal;

public interface Funcionario {

    BigDecimal salarioBase = BigDecimal.valueOf(2000);


    BigDecimal getSalario();


}
