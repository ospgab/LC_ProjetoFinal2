package br.com.bb.letscode.projetofinal2.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import br.com.bb.letscode.projetofinal2.model.Compra;
import br.com.bb.letscode.projetofinal2.repository.CompraInMemoryRepository;
import br.com.bb.letscode.projetofinal2.strategy.CalcularAcrescimo;
import br.com.bb.letscode.projetofinal2.strategy.CalcularDesconto;
import br.com.bb.letscode.projetofinal2.validators.ValidarCompra;

public class CompraService {
    private static CompraService instance;
    private static CompraInMemoryRepository compraInMemoryRepository = CompraInMemoryRepository.getInstance();

    private List<ValidarCompra> compraValidators = new ArrayList<>();
    private List<CalcularDesconto> calcularDescontos = new ArrayList<>();
    private List<CalcularAcrescimo> calcularAcrescimos = new ArrayList<>();

    private CompraService() {
    }

    public static CompraService getInstance() {
        if (instance == null)
            instance = new CompraService();
        return instance;
    }

    public void salvarCompra(Compra compra) {

        for (ValidarCompra validarCompra : this.compraValidators) {
            validarCompra.valida(compra);
        }

        BigDecimal descontos = BigDecimal.ZERO;
        for (CalcularDesconto calcularDesconto : calcularDescontos) {
            descontos = descontos.add(calcularDesconto.calcular(compra));
        }

        BigDecimal acrescimos = BigDecimal.ZERO;
        for (CalcularAcrescimo calcularAcrescimo : calcularAcrescimos) {
            acrescimos = acrescimos.add(calcularAcrescimo.calcular(compra));
        }

        compra.setValorDescontos(descontos);
        compra.setValorTaxas(acrescimos);

        BigDecimal totalCompra = compra.getProdutos().stream().map(produto -> produto.getPreco())
                .reduce(BigDecimal.ZERO, BigDecimal::add);
        
        BigDecimal totalPagamento = totalCompra.subtract(descontos).add(acrescimos);

        compra.setValorTotal(totalCompra);
        compra.setValorTotalAPagar(totalPagamento);

        compraInMemoryRepository.persist(compra);
    }

    public void relatorioCompras() {
        System.out.println(compraInMemoryRepository.getAll());
    }

    // Strategy

    public CompraService setCompraValidators(List<ValidarCompra> compraValidators) {
        this.compraValidators = compraValidators;
        return this;
    }

    public CompraService setCalcularDescontos(List<CalcularDesconto> calcularDescontos) {
        this.calcularDescontos = calcularDescontos;
        return this;
    }

    public CompraService setCalcularAcrescimos(List<CalcularAcrescimo> calcularAcrescimos) {
        this.calcularAcrescimos = calcularAcrescimos;
        return this;
    }

}
