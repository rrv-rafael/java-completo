package ex11.entidades;

public class Pessoa {
    private double altura;
    private char genero;

    public Pessoa(double altura, char genero) {
        this.altura = altura;
        this.genero = genero;
    }

    public double getAltura() {
        return altura;
    }
}
