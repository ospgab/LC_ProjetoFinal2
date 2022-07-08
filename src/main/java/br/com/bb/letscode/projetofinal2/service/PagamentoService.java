package br.com.bb.letscode.projetofinal2.service;

import java.text.SimpleDateFormat;
import java.time.LocalDate;

import br.com.bb.letscode.projetofinal2.exceptions.ClienteException;
import br.com.bb.letscode.projetofinal2.model.Cartao;

public class PagamentoService {

    private static PagamentoService instance;

    SimpleDateFormat dateFormat = new SimpleDateFormat("MM-yy");

    private PagamentoService() {
    }

    public static PagamentoService getInstance() {
        if (instance == null)
            instance = new PagamentoService();
        return instance;
    }

    public void verificaCartao(Cartao cartao) {
        if (cartao.getValidade().isBefore(LocalDate.now())) {
            throw new ClienteException("Data de validade já passou!");
        }
    }
}
