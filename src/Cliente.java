public class Cliente {

    private Pessoa cliente;
    private Endereco endereco;
    private Pagamento pagamento;


    public String getNome() {
        return cliente.getNome();
    }

    public String getEndereco() {
        return endereco.toString();
    }

}
