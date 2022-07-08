package br.com.bb.letscode.projetofinal2.validators;

import br.com.bb.letscode.projetofinal2.exceptions.ClienteException;
import br.com.bb.letscode.projetofinal2.model.Cliente;
import br.com.bb.letscode.projetofinal2.model.Compra;

public class ValidaCompraCliente implements ValidarCompra {

    @Override
    public void valida(Compra compra) {
        Cliente<?> cliente = compra.getCliente();

        if(cliente == null) throw new ClienteException("Cliente não encontrado");
        if(cliente.getNome() == null) throw new ClienteException("Nome do cliente inválido");
        if(cliente.getEndereco() == null) throw new ClienteException("Endereço do cliente inválido");
    }
    
}
