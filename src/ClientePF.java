public class ClientePF extends Pessoa{

    private String cpf;

    public ClientePF(String nome, int senha, String cpf) {
        super(nome, senha);
        this.cpf = cpf;
    }
}
