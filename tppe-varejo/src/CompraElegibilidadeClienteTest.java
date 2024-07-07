import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.Month;
import java.util.*;

@RunWith(Parameterized.class)
public class CompraElegibilidadeClienteTest {

    public List<Compra> listaCompra;
    protected int ultimoMes;
    protected List<Cliente> valorEsperado;

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        List<Produto> produto1 = Arrays.asList(
                new Produto("1234abcd", "descrição teste tdd", 80.50, "m3"),
                new Produto("abcd1234", "descricao", 79.99, "ml"),
                new Produto("9874lkhj", "a", 100.90, "m3"),
                new Produto("agcr1284", "descrição teste tdd1", 1, "g")
        );
        List<Produto> produto2 = Arrays.asList(
                new Produto("1234abcd", "descrição teste tdd", 10.50, "m3"),
                new Produto("abcd1234", "descricao", 9.99, "ml"),
                new Produto("9874lkhj", "a", 0.90, "m3"),
                new Produto("agcr1284", "descrição teste tdd1", 1, "g")
        );

        Imposto imp1 = new Imposto(Cliente.Regiao.Sudeste.toString(), 262.39);

        Cliente cliente1 = new Cliente("João da Cunha", "039.992.690-90", Cliente.Regiao.Norte, true, Cliente.Tipo.ESPECIAL, 0.0, 0.0);
        Cliente cliente2 = new Cliente("Caio Cardoso", "567.541.880-65", Cliente.Regiao.Sudeste, false, Cliente.Tipo.ESPECIAL, 0.0, 0.0);
        Cliente cliente3 = new Cliente("João Silva", "123.456.789-00", Cliente.Regiao.Sudeste, true, Cliente.Tipo.PRIME, 0.0, 0.0);
        Cliente cliente4 = new Cliente("Maiara Silva", "478.385.280-46", Cliente.Regiao.Centro_Oeste, true, Cliente.Tipo.ESPECIAL, 0.0, 0.0);

        String data1 = "12/07/2024";
        String data2 = "15/07/2024";
        String data3 = "12/02/2024";
        String data4 = "12/02/2024";

        String metodoPagamento1 = "DINHEIRO";
        String metodoPagamento2 = "CARTAO";

        Compra comprador1 = new Compra(data1, cliente2, produto1, metodoPagamento1, imp1);
        Compra comprador2 = new Compra(data3,cliente4,produto2,metodoPagamento2,imp1);
        Compra comprador3 = new Compra(data4,cliente3,produto1,metodoPagamento1,imp1);
        Compra comprador4 = new Compra(data2,cliente1,produto1,metodoPagamento2,imp1);

        List<Compra> listaDummyCompra1 = new ArrayList<>();

        listaDummyCompra1.add(comprador1);
        listaDummyCompra1.add(comprador2);
        listaDummyCompra1.add(comprador4);

        List<Compra> listaDummyCompra2 = new ArrayList<>();

        listaDummyCompra2.add(comprador3);

        LocalDate dataAtual = LocalDate.now();
        Month mesAtual = dataAtual.getMonth();

        List<Cliente> listaDummyCliente1 = new ArrayList<>();
        listaDummyCliente1.add(new Cliente("567.541.880-65", 262.39, 7));
        listaDummyCliente1.add(new Cliente("039.992.690-90", 262.39, 7));

        List<Cliente> listaDummyCliente2 = new ArrayList<>();

        List<Cliente> listaDummyCliente3 = new ArrayList<>();
        listaDummyCliente3.add(new Cliente("123.456.789-00", 262.39, 7));

        return Arrays.asList(new Object[][] {
                {
                    listaDummyCompra1,
                    mesAtual.getValue(),
                    listaDummyCliente1
                },
                {
                    listaDummyCompra2,
                    mesAtual.getValue(),
                    listaDummyCliente2
                },
                {
                        listaDummyCompra2,
                        2,
                        listaDummyCliente3
                }
        });
    }

    public CompraElegibilidadeClienteTest(List<Compra> listaCompra, int ultimoMes,List<Cliente> valorEsperado) {
       this.listaCompra = listaCompra;
        this.ultimoMes = ultimoMes;
        this.valorEsperado = valorEsperado;
    }

    @Test
    public void testCalculoElegibilidadeClienteEspecial() throws ParseException {
        listaCompra = new ArrayList<>(listaCompra);
        assertEquals(valorEsperado.size(), Compra.clienteElegivelParaEspecial(listaCompra, ultimoMes).size());
    }


}