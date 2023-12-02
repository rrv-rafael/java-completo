package ex01.app;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.print("Quantos números você vai digitar? ");
        int qtdNumeros;

        do {
            qtdNumeros = scan.nextInt();

            if (qtdNumeros > 10) {
                System.out.print("Não é permitido um número maior que 10. Digite novamete: ");
            }
        } while (qtdNumeros > 10);

        int[] vetor = new int[qtdNumeros];

        for (int i = 0; i < vetor.length; i++) {
            System.out.print("Digite um número: ");
            vetor[i] = scan.nextInt();
        }

        System.out.println("NÚMEROS NEGATIVOS:");
        for (int numero: vetor) {
            if (numero < 0) {
                System.out.println(numero);
            }
        }

        scan.close();
    }
}
