package ex03.app;

import ex03.entidades.Circulo;
import ex03.entidades.Forma;
import ex03.entidades.Retangulo;
import ex03.enums.Cor;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);

        Scanner scan = new Scanner(System.in);

        List<Forma> formas = new ArrayList<>();

        System.out.print("Informe o número de formas: ");
        int qtdFormas = scan.nextInt();

        for (int i = 0; i < qtdFormas; i++) {
            System.out.printf("Dados da forma #%d:\n", i + 1);
            System.out.print("Retângulo ou circulo (r/c)? ");
            char tipoForma = scan.next().charAt(0);
            System.out.print("Cor (BLACK/BLUE/RED): ");
            Cor cor = Cor.valueOf(scan.next());

            if (tipoForma == 'r' || tipoForma == 'R') {
                System.out.print("Largura: ");
                double largura = scan.nextDouble();
                System.out.print("Altura: ");
                double altura = scan.nextDouble();

                formas.add(new Retangulo(cor, largura, altura));
            } else {
                System.out.print("Raio: ");
                double raio = scan.nextDouble();

                formas.add(new Circulo(cor, raio));
            }

        }

        System.out.println("\nÁREAS DAS FORMAS:");

        for (Forma f : formas) {
            System.out.printf("%.2f%n", f.calcularArea());
        }

        scan.close();
    }
}
