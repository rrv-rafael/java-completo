package ex02;

import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner scan = new Scanner(System.in);

        System.out.print("Quantos números deseja informar? ");
        int qtdNumeros = scan.nextInt();

        double[] vetor = new double[qtdNumeros];
        double soma = 0;

        for (int i = 0; i < vetor.length; i++) {
            System.out.print("Informe um número: ");
            vetor[i] = scan.nextInt();
            soma += vetor[i];
        }

        System.out.print("\nVALORES: ");
        for (double numeros : vetor) {
            System.out.print(numeros + " ");
        }

        double media = soma / vetor.length;

        System.out.printf("\nSOMA: %.2f", soma);
        System.out.printf("\nMÉDIA: %.2f", media);

        scan.close();
    }
}
