import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Compra {

    // TODO Adicionar Métodos

    protected Date data;
    protected Cliente cliente;
    protected ArrayList<Produto> produtoVendido;
    protected String metodoPagamento
    protected Frete freteProduto;
    protected Imposto impostoGeral

    public enum metodoEnumPagamento{
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

        if(Objects.equals(compra.metodoPagamento, "DINHEIRO")){
            double valorCashback = 0d;
            double x = 0d;
            for (int i = 0; i < compra.produtoVendido.size(); i++) {
                x += compra.produtoVendido.get(i).valorVenda;
            }
            return valorCashback = x * 0.03;

        } else if (Objects.equals(compra.metodoPagamento, "CARTAO") && compra.cliente.get().cartao.substring(0,4) == "429613") {
            double valorCashback = 0d;
            double x = 0d;
            for (int i = 0; i < compra.produtoVendido.size(); i++) {
                x += compra.produtoVendido.get(i).valorVenda;
            }
            return valorCashback = x * 0.05;
        }
        return 0;
    }

    public static  double valorTotalCompra(ArrayList<Produto> produto, Cliente clienteComprador, String metodoPagamento){
        double valorTotal = 0d;
        double valorFreteEspecial;

        if(clienteComprador.tipoCliente == "Especial"){
            double x = 0d;
            for (int i = 0; i < produto.size(); i++) {
                x += produto.get(i).valorVenda;
            }

            if(clienteComprador.get().cartao.substring(0,4) == "429613"){
                x = x * 0.90;
            }

            valorFreteEspecial = valorFrete(clienteComprador.regiao, clienteComprador.localidade) * 0.70;
            valorTotal = (x + valorFreteEspecial) * 0.90;

        }else {
            double x = 0d;
            for (int i = 0; i < produto.size(); i++) {
                x += produto.get(i).valorVenda;
            }
            valorFreteEspecial = valorFrete(clienteComprador.regiao, clienteComprador.localidade);
            valorTotal = x + valorFreteEspecial;
        }

        return valorTotal;
    }

    
    public static double valorFrete(String regiao, String localidade){
        double valorFreteEsperado = 0d;

        if(Objects.equals(regiao, "Distrito Federal")){
            if(Objects.equals(localidade, "Capital")){
                valorFreteEsperado = 5d;
            }else{
                valorFreteEsperado = -1d;
            }
        } else if (Objects.equals(regiao, "Centro-Oeste")) {
            if(Objects.equals(localidade, "Capital")){
                valorFreteEsperado = 10d;
            }else{
                valorFreteEsperado = 13d;
            }
        } else if (Objects.equals(regiao, "Nordeste")) {
            if(Objects.equals(localidade, "Capital")){
                valorFreteEsperado = 15d;
            }else{
                valorFreteEsperado = 18d;
            }
        } else if (Objects.equals(regiao, "Norte")) {
            if(Objects.equals(localidade, "Capital")){
                valorFreteEsperado = 20d;
            }else{
                valorFreteEsperado = 25d;
            }
        } else if (Objects.equals(regiao, "Sudeste")) {
            if(Objects.equals(localidade, "Capital")){
                valorFreteEsperado = 7d;
            }else{
                valorFreteEsperado = 10d;
            }
        } else if (Objects.equals(regiao, "Sul")) {
            if(Objects.equals(localidade, "Capital")){
                valorFreteEsperado = 10d;
            }else{
                valorFreteEsperado = 13d;
            }
        }
        return valorFreteEsperado;
    }
    
    public static double valorFreteProduto(ArrayList<Produto> produto, Cliente clienteComprador){
        double valorFreteDescontado = -1d;
        if(clienteComprador.tipoCliente == "Especial"){
            double valorFrete = valorFrete(clienteComprador.regiao, clienteComprador.localidade);
            valorFreteDescontado =  valorFrete * 0.70;
        }else if(clienteComprador.tipoCliente == "Prime") {
            valorFreteDescontado = 0d;
        }
        return valorFreteDescontado;
    }


    public static int clienteElegivelParaEspecial( Int cpf, ArrayList<Compra> compra, int mes){
            ArrayList<Clientes> clienteElegivel;

            List<Compra> compraFiltrada = compra.data.stream()
                    .filter(e -> e.getData().getMonthValue() == mes)
                    .collect(Collectors.toList());

            int comprasRealizadasMensais = compraFiltrada.size();
            for(Object x: compraFiltrada.toArray()){
                // TODO faz um hashmap no qual o cpf é a key e o valor guardado é o quanto foi gastado, atualizando o valor gasto dentro desse hashmap toda vez que esse valor for encontrado

            }

            // TODO: Após isso selecionar quais clientes são elegiveis e guardar na variavel acima.

            comprasRealizadasMensais = comprasRealizadasMensais - 1;
        return 0;
    }

}
