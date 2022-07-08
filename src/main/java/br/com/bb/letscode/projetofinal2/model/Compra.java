package br.com.bb.letscode.projetofinal2.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

// import br.com.bb.letscode.projetofinal2.generator.GeneratedValue;
// import br.com.bb.letscode.projetofinal2.generator.GenerationType;

public class Compra extends BaseModel<Long> {
    @PrimaryKey
    // @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long idCompra;
    private Cliente<?> cliente;
    private Cartao cartao; // Meio de pagamento
    private LocalDate dataCompra;
    private LocalTime horaCompra;
    private BigDecimal valorTotal;
    private BigDecimal valorTotalAPagar;
    private BigDecimal valorDescontos;
    private BigDecimal valorTaxas;
    private List<Produto> produtos;

    public Cliente<?> getCliente() {
        return cliente;
    }

    public Compra setCliente(Cliente<?> cliente) {
        this.cliente = cliente;
        return this;
    }

    public LocalDate getDataCompra() {
        return dataCompra;
    }

    public Compra setDataCompra(LocalDate dataCompra) {
        this.dataCompra = dataCompra;
        return this;
    }

    public LocalTime getHoraCompra() {
        return horaCompra;
    }

    public Compra setHoraCompra(LocalTime horaCompra) {
        this.horaCompra = horaCompra;
        return this;
    }

    public BigDecimal getValorTotal() {
        return valorTotal;
    }

    public Compra setValorTotal(BigDecimal valorTotal) {
        this.valorTotal = valorTotal;
        return this;
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    public Compra setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
        return this;
    }

    public BigDecimal getValorDescontos() {
        return valorDescontos;
    }

    public Compra setValorDescontos(BigDecimal valorDescontos) {
        this.valorDescontos = valorDescontos;
        return this;
    }

    public BigDecimal getValorTaxas() {
        return valorTaxas;
    }

    public Compra setValorTaxas(BigDecimal valorTaxas) {
        this.valorTaxas = valorTaxas;
        return this;
    }

    public BigDecimal getValorTotalAPagar() {
        return valorTotalAPagar;
    }

    public Compra setValorTotalAPagar(BigDecimal valorTotalAPagar) {
        this.valorTotalAPagar = valorTotalAPagar;
        return this;
    }

    public Cartao getCartao() {
        return cartao;
    }

    public Compra setCartao(Cartao cartao) {
        this.cartao = cartao;
        return this;
    }

    @Override
    public String toString() {
        return "Compra [\n\tcartao=" + cartao + ",\n\tcliente=" + cliente + ",\n\tdataCompra=" + dataCompra + ",\n\thoraCompra="
                + horaCompra + ",\n\tidCompra=" + idCompra + ",\n\tprodutos=" + produtos + ",\n\tvalorDescontos="
                + valorDescontos + ",\n\tvalorTaxas=" + valorTaxas + ",\n\tvalorTotal=" + valorTotal + ",\n\tvalorTotalAPagar="
                + valorTotalAPagar + "]";
    }

   

}
