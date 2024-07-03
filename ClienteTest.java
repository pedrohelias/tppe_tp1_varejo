import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class ClienteTest {

    private Cliente cliente;
    private final boolean expectedClienteResult;
    private final boolean expectedCartaoResult;
    private final String cpf;
    private final String nome;
    private final Cliente.Regiao regiao;
    private final boolean capital;
    private final Cliente.Tipo tipo;
    private final double cashback;
    private final double mensalidade;
    private final Cartao cartao;

    public ClienteTest(String nome, String cpf, Cliente.Regiao regiao, boolean capital, Cliente.Tipo tipo, double cashback, double mensalidade, Cartao cartao, boolean expectedClienteResult, boolean expectedCartaoResult) {
        this.nome = nome;
        this.cpf = cpf;
        this.regiao = regiao;
        this.capital = capital;
        this.tipo = tipo;
        this.cashback = cashback;
        this.mensalidade = mensalidade;
        this.cartao = cartao;
        this.expectedClienteResult = expectedClienteResult;
        this.expectedCartaoResult = expectedCartaoResult;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
                {"João Silva", "123.456.789-00", Cliente.Regiao.Sudeste, true, Cliente.Tipo.ESPECIAL, 0.0, 0.0, new Cartao("1111-2222-3333-4444", "Titular Teste", "12/24", "123.456.789-00"), true, true},
                {"Maria Oliveira", "987.654.321-00", Cliente.Regiao.Nordeste, false, Cliente.Tipo.PRIME, 0.0, 20.0, new Cartao("2222-2222-3333-4444", "Titular Teste", "01/24", "987.654.321-00"), true, true},
                {"Carlos Pereira", "111.222.333-44", Cliente.Regiao.Sul, false, Cliente.Tipo.PADRAO, 0.0, 0.0, new Cartao("3333-2222-3333-4444", "Titular Teste", "02/24", "111.222.333-44"), true, true},
                {"João Silva", "123.456.789-00", Cliente.Regiao.Sudeste, true, Cliente.Tipo.ESPECIAL, 0.0, 0.0, new Cartao("1111-2222-3333-4444", "Titular Teste", "12/24", "123.456.789-00"), true, true},
        });
    }

    @Before
    public void setup(){
        cliente.limparClientes();
    }

    @Test
    public void testAdicionarCliente() {
        cliente = new Cliente(nome, cpf, regiao, capital, tipo, cashback, mensalidade);
        boolean result = Cliente.adicionarCliente(cliente);
        assertEquals(expectedClienteResult, result);
    }


    @Test
    public void testAdicionarCartaoAoCliente() {
        cliente = new Cliente(nome, cpf, regiao, capital, tipo, cashback, mensalidade);
        Cliente.adicionarCliente(cliente);
        boolean result = Cliente.adicionarCartaoAoCliente(cpf, cartao);
        assertEquals(expectedCartaoResult, result);
    }

    @Test
    public void testAdicionarCartao(){
        cliente = new Cliente(nome, cpf, regiao, capital, tipo, cashback, mensalidade);
        Cliente.adicionarCliente(cliente);
        boolean result = cliente.adicionarCartao(cartao);
        assertEquals(expectedCartaoResult, result);

    }

    @Test
    public void testExisteCartao(){
        cliente = new Cliente(nome, cpf, regiao, capital, tipo, cashback, mensalidade);
        cliente.adicionarCartao(cartao);
        boolean result = cliente.existeCartao(cartao.getNumero());
        assertEquals(expectedCartaoResult, result);
    }
}
