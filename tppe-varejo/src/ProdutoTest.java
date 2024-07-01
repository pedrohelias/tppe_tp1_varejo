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
    public void testaValorVenda(){ 
       double produto = 100; //precisa ser menor que 20 caracteres
       Boolean esperado = true;
       Boolean verificaDescricao = Produto.verificaValorVenda(produto);
       assertEquals(esperado, verificaDescricao);

    }

    @Test
    public void testaUnidadeMedida(){
       String unidadeMedida = "cm"; //precisa ser menor que 20 caracteres
       Boolean esperado = true;
       Boolean verificaDescricao = Produto.verificaUnMedida(unidadeMedida);
       assertEquals(esperado, verificaDescricao);
    }
}
