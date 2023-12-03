package ex03.app;

import ex03.entidades.Pessoa;

import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);

        Scanner scan = new Scanner(System.in);

        System.out.print("Quantas pessoas serão digitadas? ");
        int qtdPessoas = scan.nextInt();

        Pessoa[] pessoa = new Pessoa[qtdPessoas];
        double soma = 0;
        int count = 0;

        for (int i = 0; i < pessoa.length; i++) {
            System.out.printf("Dados da %dª pessoa:\n", i + 1);
            System.out.print("Nome: ");
            scan.nextLine();
            String nome = scan.nextLine();
            System.out.print("Idade: ");
            int idade = scan.nextInt();
            System.out.print("Altura: ");
            double altura = scan.nextDouble();

            soma += altura;

            if (idade < 16) {
                count++;
            }

            pessoa[i] = new Pessoa(nome, idade, altura);
        }

        double media = soma / pessoa.length;
        double porcentagem = ((double) count / pessoa.length) * 100;

        System.out.printf("\nAltura média: %.2f", media);
        System.out.printf("\nPessoas com menos de 16 anos: %.1f%%\n", porcentagem);

        for (Pessoa p : pessoa) {
            if (p.getIdade() < 16) {
                System.out.println(p.getNome());
            }
        }

        scan.close();
    }
}
