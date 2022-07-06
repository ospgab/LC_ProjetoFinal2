public class ClientePJ extends Pessoa{

    private String cnpj;

    public ClientePJ(String nome, int senha, String cnpj) {
        super(nome, senha);
        this.cnpj = cnpj;
    }
}
