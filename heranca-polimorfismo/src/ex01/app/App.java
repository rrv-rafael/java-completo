package ex01.app;

import ex01.entidades.Funcionario;
import ex01.entidades.FuncionarioTerceirizado;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner scan = new Scanner(System.in);

        System.out.print("Informe o número de funcionários: ");
        int numeroFuncionarios = scan.nextInt();

        List<Funcionario> funcionarios = new ArrayList<>();

        for (int i = 0; i < numeroFuncionarios; i++) {
            System.out.printf("Dados do funcionário #%d:\n", i + 1);
            System.out.print("Terceirizado (s/n)? ");
            char isFuncionarioTerceirizado = scan.next().charAt(0);

            System.out.print("Nome: ");
            scan.nextLine();
            String nome = scan.nextLine();
            System.out.print("Horas trabalhadas: ");
            int horasTrabalhadas = scan.nextInt();
            System.out.print("Valor por hora: ");
            double valorPorHora = scan.nextDouble();

            if (isFuncionarioTerceirizado == 's' || isFuncionarioTerceirizado == 'S') {
                System.out.print("Cobrança adicional: ");
                double cobrancaAdicional = scan.nextDouble();
                funcionarios.add(new FuncionarioTerceirizado(nome, horasTrabalhadas, valorPorHora, cobrancaAdicional));
            } else {
                funcionarios.add(new Funcionario(nome, horasTrabalhadas, valorPorHora));
            }
        }

        System.out.println("\nPAGAMENTOS:");

        for (Funcionario f : funcionarios) {
            System.out.println(f);
        }

        scan.close();
    }
}
