

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;


@RunWith(Parameterized.class)
public class ImpostoMunTest {

    private Imposto imp;
    private String regiao;
    private double valorCompra;
    private double valorEsperado;

    @Parameters
    public static Collection<Object[]> getParameters(){
        return Arrays.asList(new Object[][] {
                {"DF", 100, 100}, //dentro do DF
                {"SUL", 100, 4} //fora do DF
        });
    }

    public ImpostoMunTest(String regiao, double valorCompra, double valorEsperado){
        this.regiao = regiao;
        this.valorCompra = valorCompra;
        this.valorEsperado = valorEsperado;
    }

    @Test 
    public void testMunicipal(){
        imp = new Imposto(regiao, valorCompra);
        assertEquals(valorEsperado, imp.ImpMunicipal(regiao, valorCompra), 0.1);

    }
}

    // @Test
    // public void testImpMunicipalDentroDF(){
    //     String regiao = "DF";
    //     double valorCompra = 100;
    //     double obtido = Imposto.ImpMunicipal(regiao,valorCompra);
    //     assertEquals((valorCompra) , obtido, .1);

    // }

    // @Test
    // public void testImpMunicipalForaDF(){
    //     String regiao = "NORDESTE";
    //     double valorCompra = 100;
    //     double obtido = Imposto.ImpMunicipal(regiao,valorCompra);
    //     assertEquals((valorCompra * 0.04) , obtido, .1);

    // }


