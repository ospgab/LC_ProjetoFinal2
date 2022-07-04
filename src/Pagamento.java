import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;


public class Pagamento {

    private ArrayList<Cartao> carteira;
    SimpleDateFormat dateFormat = new SimpleDateFormat("MM-yy");

    public void cadastraCartao(int numero, int cvv, LocalDate validade){
        if(verificaCartao(numero, cvv, validade)){
            carteira.add(new Cartao(numero, cvv, validade));
        }

    }



    private boolean verificaCartao(int numero, int cvv, LocalDate validade){

        try{
            if(validade.isBefore(LocalDate.now())){
                throw new Exception("Data de validade já passou!");
            }
            else{
                return true;
            }
        } catch(Exception e){
            return false;
        }
    }

    public void getCartao(){
        for(Cartao cartao: carteira){

        }
    }


}
