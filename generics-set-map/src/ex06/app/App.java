package ex06.app;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        char turmaInicio = 'A';
        char turmaFim = 'C';

        Set<Integer> set = new HashSet<>();

        for (char turma = turmaInicio; turma <= turmaFim; turma++) {
            System.out.printf("Quantos alunos para o curso %c? ", turma);
            int qtdAlunos = scanner.nextInt();

            for (int i = 0; i < qtdAlunos; i++) {
                set.add(scanner.nextInt());
            }
        }

        System.out.printf("Total de alunos: %d", set.size());

        scanner.close();
    }
}
