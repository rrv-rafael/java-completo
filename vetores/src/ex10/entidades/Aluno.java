package ex10.entidades;

public class Aluno {
    private String nome;
    private double[] notas;

    public Aluno(String nome, double[] notas) {
        this.nome = nome;
        this.notas = notas;
    }

    public String getNome() {
        return nome;
    }

    public double calcularMedia() {
        double soma = 0;
        double media;

        for (double nota : notas) {
            soma += nota;
        }

        media = soma / notas.length;

        return media;
    }
}
