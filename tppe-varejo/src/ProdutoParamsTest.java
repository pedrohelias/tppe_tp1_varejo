import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;


@RunWith(Parameterized.class)
public class ProdutoParamsTest {

    private Produto prod;
    private String codigoProduto;
    private String descricaoProduto;
    private double valorVenda;
    private String unidadeMedida;
    private Boolean valorEsperado;


    @Parameters
    public static Collection<Object[]> getParameters(){
        return Arrays.asList(new Object[][] {
                {"1234abcd", "descrição teste tdd",80.50,"m3",true},
                {"abcd1234", "descricao", 79.99, "ml", true }, //teste descrição
                {"9874lkhj", "a",100.90,"m3",true}, //teste descrição minima
                {"agcr1284", "descrição teste tdd1", 1, "g", true }, //testeDescricao maxima
                {"1434abc9", "des",45.90,"kg",true}, //teste valor maior que zero, normal
                {"ab6d1284", "descriteste", 0.01, "m3", true }, //teste 0.01 para verificar os limites minimos do valor 
                {"12j4abyd", "descri",100,"c",true}, //teste de unidade de medida minima
                {"afcdljhl", "descricao teste", 1, "cm3", true }//teste unidade de medida maxima
                
        });
    }


    public ProdutoParamsTest(String codigoProduto, String descricaoProduto, double valorVenda, String unidadeMedida, Boolean valorEsperado){
        this.codigoProduto = codigoProduto;
        this.descricaoProduto = descricaoProduto;
        this.valorVenda = valorVenda;
        this.unidadeMedida = unidadeMedida;
        this.valorEsperado = valorEsperado;
        
    }

    // @Test 
    // public void testMunicipal(){
    //     imp = new Imposto(regiao, valorCompra);
    //     assertEquals(valorEsperado, imp.ImpMunicipal(regiao, valorCompra), 0.1);

    // }

    @Test
    public void tamanhoCodigoProduto(){
        prod = new Produto(codigoProduto, descricaoProduto, valorVenda, unidadeMedida); 
        assertEquals(valorEsperado,prod.verificaCodigo(codigoProduto));

    }

    @Test
    public void tamanhoDescricao(){
        prod = new Produto(codigoProduto, descricaoProduto, valorVenda, unidadeMedida);
        assertEquals(valorEsperado,prod.verificaDescricao(descricaoProduto));

    }

    @Test
    public void tamanhoValorVenda(){
        prod = new Produto(codigoProduto, descricaoProduto, valorVenda, unidadeMedida);
        assertEquals(valorEsperado,prod.verificaValorVenda(valorVenda));

    }

    @Test
    public void testUnidadeMedia(){
        prod = new Produto(codigoProduto, descricaoProduto, valorVenda, unidadeMedida);
        assertEquals(valorEsperado,prod.verificaUnMedida(unidadeMedida));

    }

    



}




