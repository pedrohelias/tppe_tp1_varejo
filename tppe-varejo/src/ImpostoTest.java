

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
    private double valorEsperado;

    @Parameters
    public static Collection<Object[]> getParameters(){
        return Arrays.asList(new Object[][] {
                {"Distrito_Federal", 100, 18}, //dentro do DF
                {"Sul", 100, 12} //fora do DF
        });
    }

    public ImpostoTest(String regiao, double valorCompra, double valorEsperado){
        this.regiao = regiao;
        this.valorCompra = valorCompra;
        this.valorEsperado = valorEsperado;
    }

    @Test
    public void testICMS(){
        imp = new Imposto(regiao, valorCompra);
        assertEquals(valorEsperado, imp.ICMS(regiao, valorCompra), 0.1);
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

