import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import java.util.*;

@RunWith(Parameterized.class)
public class CompraFreteProdutoSemDescontoTest {

    protected Cliente cliente;
    protected double valorEsperado;

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
                {
                        new Cliente("Caio Cardoso",
                                "567.541.880-65",
                                Cliente.Regiao.Sudeste,
                                true,
                                Cliente.Tipo.ESPECIAL,
                                0.0,
                                0.0
                        ),
                        7d
                },
                {
                        new Cliente("Caio Cardoso",
                                "567.541.880-65",
                                Cliente.Regiao.Sudeste,
                                false,
                                Cliente.Tipo.ESPECIAL,
                                0.0,
                                0.0
                        ),
                        10d
                },
                {
                        new Cliente("João da Cunha",
                                "039.992.690-90",
                                Cliente.Regiao.Norte,
                                true,
                                Cliente.Tipo.ESPECIAL,
                                0.0,
                                0.0
                        ),
                        20d
                },
                {
                        new Cliente("João da Cunha",
                                "039.992.690-90",
                                Cliente.Regiao.Norte,
                                false,
                                Cliente.Tipo.ESPECIAL,
                                0.0,
                                0.0
                        ),
                        25d
                },
                {
                        new Cliente("Maiara Silva",
                                "478.385.280-46",
                                Cliente.Regiao.Centro_Oeste,
                                true,
                                Cliente.Tipo.ESPECIAL,
                                0.0,
                                0.0
                        ),
                        10d
                },
                {
                        new Cliente("Maiara Silva",
                                "478.385.280-46",
                                Cliente.Regiao.Centro_Oeste,
                                false,
                                Cliente.Tipo.ESPECIAL,
                                0.0,
                                0.0
                        ),
                        13d
                },
                {
                        new Cliente("Gabriel Bragança",
                                "723.840.460-55",
                                Cliente.Regiao.Sul,
                                true,
                                Cliente.Tipo.ESPECIAL,
                                0.0,
                                0.0
                        ),
                        10d
                },
                {
                        new Cliente("Gabriel Bragança",
                                "723.840.460-55",
                                Cliente.Regiao.Sul,
                                false,
                                Cliente.Tipo.ESPECIAL,
                                0.0,
                                0.0
                        ),
                        13d
                },
                {
                        new Cliente("Pedro Sampaio",
                                "505.314.460-50",
                                Cliente.Regiao.Nordeste,
                                true,
                                Cliente.Tipo.ESPECIAL,
                                0.0,
                                0.0
                        ),
                        15d
                },
                {
                        new Cliente("Pedro Sampaio",
                                "505.314.460-50",
                                Cliente.Regiao.Nordeste,
                                false,
                                Cliente.Tipo.ESPECIAL,
                                0.0,
                                0.0
                        ),
                        18d
                },
                {
                        new Cliente("Gabriel Castro",
                                "723.840.460-55",
                                Cliente.Regiao.Distrito_Federal,
                                true,
                                Cliente.Tipo.ESPECIAL,
                                0.0,
                                0.0
                        ),
                        5d
                }
        });
    }

    public CompraFreteProdutoSemDescontoTest(Cliente cliente, double valorEsperado) {
        this.cliente = cliente;
        this.valorEsperado = valorEsperado;
    }

    @Test
    public void testCalculoFreteproduto(){
        double valorComprado = Compra.valorFrete(cliente.getEndereco(), cliente.isCapital());
        assertEquals(valorEsperado,valorComprado,0.1);
    }
}