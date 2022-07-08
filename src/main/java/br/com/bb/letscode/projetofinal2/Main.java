package br.com.bb.letscode.projetofinal2;

import br.com.bb.letscode.projetofinal2.model.*;
import br.com.bb.letscode.projetofinal2.repository.CompraInMemoryRepository;
import br.com.bb.letscode.projetofinal2.service.Carrinho;
import br.com.bb.letscode.projetofinal2.service.Configuracao;

import java.math.BigDecimal;
import java.util.ArrayList;

import java.time.LocalDate;
import java.time.LocalTime;

public class Main {

    private static CompraInMemoryRepository compraInMemoryRepository = CompraInMemoryRepository.getInstance();

    public static void main(String[] args) {
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

        Compra compra = new Compra()
                .setDataCompra(LocalDate.now()).setHoraCompra(LocalTime.now())
                .setProdutos(carrinho.getListaDeProdutos()).setValorTotal(BigDecimal.ZERO);

        compraInMemoryRepository.persist(compra);

        System.out.println(compraInMemoryRepository.getAll());
    }

    public static void testConfiguracao() {
        Configuracao configuracao = new Configuracao();

        String origemDados = configuracao.getOrigemDosDados();

        System.out.println("Origem dos dados: " + origemDados);
    }
}