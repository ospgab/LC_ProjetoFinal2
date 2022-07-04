public class ClietePJ extends Pessoa{

    private String cnpj;

    public ClietePJ(String nome, int senha, String cnpj) {
        super(nome, senha);
        this.cnpj = cnpj;
    }
}
