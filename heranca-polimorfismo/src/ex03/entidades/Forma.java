package ex03.entidades;

import ex03.enums.Cor;

public abstract class Forma {
    private Cor cor;

    public Forma() {
    }

    public Forma(Cor cor) {
        this.cor = cor;
    }

    public abstract double calcularArea();
}
