package ex06;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.print("Quantos terão cada vetor? ");
        int tamanhoVetor = scan.nextInt();

        int[] vetorA = new int[tamanhoVetor];
        int[] vetorB = new int[tamanhoVetor];
        int[] vetorC = new int[tamanhoVetor];

        System.out.println("Informe o valor para o vetor A:");

        for (int i = 0; i < vetorA.length; i++) {
            vetorA[i] = scan.nextInt();
        }

        System.out.println("Informe o valor para o vetor B: ");

        for (int i = 0; i < vetorB.length; i++) {
            vetorB[i] = scan.nextInt();
        }

        System.out.println("VETOR RESULTANTE:");

        for (int i = 0; i < vetorC.length; i++) {
            vetorC[i] = vetorA[i] + vetorB[i];

            System.out.println(vetorC[i]);
        }

        scan.close();
    }
}
