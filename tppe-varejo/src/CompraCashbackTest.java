import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import java.util.*;

@RunWith(Parameterized.class)
public class CompraCashbackTest {

    public Compra compra;
    protected String data;
    protected Cliente cliente;
    protected Cartao cartao;
    protected List<Produto> produtoVendido;
    protected String metodoPagamento;
    protected Imposto impostoGeral;
    protected double valorEsperado;

     //TODO Adicionar os parametrização aos testes

    // FIXME Adicionar exemplos parametros
    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        List<Produto> produtos = Arrays.asList(
                new Produto("1234abcd", "descrição teste tdd", 80.50, "m3"),
                new Produto("abcd1234", "descricao", 79.99, "ml"),
                new Produto("9874lkhj", "a", 100.90, "m3"),
                new Produto("agcr1284", "descrição teste tdd1", 1, "g")
        );

        Cartao cartaoUsuario1 = new Cartao("1111222233334444", "Titular Teste", "12/24", "123.456.789-00");
        Cartao cartaoUsuario2 = new Cartao("4296132233334444", "Titular Teste", "12/24", "123.456.789-00");


        return Arrays.asList(new Object[][] {
                {
                    "14/10/2024 15:33:00",
                    new Cliente("João Silva",
                            "123.456.789-00",
                            Cliente.Regiao.Sudeste,
                            true,
                            Cliente.Tipo.PRIME,
                            0.0,
                            0.0
                    ),
                    cartaoUsuario1,
                    produtos,
                    "CARTAO",
                    new Imposto("Distrito_Federal", 100),
                    7.84
                },
                {
                        "14/10/2024 15:33:00",
                        new Cliente("João Silva",
                                "123.456.789-00",
                                Cliente.Regiao.Sudeste,
                                true,
                                Cliente.Tipo.PRIME,
                                0.0,
                                0.0
                        ),
                        cartaoUsuario2,
                        produtos,
                        "CARTAO",
                        new Imposto("Distrito_Federal", 100),
                        13.06
                },
                {
                        "14/10/2024 15:33:00",
                        new Cliente("João Silva",
                                "123.456.789-00",
                                Cliente.Regiao.Sudeste,
                                true,
                                Cliente.Tipo.PRIME,
                                0.0,
                                0.0
                        ),
                        cartaoUsuario2,
                        produtos,
                        "DINHEIRO",
                        new Imposto("Distrito_Federal", 100),
                        7.84
                },
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
                        cartaoUsuario2,
                        produtos,
                        "DINHEIRO",
                        new Imposto("Distrito_Federal", 100),
                        0
                }
        });
    }

   // TODO Adicionar os valores aos parâmetros
   public CompraCashbackTest(String data, Cliente cliente, Cartao cartao, List<Produto> produtoVendido, String metodoPagamento, Imposto impostoGeral, double valorEsperado) {
       this.data = data;
       this.cliente = cliente;
       this.cartao = cartao;
       this.produtoVendido = produtoVendido;
       this.metodoPagamento = metodoPagamento;
       this.impostoGeral = impostoGeral;
       this.valorEsperado = valorEsperado;
   }

    @Test
    public void testElegivelCashback() {
        compra = new Compra(data, cliente,produtoVendido,metodoPagamento,impostoGeral);
        assertEquals(Compra.proverCashback(compra.metodoPagamento, compra.produtoVendido,cartao.getNumero(), compra.cliente.getTipo()),valorEsperado, 0.2);
    }

//    TODO Criar teste parametrizado para Valores de Frete com Desconto (Para cliente prime e especial)
//    @Test
//    public void testCalculoFreteClienteEspecial(){
//        compra = new Compra(data, cliente, produtoVendido, metodoPagamento, freteProduto, impostoGeral);
//        double valorComprado = compra.valorFreteProduto(compra.produtoVendido, cliente);
//        assertEquals(valorComprado,valorEsperado);
//    }

//    TODO Criar teste parametrizado para Valores de Frete sem Desconto no método especifico
//    @Test
//    public void testCalculoElegibilidadeClienteEspecial(){
//        compra = new Compra(data, cliente, produtoVendido, metodoPagamento, freteProduto, impostoGeral);
//        assertEquals( compra.valorTotalCompra(), valorEsperado);
//    }

//    TODO Criar teste parametrizado para Elegibilidade de Cliente para se tornar Especial
//    @Test
//    public void testCalculoElegibilidadeClienteEspecial(){
//        compra = new Compra(data, cliente, produtoVendido, metodoPagamento, freteProduto, impostoGeral);
//        assertEquals( compra.clienteElegivelParaEspecial(compra.cliente.getCpf(), compra, compra.data.getMonth()), valorEsperado);
//    }

//    TODO Criar teste parametrizado para Valor Total da Compra(Sem impostos)
//    @Test
//    public void testCalculoElegibilidadeClienteEspecial(){
//        compra = new Compra(data, cliente, produtoVendido, metodoPagamento, freteProduto, impostoGeral);
//        assertEquals( compra.valorTotalCompra(), valorEsperado);
//    }

//    TODO Criar teste parametrizado para Valor Total da Compra(Com impostos para Nota Fiscal)
/*    @Test
//    public void testCalculoElegibilidadeClienteEspecial(){
//        compra = new Compra(data, cliente, produtoVendido, metodoPagamento, freteProduto, impostoGeral);
//        assertEquals( compra.valorTotalCompra(), valorEsperado);
    } */


}