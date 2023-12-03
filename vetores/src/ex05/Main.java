package ex05;

import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);

        Scanner scan = new Scanner(System.in);

        System.out.print("Quantos números irá informar: ");
        int qtdNumeros = scan.nextInt();

        double[] vetor = new double[qtdNumeros];

        double maior = 0;
        int posicaoMaior = -1;

        for (int i = 0; i < vetor.length; i++) {
            System.out.print("Informe um número: ");
            vetor[i] = scan.nextDouble();

            if (vetor[i] > maior) {
                maior = vetor[i];
                posicaoMaior = i;
            }
        }

        System.out.print("\nMAIOR VALOR: " + maior);
        System.out.print("\nPOSIÇÃO DO MAIOR VALOR: " + posicaoMaior);

        scan.close();
    }
}
