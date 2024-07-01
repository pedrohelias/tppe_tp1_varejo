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
}
