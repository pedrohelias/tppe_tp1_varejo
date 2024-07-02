import static org.junit.Assert.*;
import org.junit.Test;

public class CompraTest {
    // TODO Adicionar os parametros aos testes

    @Test
    public void testCompraEmGeral(){
        Compra compra = dummyCompraModel;
        String numCartao = compra.cartao.substring(0,4);
        assertEquals(numCartao, "429613");
    }

    @Test
    public void testCalculoCashback(){
        Compra compra = dummyCompraModel;
        assertNotNull(compra.proverCashback(compra));
    }

    @Test
    public void testElegivelCashback() {
        Compra compra = dummyCompraModel;
        assertEquals(compra.proverCashback(compra, compra.cliente.tipoCliente), "Prime");
    }

    @Test
    public void testCalculoFreteClienteEspecial(){
        Compra compra = dummyCompraModel;
        Double valorComprado = compra.frete.valorPorRegiao("Centro-Oeste","Capital", "Especial");
        freteCompraEncontrado = compra.frete.valorPorRegiao(compra.cliente.endereco.regiao,compra.cliente.endereco.localidade, compra.cliente.tipo);
        assertEquals(valorComprado,freteCompraEncontrado);
        assertEquals("Especial", compra.cliente.tipo);
    }

    @Test
    public void testCalculoFreteClientePrime(){
        Compra compra = dummyCompraModel;
        freteCompraEncontrado = compra.frete.valorPorRegiao(compra.cliente.endereco.regiao,compra.cliente.endereco.localidade, compra.cliente.tipo);
        assertEquals(0d,freteCompraEncontrado);
    }

    @Test
    public void testCalculoElegibilidadeClienteEspecial(){
        Compra listaDummyCompra;
        Double numeroCpf = 45312200050;
        assertTrue( listaDummyCompra.clienteEspecificoElegivelParaEspecial(numeroCpf, listaDummyCompra) == true);
    }

}