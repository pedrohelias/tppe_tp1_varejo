import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ClienteTest.class, ImpostoTest.class, ImpostoMunTest.class, ProdutoParamsTest.class, CompraCashbackTest.class,CompraFreteEspecialPrimeTest.class, CompraFreteProdutoSemDescontoTest.class, CompraValorTotalCompraTest.class, CompraElegibilidadeClienteTest.class})

public class AllTests {

}
