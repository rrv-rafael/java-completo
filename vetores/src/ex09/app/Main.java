package ex09.app;

import ex09.entidades.Pessoa;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.print("Quantas pessoas serão informadas? ");
        int qtdPessoas = scan.nextInt();

        Pessoa[] pessoa = new Pessoa[qtdPessoas];

        for (int i = 0; i < pessoa.length; i++) {
            System.out.printf("Dados da %da pessoa:\n", i + 1);
            System.out.print("Nome: ");
            scan.nextLine();
            String nome = scan.nextLine();
            System.out.print("Idade: ");
            int idade = scan.nextInt();

            pessoa[i] = new Pessoa(nome, idade);
        }

        int maiorIdade = 0;
        String nomePessoaMaisVelha = "";

        for (Pessoa p : pessoa) {
            if (p.getIdade() > maiorIdade) {
                maiorIdade = p.getIdade();
                nomePessoaMaisVelha = p.getNome();
            }
        }

        System.out.println("PESSOA MAIS VELHA: " + nomePessoaMaisVelha);

        scan.close();
    }
}
