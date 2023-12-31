package ex04.app;

import ex04.entidades.Pessoa;
import ex04.entidades.PessoaFisica;
import ex04.entidades.PessoaJuridica;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);

        Scanner scan = new Scanner(System.in);

        List<Pessoa> pessoas = new ArrayList<>();

        System.out.print("Informe a quantidade de contribuintes: ");
        int quantidadeContribuintes = scan.nextInt();

        for (int i = 0; i < quantidadeContribuintes; i++) {
            System.out.printf("Informe os dados do contribuinte %d:%n", i + 1);
            System.out.print("Pessoa física ou jurídica (f/j)? ");
            char tipoPessoa = scan.next().charAt(0);

            System.out.print("Nome: ");
            scan.nextLine();
            String nome = scan.nextLine();
            System.out.print("Renda anual: ");
            double rendaAnual = scan.nextDouble();

            if (tipoPessoa == 'f' || tipoPessoa == 'F') {
                System.out.print("Gastos com saúde: ");
                double gastosSaude = scan.nextDouble();

                pessoas.add(new PessoaFisica(nome, rendaAnual, gastosSaude));
            } else {
                System.out.print("Números de funcionários: ");
                int numeroFuncionarios = scan.nextInt();

                pessoas.add(new PessoaJuridica(nome, rendaAnual, numeroFuncionarios));
            }
        }

        System.out.println("\nIMPOSTOS PAGOS:");

        for (Pessoa pessoa : pessoas) {
            System.out.printf("%s: $%.2f%n", pessoa.getNome(), pessoa.calcularImposto());
        }

        double totalImposto = 0;

        for (Pessoa pessoa : pessoas) {
            totalImposto += pessoa.calcularImposto();
        }

        System.out.printf("\nTotal de imposto arrecadado: $%.2f", totalImposto);

        scan.close();
    }
}
