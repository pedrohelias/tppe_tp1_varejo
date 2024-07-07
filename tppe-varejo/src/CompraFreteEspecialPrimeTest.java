import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import java.util.*;

@RunWith(Parameterized.class)
public class CompraFreteEspecialPrimeTest {

    protected Cliente cliente;
    protected double valorEsperado;

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
                {
                        new Cliente("João Silva",
                                "123.456.789-00",
                                Cliente.Regiao.Sudeste,
                                true,
                                Cliente.Tipo.PRIME,
                                0.0,
                                0.0
                        ),
                        0d
                },
                {
                        new Cliente("Caio Cardoso",
                                "567.541.880-65",
                                Cliente.Regiao.Sudeste,
                                true,
                                Cliente.Tipo.ESPECIAL,
                                0.0,
                                0.0
                        ),
                        4.9d
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
                        7d
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
                        14d
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
                        17.50d
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
                        7d
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
                        9.10d
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
                        7d
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
                        9.10d
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
                        10.50d
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
                        12.60d
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
                        3.5d
                }
        });
    }

    public CompraFreteEspecialPrimeTest(Cliente cliente, double valorEsperado) {
        this.cliente = cliente;
        this.valorEsperado = valorEsperado;
    }

    @Test
    public void testCalculoFreteClienteEspecial(){
        double valorComprado = Compra.valorFreteProduto(cliente);
        assertEquals(valorEsperado,valorComprado,0.1);
    }

}