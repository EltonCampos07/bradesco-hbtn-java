import java.text.NumberFormat;
import java.util.Locale;

public class Pessoa implements Comparable<Pessoa> {
    private int codigo;
    private String nome;
    private String cargo;
    private int idade;
    private double salario;

    public Pessoa(int codigo, String nome, String cargo, int idade, double salario) {
        this.codigo = codigo;
        this.nome = nome;
        this.cargo = cargo;
        this.idade = idade;
        this.salario = salario;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getNome() {
        return nome;
    }

    public String getCargo() {
        return cargo;
    }

    public int getIdade() {
        return idade;
    }

    public double getSalario() {
        return salario;
    }

    @Override
    public String toString() {
        NumberFormat formatter = NumberFormat.getCurrencyInstance(Locale.forLanguageTag("pt-BR"));
        formatter.setMinimumFractionDigits(6);
        formatter.setMaximumFractionDigits(6);
        return String.format("[%d] %s %s %d %s",
                codigo, nome, cargo, idade, formatter.format(salario));
    }

    @Override
    public int compareTo(Pessoa other) {
        return this.nome.compareTo(other.nome);
    }
}
