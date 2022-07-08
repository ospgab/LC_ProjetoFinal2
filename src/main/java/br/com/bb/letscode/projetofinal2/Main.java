package br.com.bb.letscode.projetofinal2;

import br.com.bb.letscode.projetofinal2.model.*;
import br.com.bb.letscode.projetofinal2.service.Carrinho;
import br.com.bb.letscode.projetofinal2.service.CompraService;
import br.com.bb.letscode.projetofinal2.service.Configuracao;
import br.com.bb.letscode.projetofinal2.strategy.FreteTipoA;
import br.com.bb.letscode.projetofinal2.strategy.PromocaoTipoA;
import br.com.bb.letscode.projetofinal2.validators.ValidaCompraCliente;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.time.LocalDate;
import java.time.LocalTime;

public class Main {

    private static CompraService compraService = CompraService.getInstance();

    public static void main(String[] args) {
        initCompraService();

        Pessoa p1 = new PessoaFisica();
        p1.setNome("Maria antonieta");
        p1.setSenha(123456);
        Endereco end = new Endereco();
        end.setBairro("Asa Norte");
        end.setCidade("Brasília");
        end.setEstado("DF");
        end.setTipoDoEndereco("Apartamento");
        end.setRua("L2");
        end.setLote("15");
        end.setNumero("5");
        Cartao cartao = new Cartao(400465252, 352, LocalDate.now());
        Cliente novo = new Cliente();
        novo.setCliente(p1);
        novo.setEndereco(end);

        System.out.println(novo.getNome());

        testCarrinho();
        testCompraRepository();
        testConfiguracao();
    }

    public static void initCompraService() {
        compraService
                .setCalcularAcrescimos(
                        List.of(new FreteTipoA()))
                .setCalcularDescontos(
                        List.of(new PromocaoTipoA()))
                .setCompraValidators(
                        List.of(new ValidaCompraCliente()));
    }

    public static void testCarrinho() {
        Produto produto = new Produto();
        produto.setCodigo(1389);
        produto.setNome("Produto 1");
        produto.setPreco(BigDecimal.valueOf(100));

        Produto produto2 = new Produto();
        produto2.setCodigo(238);
        produto2.setNome("Produto 2");
        produto2.setPreco(BigDecimal.valueOf(80));

        Carrinho carrinho = new Carrinho(new ArrayList<>(), new BigDecimal(0), new Cliente());
        carrinho.add(produto, 3);
        carrinho.add(produto2, 1);

        carrinho.listar();
        System.out.println("Total: " + carrinho.getTotalCompra());

    }

    public static void testCompraRepository() {
        Cliente<PessoaFisica> cliente = getClienteMock();

        Produto produto = new Produto()
                .setCodigo(1389)
                .setNome("Produto 1")
                .setPreco(BigDecimal.valueOf(100))
                .setTipoProduto(TipoProduto.A);

        Produto produto2 = new Produto()
                .setCodigo(238)
                .setNome("Produto 2")
                .setPreco(BigDecimal.valueOf(80));

        Carrinho carrinho = new Carrinho(new ArrayList<>(), new BigDecimal(0), cliente);
        carrinho.add(produto, 3);
        carrinho.add(produto2, 1);

        Compra compra = new Compra()
                .setCliente(cliente)
                .setDataCompra(LocalDate.now()).setHoraCompra(LocalTime.now())
                .setProdutos(carrinho.getListaDeProdutos());

        compraService.salvarCompra(compra);

        compraService.relatorioCompras();
    }

    public static void testConfiguracao() {
        Configuracao configuracao = new Configuracao();

        String origemDados = configuracao.getOrigemDosDados();

        System.out.println("Origem dos dados: " + origemDados);
    }

    private static Cliente<PessoaFisica> getClienteMock(){
        Pessoa p1 = new PessoaFisica();
        p1.setNome("Maria antonieta");
        p1.setSenha(123456);
        Endereco end = new Endereco();
        end.setBairro("Asa Norte");
        end.setCidade("Brasília");
        end.setEstado("DF");
        end.setTipoDoEndereco("Apartamento");
        end.setRua("L2");
        end.setLote("15");
        end.setNumero("5");
        Cartao cartao = new Cartao(400465252, 352, LocalDate.now());
        Cliente<PessoaFisica> novo = new Cliente<PessoaFisica>();
        novo.setCliente(p1);
        novo.setEndereco(end);

        return novo;
    }
}