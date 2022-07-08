package br.com.bb.letscode.projetofinal2.strategy;

import java.math.BigDecimal;
import java.math.RoundingMode;

import br.com.bb.letscode.projetofinal2.model.Compra;
import br.com.bb.letscode.projetofinal2.model.Produto;
import br.com.bb.letscode.projetofinal2.model.TipoProduto;

public class PromocaoTipoA implements CalcularDesconto {
    private final BigDecimal taxaDesconto = new BigDecimal(0.20);

    @Override
    public BigDecimal calcular(Compra compra) {
        BigDecimal desconto = BigDecimal.ZERO;

        for(Produto produto : compra.getProdutos()){
            if(produto.getTipoProduto() != TipoProduto.A) continue;
            
            BigDecimal valorDesconto = taxaDesconto.multiply(produto.getPreco());

            desconto = desconto.add(valorDesconto);
        }
        return desconto.setScale(2, RoundingMode.HALF_UP);
    }
    
}
