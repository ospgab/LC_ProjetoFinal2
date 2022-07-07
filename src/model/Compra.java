package model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

// import generator.GeneratedValue;
// import generator.GenerationType;

public class Compra extends BaseModel<Long> {
    @PrimaryKey
    // @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long idCompra;
    private LocalDate dataCompra;
    private LocalTime horaCompra;
    private BigDecimal valorTotal;
    private List<Produto> produtos;

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

    @Override
    public String toString() {
        return "Compra [\n\tdataCompra=" + dataCompra + ",\n\thoraCompra=" + horaCompra + ",\n\tidCompra=" + idCompra
                + ",\n\tprodutos=" + produtos + ",\n\tvalorTotal=" + valorTotal + "]";
    }

    

}
