package br.com.bb.letscode.projetofinal2.strategy;

import java.math.BigDecimal;

import br.com.bb.letscode.projetofinal2.model.Compra;

public interface CalcularAcrescimo {
    BigDecimal calcular(Compra compra);
}
