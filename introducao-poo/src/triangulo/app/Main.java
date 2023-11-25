package triangulo.app;

import triangulo.entidades.Triangulo;

import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner scan = new Scanner(System.in);

        Triangulo trianguloX = new Triangulo();
        Triangulo trianguloY = new Triangulo();

        System.out.println("Entre com os lados do triângulo X: ");
        trianguloX.setLado1(scan.nextDouble());
        trianguloX.setLado2(scan.nextDouble());
        trianguloX.setLado3(scan.nextDouble());

        System.out.println("Entre com os lados do triângulo Y:");
        trianguloY.setLado1(scan.nextDouble());
        trianguloY.setLado2(scan.nextDouble());
        trianguloY.setLado3(scan.nextDouble());

        trianguloX.calcularArea();
        trianguloY.calcularArea();

        System.out.printf("Área do triângulo X: %.4f\n", trianguloX.getArea());
        System.out.printf("Área do triângulo Y: %.4f\n", trianguloY.getArea());

        if (trianguloX.getArea() > trianguloY.getArea()) {
            System.out.println("Maior área: X");
        } else {
            System.out.println("Maior área: Y");
        }
    }
}