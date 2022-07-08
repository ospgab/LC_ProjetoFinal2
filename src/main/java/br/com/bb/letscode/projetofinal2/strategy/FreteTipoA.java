package br.com.bb.letscode.projetofinal2.strategy;

import java.math.BigDecimal;
import java.math.RoundingMode;

import br.com.bb.letscode.projetofinal2.model.Compra;
import br.com.bb.letscode.projetofinal2.model.Produto;
import br.com.bb.letscode.projetofinal2.model.TipoProduto;

public class FreteTipoA implements CalcularAcrescimo {
    private final BigDecimal taxaFrete = new BigDecimal(0.10);

    @Override
    public BigDecimal calcular(Compra compra) {
        BigDecimal acrescimo = BigDecimal.ZERO;

        for(Produto produto : compra.getProdutos()){
            if(produto.getTipoProduto() != TipoProduto.A) continue;
            
            BigDecimal valorAcrescimo = taxaFrete.multiply(produto.getPreco());

            acrescimo = acrescimo.add(valorAcrescimo);
        }
        return acrescimo.setScale(2, RoundingMode.HALF_UP);
    }
    
}
