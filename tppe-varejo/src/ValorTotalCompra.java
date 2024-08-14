import java.util.List;
import java.util.Objects;

public class ValorTotalCompra {
    private List<Produto> produtos;
    private Cliente clienteComprador;
    private String metodoPagamento;
    private String numeroCartao;
    private Boolean usarCashback;

    public ValorTotalCompra(List<Produto> produtos, Cliente clienteComprador, String metodoPagamento, String numeroCartao, Boolean usarCashback) {
        this.produtos = produtos;
        this.clienteComprador = clienteComprador;
        this.metodoPagamento = metodoPagamento;
        this.numeroCartao = numeroCartao;
        this.usarCashback = usarCashback;
    }

    public double calcularTotalCompra() {
        double valorTotal = 0d;
        double valorFreteEspecial;
        double valorComprado = calculaSubTotalCompra(produtos);

        if (clienteComprador.getTipo() == Cliente.Tipo.ESPECIAL) {
            valorComprado = comparaCartaoEmpresa(metodoPagamento, numeroCartao, valorComprado);
            valorComprado = subTotalComImpostos(clienteComprador, valorComprado);
            valorFreteEspecial = valorFreteProduto(clienteComprador);
            valorTotal = (valorComprado + valorFreteEspecial) * 0.90;

        } else {
            valorComprado = subTotalComImpostos(clienteComprador, valorComprado);
            valorFreteEspecial = valorFreteProduto(clienteComprador);
            valorTotal = valorComprado + valorFreteEspecial;

            if (clienteComprador.getTipo() == Cliente.Tipo.PRIME) {
                valorTotal = verificaUsoCashBack(clienteComprador, usarCashback, valorTotal);
            }
        }
        return valorTotal;
    }

    private double verificaUsoCashBack(Cliente clienteComprador, Boolean usarCashback, double valorTotal) {
        if (Objects.equals(usarCashback, true)){
            double saldoCashback = clienteComprador.getCashback();
            valorTotal = valorTotal - saldoCashback;
        }
        return valorTotal;
    }

    private double subTotalComImpostos(Cliente clienteComprador, double valorComprado) {
        Imposto imp = new Imposto(clienteComprador.getEndereco().toString(), valorComprado,0, 0.04, 0.18, 0.12);
        valorComprado = valorComprado + imp.ICMS(imp.regiao, valorComprado)+ imp.ImpMunicipal(imp.regiao, valorComprado);
        return valorComprado;
    }

    private double comparaCartaoEmpresa(String metodoPagamento, String numeroCartao, double valorComprado) {
        String numeroCartaoEmpresa = "429613";
        String cartaoReduzido = numeroCartao.substring(0,6);
        if(cartaoReduzido.equals(numeroCartaoEmpresa) && Objects.equals(metodoPagamento, "CARTAO")){
            valorComprado = valorComprado * 0.90;
        }
        return valorComprado;
    }

    private double calculaSubTotalCompra(List<Produto> listaPedidos) {
        double valorComprado = 0.0d;
        for (Produto valor : listaPedidos) {
            valorComprado += valor.valorVenda;
        }
        return valorComprado;
    }

    public static double valorFreteProduto(Cliente clienteComprador){
        double valorFreteDescontado = -1d;
        if(clienteComprador.getTipo() == Cliente.Tipo.ESPECIAL){
            double valorFrete = Compra.valorFrete(clienteComprador.getEndereco(), clienteComprador.isCapital());
            valorFreteDescontado =  valorFrete * 0.70;
        }else if(clienteComprador.getTipo() == Cliente.Tipo.PRIME) {
            valorFreteDescontado = 0d;
        }else{
            valorFreteDescontado = Compra.valorFrete(clienteComprador.getEndereco(), clienteComprador.isCapital());
        }
        return valorFreteDescontado;
    }
}
