package ex03.app;

import ex03.model.entidades.Circulo;
import ex03.model.entidades.FormaAbstrata;
import ex03.model.entidades.Retangulo;
import ex03.model.enums.Cor;

public class Application {
    public static void main(String[] args) {
        FormaAbstrata circulo = new Circulo(Cor.BLACK, 2.0);
        FormaAbstrata retangulo = new Retangulo(Cor.WHITE, 3.0, 4.0);

        System.out.println("Cor do círculo: " + circulo.getCor());
        System.out.printf("Área do círculo: %.3f", circulo.area());
        System.out.println("\nCor do retângulo: " + retangulo.getCor());
        System.out.printf("Área do retângulo: %.3f", retangulo.area());
    }
}
