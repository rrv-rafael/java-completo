package ex03.model.entidades;

import ex03.model.enums.Cor;

public class Circulo extends Forma {
    private Double raio;

    public Circulo(Cor cor, Double raio) {
        super(cor);
        this.raio = raio;
    }

    public Double getRaio() {
        return raio;
    }

    public void setRaio(Double raio) {
        this.raio = raio;
    }

    @Override
    public double area() {
        return 0;
    }
}
