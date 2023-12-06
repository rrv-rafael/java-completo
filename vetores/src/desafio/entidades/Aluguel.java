package desafio.entidades;

public class Aluguel {
    private String nome;
    private String email;
    private int numeroQuarto;

    public Aluguel(String nome, String email, int numeroQuarto) {
        this.nome = nome;
        this.email = email;
        this.numeroQuarto = numeroQuarto;
    }

    public int getNumeroQuarto() {
        return numeroQuarto;
    }

    @Override
    public String toString() {
        return numeroQuarto + ": " + nome + ", " + email;
    }
}
