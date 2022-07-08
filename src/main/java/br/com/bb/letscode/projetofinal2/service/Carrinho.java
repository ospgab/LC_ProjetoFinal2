package br.com.bb.letscode.projetofinal2.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import br.com.bb.letscode.projetofinal2.model.Cliente;
import br.com.bb.letscode.projetofinal2.model.Produto;

public class Carrinho {

    private List<Produto> listaDeProdutos;

    private BigDecimal totalCompra;

    private BigDecimal frete;

    private Cliente client;

    public Carrinho(List<Produto> listaDeProdutos, BigDecimal frete, Cliente client) {
        setListaDeProdutos(listaDeProdutos);
        setFrete(frete);
        setClient(client);

        this.totalCompra = new BigDecimal(0);
    }

    public Carrinho() {
        new Carrinho(new ArrayList<>(), new BigDecimal(0), new Cliente());
    }

    public boolean add(Produto produto, int quantidade) {
        try {
            produto.setQuantidade(quantidade);
            this.listaDeProdutos.add(produto);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean remover(Produto produto, int quantidade) {
        Integer produtoIndex = this.listaDeProdutos.indexOf(produto);

        if (produtoIndex >= 0) {
            this.listaDeProdutos.remove(listaDeProdutos.get(produtoIndex));
            return true;
        } else return false;
    }

    public boolean alterar(Produto produto, int quantidade) {
        Integer produtoIndex = this.listaDeProdutos.indexOf(produto);

        if (produtoIndex >= 0) {
            this.listaDeProdutos.get(produtoIndex).setQuantidade(quantidade);
            return true;
        } else return false;
    }

    public void listar() {
        System.out.println("Produtos no carrinho:");
        for (int i = 0; i < listaDeProdutos.size(); i++) {
            StringBuilder strBuilder = new StringBuilder();
            strBuilder.append("\t |\t Código: ");
            strBuilder.append(this.listaDeProdutos.get(i).getCodigo());
            strBuilder.append("\t Nome: ");
            strBuilder.append(this.listaDeProdutos.get(i).getNome());
            strBuilder.append("\t Quantidade: ");
            strBuilder.append(this.listaDeProdutos.get(i).getQuantidade());
            strBuilder.append("\t Preço: ");
            strBuilder.append(this.listaDeProdutos.get(i).getPreco());
            strBuilder.append("\t|");

            System.out.println(strBuilder.toString());
        }
    }

    public List<Produto> getListaDeProdutos() {
        return this.listaDeProdutos;
    }

    public void setListaDeProdutos(List<Produto> listaDeProdutos) {
        this.listaDeProdutos = listaDeProdutos;
    }

    public BigDecimal getTotalCompra() {
        BigDecimal total = new BigDecimal(0);

        for (Produto produto: this.listaDeProdutos) {
            int prodQuantidade = produto.getQuantidade();

            BigDecimal precoComDesconto = produto.getPreco(); //.subtract(produto.getDesconto());
            BigDecimal precoComQuantidade = precoComDesconto.multiply(BigDecimal.valueOf(prodQuantidade));

            total = total.add(precoComQuantidade);
        }

        return total;
    }

    public BigDecimal getFrete() {
        return this.frete;
    }

    public void setFrete(BigDecimal frete) {
        this.frete = frete;
    }

    public Cliente getClient() {
        return this.client;
    }

    public void setClient(Cliente client) {
        this.client = client;
    }
}
