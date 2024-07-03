import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Cliente {
    private static final Map<String, Cliente> clientes = new HashMap<>();

    public enum Tipo {
        PADRAO, ESPECIAL, PRIME
    }

    public enum Regiao {
        Distrito_Federal,
        Norte,
        Nordeste,
        Sul,
        Sudeste,
        Centro_Oeste,
    }

    private final String nome;
    private final String cpf;
    private final Regiao endereco;
    private final boolean capital;
    private final Tipo tipo;
    private final double cashback;
    private final double mensalidade;
    private final ArrayList<Cartao> cartoes;

    // Construtor
    public Cliente(String nome, String cpf, Regiao endereco, boolean capital, Tipo tipo, double cashback, double mensalidade) {
        this.nome = nome;
        this.cpf = cpf;
        this.endereco = endereco;
        this.capital = capital;
        this.tipo = tipo;
        this.cashback = cashback;
        this.mensalidade = mensalidade;
        this.cartoes = new ArrayList<>();
    }

    // Métodos de cliente
    public static boolean adicionarCliente(Cliente cliente) {
        if (clientes.containsKey(cliente.getCpf())) {
            return false;
        }
        clientes.put(cliente.getCpf(), cliente);
        return true;
    }

    public static boolean adicionarCartaoAoCliente(String cpf, Cartao cartao) {
        Cliente cliente = clientes.get(cpf);
        if (cliente == null) {
            System.out.println("Cliente com CPF " + cpf + " não encontrado.");
            return false;
        }
        // Adiciona o cartão à lista global de cartões
        if (cliente.adicionarCartao(cartao)) {
            cliente.cartoes.add(cartao);
            return true;
        } else {
            System.out.println("Não foi possível adicionar o cartão. O cartão já existe.\n");
            return false;
        }
    }

    public boolean adicionarCartao(Cartao cartao) {
        if (existeCartao(cartao.getNumero())) {
            System.out.println("Cartão com número " + cartao.getNumero() + " já existe.");
            return false;
        }
        cartoes.add(cartao);
        return true;
    }

    public boolean existeCartao(String numero) {
        for (Cartao c : cartoes) {
            if (c.getNumero().equals(numero)) {
                return true;
            }
        }
        return false;
    }

    public void listarCartoes() {
        if (cartoes.isEmpty()) {
            System.out.println("Nenhum cartão cadastrado.");
        } else {
            for (Cartao cartao : cartoes) {
                System.out.println("Número: " + cartao.getNumero() + ", Validade: " + cartao.getValidade());
            }
        }
    }

    public static void listarClientes() {
        for (Cliente cliente : clientes.values()) {
            System.out.println("Nome: " + cliente.getNome());
            System.out.println("CPF: " + cliente.getCpf());
            System.out.println("Região: " + cliente.getEndereco());
            System.out.println("Capital: " + cliente.isCapital());
            System.out.println("Tipo: " + cliente.getTipo());
            System.out.println("Cashback: " + cliente.getCashback());
            System.out.println("Cartões:");
            cliente.listarCartoes();
            System.out.println();
        }
    }

    public static void limparClientes() {
        clientes.clear();
    }

    // Métodos Getter e Setter
    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public Regiao getEndereco() {
        return endereco;
    }

    public boolean isCapital() {
        return capital;
    }

    public Tipo getTipo() {
        return tipo;
    }


    public double getCashback() {
        return cashback;
    }

    public double getMensalidade() {
        return mensalidade;
    }
}
