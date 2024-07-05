import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Compra {

    // TODO Adicionar Métodos

    protected String data;
    protected Cliente cliente;
    protected List<Produto> produtoVendido;
    protected String metodoPagamento;
    protected Imposto impostoGeral;

    public Compra(String data, Cliente cliente, List<Produto> produtoVendido, String metodoPagamento, Imposto impostoGeral) {
        this.data = data;
        this.cliente = cliente;
        this.produtoVendido = produtoVendido;
        this.metodoPagamento = metodoPagamento;
        this.impostoGeral = impostoGeral;
    }

    public static double proverCashback(String metodoPagamento, List<Produto> produtoVendido, String numeroCartao, Cliente.Tipo tipo){
        String numeroCartaoEmpresa = "429613";
        String cartaoReduzido = numeroCartao.substring(0,6);
        double valorCashback = 0d;

        if (Objects.equals(tipo,Cliente.Tipo.PRIME)) {
            if (Objects.equals(metodoPagamento, "DINHEIRO") || Objects.equals(metodoPagamento, "CARTAO") && !cartaoReduzido.equals(numeroCartaoEmpresa)) {

                double x = 0d;
                for (Produto produto : produtoVendido) {
                    x += produto.valorVenda;
                }

                valorCashback = x * 0.03;

            } else if (Objects.equals(metodoPagamento, "CARTAO") && cartaoReduzido.equals(numeroCartaoEmpresa)) {
                double x = 0d;
                for (int i = 0; i < produtoVendido.size(); i++) {
                    x += produtoVendido.get(i).getValorVenda();
                }
                valorCashback = x * 0.05;
            }
        }
        return valorCashback;
    }

    public static  double valorTotalCompra(ArrayList<Produto> produto, Cliente clienteComprador, String metodoPagamento, String numeroCartao){
        double valorTotal = 0d;
        double valorFreteEspecial;

        double x = 0d;
        if(clienteComprador.getTipo() == Cliente.Tipo.ESPECIAL){
            for (Produto value : produto) {
                x += value.valorVenda;
            }

            String numeroCartaoEmpresa = "429613";
            String cartaoReduzido = numeroCartao.substring(0,6);
            if(cartaoReduzido.equals(numeroCartaoEmpresa)){
                x = x * 0.90;
            }

            valorFreteEspecial = valorFrete(clienteComprador.getEndereco(), clienteComprador.isCapital()) * 0.70;
            valorTotal = (x + valorFreteEspecial) * 0.90;

        }else {
            for (Produto value : produto) {
                x += value.valorVenda;
            }
            valorFreteEspecial = valorFrete(clienteComprador.getEndereco(), clienteComprador.isCapital());
            valorTotal = x + valorFreteEspecial;
        }

        return valorTotal;
    }
    
    public static double valorFrete(Cliente.Regiao regiao, boolean localidade){
        double valorFreteEsperado = 0d;

        if(Objects.equals(regiao, Cliente.Regiao.Distrito_Federal)){
            if(Objects.equals(localidade, true)){
                valorFreteEsperado = 5d;
            }else{
                valorFreteEsperado = -1d;
            }
        } else if (Objects.equals(regiao, Cliente.Regiao.Centro_Oeste)) {
            if(Objects.equals(localidade, true)){
                valorFreteEsperado = 10d;
            }else{
                valorFreteEsperado = 13d;
            }
        } else if (Objects.equals(regiao, Cliente.Regiao.Nordeste)) {
            if(Objects.equals(localidade, true)){
                valorFreteEsperado = 15d;
            }else{
                valorFreteEsperado = 18d;
            }
        } else if (Objects.equals(regiao, Cliente.Regiao.Norte)) {
            if(Objects.equals(localidade, true)){
                valorFreteEsperado = 20d;
            }else{
                valorFreteEsperado = 25d;
            }
        } else if (Objects.equals(regiao, Cliente.Regiao.Sudeste)) {
            if(Objects.equals(localidade, true)){
                valorFreteEsperado = 7d;
            }else{
                valorFreteEsperado = 10d;
            }
        } else if (Objects.equals(regiao, Cliente.Regiao.Sul)) {
            if(Objects.equals(localidade, true)){
                valorFreteEsperado = 10d;
            }else{
                valorFreteEsperado = 13d;
            }
        }
        return valorFreteEsperado;
    }
    
    public static double valorFreteProduto(Cliente clienteComprador){
        double valorFreteDescontado = -1d;
        if(clienteComprador.getTipo() == Cliente.Tipo.ESPECIAL){
            double valorFrete = valorFrete(clienteComprador.getEndereco(), clienteComprador.isCapital());
            valorFreteDescontado =  valorFrete * 0.70;
        }else if(clienteComprador.getTipo() == Cliente.Tipo.PRIME) {
            valorFreteDescontado = 0d;
        }
        return valorFreteDescontado;
    }

//    public static int clienteElegivelParaEspecial( Int cpf, ArrayList<Compra> compra, int mes){
//            ArrayList<Clientes> clienteElegivel;
//
//            List<Compra> compraFiltrada = compra.data.stream()
//                    .filter(e -> e.getData().getMonthValue() == mes)
//                    .collect(Collectors.toList());
//
//            int comprasRealizadasMensais = compraFiltrada.size();
//            for(Object x: compraFiltrada.toArray()){
//                // TODO faz um hashmap no qual o cpf é a key e o valor guardado é o quanto foi gastado, atualizando o valor gasto dentro desse hashmap toda vez que esse valor for encontrado
//
//            }
//
//            // TODO: Após isso selecionar quais clientes são elegiveis e guardar na variavel acima.
//
//            comprasRealizadasMensais = comprasRealizadasMensais - 1;
//        return 0;
//    }

}
