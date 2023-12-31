package ex03.entidades;

import ex03.enums.Cor;

public class Retangulo extends Forma {
    private Double largura;
    private Double altura;

    public Retangulo() {
    }

    public Retangulo(Cor cor, Double largura, Double altura) {
        super(cor);
        this.largura = largura;
        this.altura = altura;
    }

    @Override
    public double calcularArea() {
        return largura * altura;
    }
}
