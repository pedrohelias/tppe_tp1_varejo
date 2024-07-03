import java.util.ArrayList;
import java.util.List;

public class Cartao {
    public static final List<Cartao> cartoes = new ArrayList<>();

    private final String numero;
    private final String titular;
    private final String validade;
    private final String cpfDono;

    public Cartao(String numero, String titular, String validade, String cpfDono) {
        this.numero = numero;
        this.titular = titular;
        this.validade = validade;
        this.cpfDono = cpfDono;
    }

    public String getNumero() {
        return numero;
    }

    public String getTitular() {
        return titular;
    }

    public String getValidade() {
        return validade;
    }

    public String getCpfDono() {
        return cpfDono;
    }

    @Override
    public String toString() {
        return "Cartao{" +
                "numero='" + numero + '\'' +
                ", titular='" + titular + '\'' +
                ", validade='" + validade + '\'' +
                ", cpfDono='" + cpfDono + '\'' +
                '}';
    }
}
