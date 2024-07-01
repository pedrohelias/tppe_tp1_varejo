import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class ImpostoTest {

    //referencia
    //12% de ICMS e 4% de imposto municipal em vendas para clientes fora do DF;
    //18% de ICMS e 0% de imposto municipal em vendas para cliende do DF.
    

    @Test
    public void testICMSDentroDF(){
        String regiao = "DF";
        double valorCompra = 100;
        double obtido = Imposto.ICMS(regiao,valorCompra);
        assertEquals((valorCompra * 0.18) , obtido, .1);

    }

    @Test
    public void testICMSForaDF(){
        String regiao = "SUL";
        double valorCompra = 100;
        double obtido = Imposto.ICMS(regiao,valorCompra);
        assertEquals((valorCompra * 0.12) , obtido, .1);

    }


}
