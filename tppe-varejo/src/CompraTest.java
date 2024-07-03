import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@RunWith(Parameterized.class)
public class CompraTest {

    public Compra compra;
    protected String data;
    protected Cliente cliente;
    protected ArrayList<Cartao> cartao;
    protected ArrayList<Produto> produtoVendido;
    protected String metodoPagamento;
    protected Imposto impostoGeral;
    protected int cartaoEscolhido;
    protected double valorEsperado;
//    static SimpleDateFormat formatoData = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

    // TODO Adicionar os parametrização aos testes

    // FIXME Adicionar exemplos parametros
    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
                {
                    "14/10/2024 15:33:00",
                    new Cliente("João Silva",
                            "123.456.789-00",
                            Cliente.Regiao.Sudeste,
                            true,
                            Cliente.Tipo.ESPECIAL,
                            0.0,
                            0.0
                    ),
                    Arrays.asList(new Object[][]{
                            {new Cartao("1111-2222-3333-4444", "Titular Teste", "12/24", "123.456.789-00")},
                            {new Cartao("2222-3333-4444-5555", "Outro Titular", "06/23", "987.654.321-00")},
                    }),
                    Arrays.asList(new Object[][]{
                            {new Produto("1234abcd", "descrição teste tdd",80.50,"m3")},
                            {new Produto("abcd1234", "descricao", 79.99, "ml")},
                            {new Produto("9874lkhj", "a",100.90,"m3")},
                            {new Produto("agcr1284", "descrição teste tdd1", 1, "g")},
                    }),
                    "CARTAO",
                    new Imposto("Distrito_Federal", 100),
                    1,
                    100d
                }
        });
    }

   // TODO Adicionar os valores aos parâmetros
   public CompraTest(String data, Cliente cliente, ArrayList<Cartao> cartao, ArrayList<Produto> produtoVendido, String metodoPagamento, Imposto impostoGeral, int cartaoEscollhido, double valorEsperado) {
       this.data = data;
       this.cliente = cliente;
       this.cartao = cartao;
       this.produtoVendido = produtoVendido;
       this.metodoPagamento = metodoPagamento;
       this.impostoGeral = impostoGeral;
       this.cartaoEscolhido = cartaoEscollhido;
       this.valorEsperado = valorEsperado;
   }

    @Test
    public void testElegivelCashback() {
        compra = new Compra(data, cliente, produtoVendido, metodoPagamento, impostoGeral);
        assertEquals(compra.proverCashback(compra, cliente.cartoes.get(cartaoEscolhido).getNumero()),valorEsperado, 0.1);
    }

//    @Test
//    public void testCalculoFreteClienteEspecial(){
//        compra = new Compra(data, cliente, produtoVendido, metodoPagamento, freteProduto, impostoGeral);
//        double valorComprado = compra.valorFreteProduto(compra.produtoVendido, cliente);
//        assertEquals(valorComprado,valorEsperado);
//    }

//    @Test
//    public void testCalculoFreteClientePrime(){
//        compra = new Compra(data, cliente, produtoVendido, metodoPagamento, freteProduto, impostoGeral);
//        Double valorComprado = compra.valorFreteProduto(compra.produtoVendido, cliente);
//        assertEquals(Double.of(valorComprado),valorEsperado);
//    }

//    @Test
//    public void testCalculoElegibilidadeClienteEspecial(){
//        compra = new Compra(data, cliente, produtoVendido, metodoPagamento, freteProduto, impostoGeral);
//        assertEquals( compra.clienteElegivelParaEspecial(compra.cliente.getCpf(), compra, compra.data.getMonth()), valorEsperado);
//    }

}