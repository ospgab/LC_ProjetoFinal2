package br.com.bb.letscode.projetofinal2.validators;

import br.com.bb.letscode.projetofinal2.model.Cartao;
import br.com.bb.letscode.projetofinal2.model.Compra;
import br.com.bb.letscode.projetofinal2.service.PagamentoService;

public class ValidaCompraCartao implements ValidarCompra {

    private PagamentoService pagamentoService = PagamentoService.getInstance();

    @Override
    public void valida(Compra compra) {
        Cartao cartao = compra.getCartao();

        pagamentoService.verificaCartao(cartao);

    }

}
