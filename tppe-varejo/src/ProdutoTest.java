import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class ProdutoTest {
    
    @Test
    public void tamanhoCodigoProduto(){ 
       String produto = "1234abcd";
       Boolean esperado = true;
       Boolean verificaCodigo = Produto.verificaCodigo(produto);
       assertEquals(esperado, verificaCodigo);

    }

    @Test
    public void tamanhoDescricao(){ 
       String produto = "descrição teste tdd"; //precisa ser menor que 20 caracteres
       Boolean esperado = true;
       Boolean verificaDescricao = Produto.verificaDescricao(produto);
       assertEquals(esperado, verificaDescricao);

    }

    @Test
    public void tamanhoDescricaoMinima(){ 
       String produto = "a"; //precisa ser menor que 20 caracteres
       Boolean esperado = true;
       Boolean verificaDescricao = Produto.verificaDescricao(produto);
       assertEquals(esperado, verificaDescricao);

    }

    @Test
    public void tamanhoDescricaoMaximo(){ 
       String produto = "descrição teste tdd1"; //precisa ser menor que 20 caracteres
       Boolean esperado = true;
       Boolean verificaDescricao = Produto.verificaDescricao(produto);
       assertEquals(esperado, verificaDescricao);

    }

    @Test
    public void testaValorVenda(){ 
       double produto = 100; //precisa ser maior que 0
       Boolean esperado = true;
       Boolean verificaDescricao = Produto.verificaValorVenda(produto);
       assertEquals(esperado, verificaDescricao);

    }

    @Test
    public void testaValorVendaMinimo(){ 
       double produto = 0.01; //precisa ser maior que 0
       Boolean esperado = true;
       Boolean verificaDescricao = Produto.verificaValorVenda(produto);
       assertEquals(esperado, verificaDescricao);

    }


    @Test
    public void testaUnidadeMedida(){
       String unidadeMedida = "cm"; 
       Boolean esperado = true;
       Boolean verificaDescricao = Produto.verificaUnMedida(unidadeMedida);
       assertEquals(esperado, verificaDescricao);
    }

    @Test
    public void testaUnidadeMedidaMinimo(){
       String unidadeMedida = "c"; 
       Boolean esperado = true;
       Boolean verificaDescricao = Produto.verificaUnMedida(unidadeMedida);
       assertEquals(esperado, verificaDescricao);
    }

    @Test
    public void testaUnidadeMedidaMaximo(){
       String unidadeMedida = "cm3"; 
       Boolean esperado = true;
       Boolean verificaDescricao = Produto.verificaUnMedida(unidadeMedida);
       assertEquals(esperado, verificaDescricao);
    }
}
