package ex10.app;

import ex10.entidades.Aluno;

import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);

        Scanner scan = new Scanner(System.in);

        System.out.print("Quantos aluno serão informados: ");
        int qtdAlunos = scan.nextInt();

        Aluno[] aluno = new Aluno[qtdAlunos];

        for (int i = 0; i < aluno.length; i++) {
            System.out.printf("Digite nome, primeira e segunda nota do %do aluno:\n", i + 1);
            scan.nextLine();
            String nome = scan.nextLine();
            double[] notas = new double[2];

            for (int j = 0; j < notas.length; j++) {
                notas[j] = scan.nextDouble();
            }

            aluno[i] = new Aluno(nome, notas);
        }

        System.out.println("Alunos aprovados:");

        for (Aluno a : aluno) {
            if (a.calcularMedia() >= 6) {
                System.out.println(a.getNome());
            }
        }

        scan.close();
    }
}
