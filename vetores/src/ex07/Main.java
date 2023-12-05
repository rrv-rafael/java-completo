package ex07;

import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);

        Scanner scan = new Scanner(System.in);

        System.out.print("Qual será o tamanho do vetor: ");
        int tamanhoVetor = scan.nextInt();

        double[] vetor = new double[tamanhoVetor];
        double soma = 0;

        for (int i = 0; i < vetor.length; i++) {
            System.out.print("Informe um número: ");
            vetor[i] = scan.nextDouble();

            soma += vetor[i];
        }

        double media = soma / vetor.length;

        System.out.printf("\nMÉDIA DO VETOR %.3f\n", media);

        System.out.println("ELEMENTOS ABAIXO DA MÉDIA:");

        for (double numeros : vetor) {
            if (numeros < media) {
                System.out.println(numeros);
            }
        }

        scan.close();
    }
}
