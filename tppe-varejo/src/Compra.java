import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Compra {

    protected String data;
    protected Cliente cliente;
    protected List<Produto> produtoVendido;
    protected String metodoPagamento;
    protected Imposto impostoGeral;

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<Produto> getProdutoVendido() {
        return produtoVendido;
    }

    public void setProdutoVendido(List<Produto> produtoVendido) {
        this.produtoVendido = produtoVendido;
    }

    public String getMetodoPagamento() {
        return metodoPagamento;
    }

    public void setMetodoPagamento(String metodoPagamento) {
        this.metodoPagamento = metodoPagamento;
    }

    public Imposto getImpostoGeral() {
        return impostoGeral;
    }

    public void setImpostoGeral(Imposto impostoGeral) {
        this.impostoGeral = impostoGeral;
    }

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
        double valorComprado = calculaSubTotalCompra(produtoVendido);

        if (Objects.equals(tipo,Cliente.Tipo.PRIME)) {
            if (Objects.equals(metodoPagamento, "DINHEIRO") || Objects.equals(metodoPagamento, "CARTAO") && !cartaoReduzido.equals(numeroCartaoEmpresa)) {

                valorCashback = valorComprado * 0.03;

            } else if (Objects.equals(metodoPagamento, "CARTAO") && cartaoReduzido.equals(numeroCartaoEmpresa)) {

                valorCashback = valorComprado * 0.05;
            }
        }
        return valorCashback;
    }

    public static double valorTotalCompra(List<Produto> produtos, Cliente clienteComprador, String metodoPagamento, String numeroCartao, Boolean usarCashback) {
        ValorTotalCompra calculadora = new ValorTotalCompra(produtos, clienteComprador, metodoPagamento, numeroCartao, usarCashback);
        return calculadora.calcularTotalCompra();
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

    public static List<Cliente> clienteElegivelParaEspecial( List<Compra> listaCompra, int mesAlvo) throws ParseException {
        List<Cliente> listaClienteElegiveis = new ArrayList<>();

        for(Compra pedidoVendido: listaCompra){
            int mes = extrairMesAlvo(pedidoVendido);
            if(Objects.equals(mes,mesAlvo)){
                double valorComprado = calculaSubTotalCompra(pedidoVendido.produtoVendido);
                verificaClienteValorElegibilidade(pedidoVendido, valorComprado, listaClienteElegiveis, mes);
            }
        }

        return listaClienteElegiveis;
    }

    private static void verificaClienteValorElegibilidade(Compra pedidoVendido, double valorComprado, List<Cliente> listaClienteElegiveis, int mes) {
        if (valorComprado > 100d){
            listaClienteElegiveis.add(new Cliente(pedidoVendido.cliente.getCpf(), valorComprado, mes));
        }
    }

    private static int extrairMesAlvo(Compra pedidoVendido) throws ParseException {
        SimpleDateFormat formatoData = formataData();
        Date dataCompleta = formatoData.parse(pedidoVendido.data);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(dataCompleta);
        int mes = calendar.get(Calendar.MONTH) + 1;
        return mes;
    }

    private static SimpleDateFormat formataData() {
        return new SimpleDateFormat("dd/MM/yyyy");
    }

    protected static double calculaSubTotalCompra(List<Produto> listaPedidos) {
        double valorComprado = 0.0d;
        for (Produto valor : listaPedidos) {
            valorComprado += valor.valorVenda;
        }
        return valorComprado;
    }

}
