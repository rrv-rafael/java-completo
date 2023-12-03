package ex04;

import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.print("Quantos números serão informados: ");
        int qtdNumeros = scan.nextInt();

        int[] vetor = new int[qtdNumeros];
        int qtdNumerosPares = 0;

        for (int i = 0; i < vetor.length; i++) {
            System.out.print("Informe um número: ");
            vetor[i] = scan.nextInt();

            if (vetor[i] % 2 == 0) {
                qtdNumerosPares++;
            }
        }

        System.out.print("\nNÚMEROS PARES:\n");

        for (int numeros : vetor) {
            if (numeros % 2 == 0) {
                System.out.print(numeros + " ");
            }
        }

        System.out.printf("\n\nQUANTIDADE DE PARES: %d", qtdNumerosPares);

        scan.close();
    }
}
