package ex03.entidades;

import ex03.enums.Cor;

public class Circulo extends Forma {
    private Double raio;

    public Circulo() {
    }

    public Circulo(Cor cor, Double raio) {
        super(cor);
        this.raio = raio;
    }

    @Override
    public double calcularArea() {
        return Math.PI * Math.pow(raio, 2);
    }
}
