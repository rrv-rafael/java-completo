package ex11.app;

import ex11.entidades.Pessoa;

import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);

        Scanner scan = new Scanner(System.in);

        System.out.print("Quantas pessoas serão informadas: ");
        int qtdPessoas = scan.nextInt();

        Pessoa[] pessoa = new Pessoa[qtdPessoas];

        double soma = 0;
        int qtdHomens = 0;

        for (int i = 0; i < pessoa.length; i++) {
            System.out.printf("Altura da %da pessoa: ", i + 1);
            double altura = scan.nextDouble();
            System.out.printf("Genero da %da pessoa: ", i + 1);
            char genero = scan.next().charAt(0);

            pessoa[i] = new Pessoa(altura, genero);

            if (genero == 'F' || genero == 'f') {
                soma += altura;
            } else {
                qtdHomens++;
            }
        }

        double maiorAltura = pessoa[0].getAltura();
        double menorAltura = pessoa[0].getAltura();

        for (Pessoa p : pessoa) {
            if (p.getAltura() > maiorAltura) {
                maiorAltura = p.getAltura();
            }

            if (p.getAltura() < menorAltura) {
                menorAltura = p.getAltura();
            }
        }

        double media = soma / (pessoa.length - qtdHomens);

        System.out.printf("Menor altura: %.2f\n", menorAltura);
        System.out.printf("Maior altura: %.2f\n", maiorAltura);
        System.out.printf("Média das alturas das mulhres: %.2f\n", media);
        System.out.println("Número de homens: " + qtdHomens);
    }
}
