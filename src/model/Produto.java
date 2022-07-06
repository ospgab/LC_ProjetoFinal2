package model;

import java.math.BigDecimal;

public class Produto {

    private String nome;

    private Integer codigo;

    private BigDecimal preco;

    private BigDecimal desconto;

    private Integer quantidade;

    public Produto(String nome, Integer codigo, BigDecimal preco, BigDecimal desconto, Integer quantidade) {
        setNome(nome);
        setCodigo(codigo);
        setPreco(preco);
        setDesconto(desconto);
        setQuantidade(quantidade);
    }

    public Produto() {
        new Produto("", 0, new BigDecimal(0), new BigDecimal(0), 0);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }

    public BigDecimal getDesconto() {
        return desconto;
    }

    public void setDesconto(BigDecimal desconto) {
        this.desconto = desconto;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }
}
