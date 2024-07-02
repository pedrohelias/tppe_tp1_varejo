import java.util.ArrayList;
import java.util.Date;


public class Compra {

    // TODO Adicionar Métodos

    protected Date data;
    protected Cliente cliente;
    protected ArrayList<Produto> produtoVendido;
    protected String metodoPagamento
    protected Frete freteProduto;
    protected Imposto impostoGeral

    public enum metodoPagamento{
        CARTAO, DINHEIRO
    }

    public Compra(Date data, Cliente cliente, ArrayList<Produto> produtoVendido, String metodoPagamento, Frete freteProduto, Imposto impostoGeral) {
        this.data = data;
        this.cliente = cliente;
        this.produtoVendido = produtoVendido;
        this.metodoPagamento = metodoPagamento;
        this.freteProduto = freteProduto;
        this.impostoGeral = impostoGeral;
    }

    public static double proverCashback(Compra compra){


        return 0d;
    }

    public static double proverCashback(Compra compra, Cliente cliente.tipoCliente){


        return 0d;
    }

    public static  double valorFreteEspecial(ArrayList<Produto> produto, Cliente clienteComprador){
        return 0d;
    }

    public static double valorFretePrime(ArrayList<Produto> produto, Cliente clienteComprador){
        return 0d;
    }

    public static int clienteElegivelParaEspecial( Int cpf, Compra compra){

        return 0;
    }

}
