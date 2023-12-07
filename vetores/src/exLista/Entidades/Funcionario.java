package exLista.Entidades;

public class Funcionario {
    private final int id;
    private String nome;
    private double salario;

    public Funcionario(int id, String nome, double salario) {
        this.id = id;
        this.nome = nome;
        this.salario = salario;
    }

    public int getId() {
        return id;
    }

    public void aumentarSalario(double percentualAumentoSalarial) {
        salario += salario * (percentualAumentoSalarial / 100);
    }

    @Override
    public String toString() {
        return id + ", " + nome + ", " + String.format("%.2f", salario);
    }
}
