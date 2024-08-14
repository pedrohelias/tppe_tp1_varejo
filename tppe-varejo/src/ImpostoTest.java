import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class ImpostoTest {

    private Imposto imp;
    private String regiao;
    private double valorCompra;
    private double valorEsperadoICMS;
    private double valorEsperadoImpMun;

    @Parameters
    public static Collection<Object[]> getParameters(){
        return Arrays.asList(new Object[][] {
            // Regiao, ValorCompra, ValorEsperadoICMS, ValorEsperadoImpMun
            {"Distrito_Federal", 100, 18 , 0}, // dentro DF - mun é 0
            {"Sul", 100, 12, 4} // fora do DF 
        });
    }

    public ImpostoTest(String regiao, double valorCompra, double valorEsperadoICMS, double valorEsperadoImpMun) {
        this.regiao = regiao;
        this.valorCompra = valorCompra;
        this.valorEsperadoICMS = valorEsperadoICMS;
        this.valorEsperadoImpMun = valorEsperadoImpMun;
        this.imp = new Imposto(regiao, valorCompra, 0, 0.04, 0.18, 0.12); // Inicializando Imposto
    }

    @Test
    public void testICMS(){
        double resultadoICMS = imp.ICMS(regiao, valorCompra);
        assertEquals(valorEsperadoICMS, resultadoICMS, 0.1);
    }

    @Test
    public void testImpMunicipal(){
        double resultadoImpMun = imp.ImpMunicipal(regiao, valorCompra);
        assertEquals(valorEsperadoImpMun, resultadoImpMun, 0.1);
    }

    @Test
    public void testValorTotalImpostos() {
        double resultadoTotal = imp.valorTotalImpostos(regiao, valorCompra);
        double valorTotalEsperado = valorEsperadoICMS + valorEsperadoImpMun;
        assertEquals(valorTotalEsperado, resultadoTotal, 0.1);
    }
}


    // @Test
    // public void testICMSDentroDF(){
    //     String regiao = "DF";
    //     double valorCompra = 100;
    //     double obtido = Imposto.ICMS(regiao,valorCompra);
    //     assertEquals((valorCompra * 0.18) , obtido, .1);

    // }

    // @Test
    // public void testICMSForaDF(){
    //     String regiao = "SUL";
    //     double valorCompra = 100;
    //     double obtido = Imposto.ICMS(regiao,valorCompra);
    //     assertEquals((valorCompra * 0.12) , obtido, .1);

    // }

