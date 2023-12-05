package ex08;

import java.sql.SQLOutput;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.print("Informe o tamanho do vetor: ");
        int tamanhoVetor = scan.nextInt();

        int[] vetor = new int[tamanhoVetor];
        int soma = 0;
        int qtdNumerosPares = 0;

        for (int i = 0; i < vetor.length; i++) {
            System.out.print("Informe um número: ");
            vetor[i] = scan.nextInt();

            if (vetor[i] % 2 == 0) {
                soma += vetor[i];
                qtdNumerosPares++;
            }
        }

        if (qtdNumerosPares > 0) {
            double media = (double) soma / qtdNumerosPares;
            System.out.println("MÉDIA DOS PARES: " + media);
        } else {
            System.out.println("NENHUM NÚMERO PAR");
        }

        scan.close();
    }
}
