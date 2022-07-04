import java.math.BigDecimal;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        testCarrinho();
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
}