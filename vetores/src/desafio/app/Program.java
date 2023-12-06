package desafio.app;

import desafio.entidades.Aluguel;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.print("Quantos quartos serão alugados: ");
        int qtdAlugueis = scan.nextInt();

        Aluguel[] aluguel = new Aluguel[qtdAlugueis];

        for (int i = 0; i < aluguel.length; i++) {
            System.out.printf("\nAluguel #%d:\n", i + 1);
            scan.nextLine();
            System.out.print("Nome: ");
            String nome = scan.nextLine();
            System.out.print("E-mail: ");
            String email = scan.nextLine();
            System.out.print("Número do quarto: ");
            int numeroQuarto = scan.nextInt();

            aluguel[i] = new Aluguel(nome, email, numeroQuarto);
        }

        Arrays.sort(aluguel, Comparator.comparingInt(Aluguel::getNumeroQuarto));

        System.out.println("\nQuartos alugados:");

        for (Aluguel a : aluguel) {
            System.out.println(a);
        }

        scan.close();
    }
}
