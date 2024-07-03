import java.util.ArrayList;

public class Frete {
    private String regiao;
    private Double localidade;

    public Frete(String regiao, Double localidade) {
        this.regiao = regiao;
        this.localidade = localidade;
    }

    public static double valorPorRegiao(String regiao, String localidade){

        return 0d;
    }

}
