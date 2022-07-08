package br.com.bb.letscode.projetofinal2.model;

import java.math.BigDecimal;

public class Produto {

    private String nome;

    private Integer codigo;

    private BigDecimal preco;

    private BigDecimal desconto;

    private Integer quantidade;

    private TipoProduto tipoProduto;

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

    public Produto setNome(String nome) {
        this.nome = nome;
        return this;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public Produto setCodigo(Integer codigo) {
        this.codigo = codigo;
        return this;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public Produto setPreco(BigDecimal preco) {
        this.preco = preco;
        return this;
    }

    public BigDecimal getDesconto() {
        return desconto;
    }

    public Produto setDesconto(BigDecimal desconto) {
        this.desconto = desconto;
        return this;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public Produto setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
        return this;
    }

    public TipoProduto getTipoProduto() {
        return tipoProduto;
    }

    public Produto setTipoProduto(TipoProduto tipoProduto) {
        this.tipoProduto = tipoProduto;
        return this;
    }

    @Override
    public String toString() {
        return "Produto [nome=" + nome + "]";
    }

}
