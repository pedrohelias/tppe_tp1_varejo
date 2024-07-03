import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.*;

@RunWith(Parameterized.class)
public class CompraTest {

    public Compra compra;
    protected Date data;
    protected Cliente cliente;
    protected ArrayList<Produto> produtoVendido;
    protected String metodoPagamento;
    protected Frete freteProduto;
    protected Imposto impostoGeral;
    protected double valorEsperado;

    // TODO Adicionar os parametrização aos testes

    // FIXME Adicionar exemplos parametros
    @Parameterized.Parameters
    public static Collection<Object[]> getParameters(){
        return Arrays.asList(new Object[][] {
                {},
                {},
                {}
        });
    }

   // TODO Adicionar os valores aos parâmetros
   public CompraTest(Date data, Cliente cliente, ArrayList<Produto> produtoVendido, String metodoPagamento, Frete freteProduto, Imposto impostoGeral, double valorEsperado) {
       this.data = data;
       this.cliente = cliente;
       this.produtoVendido = produtoVendido;
       this.metodoPagamento = metodoPagamento;
       this.freteProduto = freteProduto;
       this.impostoGeral = impostoGeral;
       this.valorEsperado = valorEsperado;
   }

    @Test
    public void testElegivelCashback() {
        compra = new Compra(data, cliente, produtoVendido, metodoPagamento, freteProduto, impostoGeral);
        assertEquals(compra.proverCashback(compra),valorEsperado);
    }

    @Test
    public void testCalculoFreteClienteEspecial(){
        compra = new Compra(data, cliente, produtoVendido, metodoPagamento, freteProduto, impostoGeral);
        double valorComprado = compra.valorFreteProduto(compra.produtoVendido, cliente);
        assertEquals(valorComprado,valorEsperado);
    }

    @Test
    public void testCalculoFreteClientePrime(){
        compra = new Compra(data, cliente, produtoVendido, metodoPagamento, freteProduto, impostoGeral);
        Double valorComprado = compra.valorFreteProduto(compra.produtoVendido, cliente);
        assertEquals(Double.of(valorComprado),valorEsperado);
    }

    @Test
    public void testCalculoElegibilidadeClienteEspecial(){
        compra = new Compra(data, cliente, produtoVendido, metodoPagamento, freteProduto, impostoGeral);
        assertEquals( compra.clienteElegivelParaEspecial(compra.cliente.numeroCpf, compra, compra.data.getMonth()), valorEsperado);
    }

}