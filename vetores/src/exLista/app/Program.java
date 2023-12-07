package exLista.app;

import exLista.Entidades.Funcionario;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);

        Scanner scan = new Scanner(System.in);

        System.out.print("Quantos funcionários serão cadastrados? ");
        int qtdFuncionarios = scan.nextInt();

        List<Funcionario> funcionarios = new ArrayList<>();

        for (int i = 0; i < qtdFuncionarios; i++) {
            System.out.printf("\nFuncionário #%d\n", i + 1);
            System.out.print("Id: ");
            int id = scan.nextInt();

            boolean idExistente = funcionarios.stream().anyMatch(funcionario -> funcionario.getId() == id);

            if (idExistente) {
                System.out.print("\nEste ID já está em uso. Digite novamente!\n");
                i--;
                continue;
            }

            scan.nextLine();
            System.out.print("Nome: ");
            String nome = scan.nextLine();
            System.out.print("Salário: ");
            double salario = scan.nextDouble();

            funcionarios.add(new Funcionario(id, nome, salario));
        }

        System.out.print("\nInforme o id do funcionário que terá aumento salarial: ");
        int id = scan.nextInt();

        Funcionario funcionario = funcionarios.stream()
                .filter(f -> f.getId() == id)
                .findFirst().orElse(null);

        if (funcionario != null) {
            System.out.print("Informe o percentual do aumento: ");
            double percentualAumentoSalarial = scan.nextDouble();

            funcionario.aumentarSalario(percentualAumentoSalarial);
        } else {
            System.out.println("Este id não existe.");
        }

        System.out.println("\nLista do funcionários:");

        for (Funcionario f : funcionarios) {
            System.out.println(f);
        }

        scan.close();
    }
}
