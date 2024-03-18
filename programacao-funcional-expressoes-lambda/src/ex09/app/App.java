package ex09.app;

import ex09.entidades.Funcionario;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.*;

public class App {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);

        Scanner scanner = new Scanner(System.in);

        System.out.print("Informe o caminho completo para o arquivo: ");
        String caminho = scanner.next();

        System.out.print("Informe um salário: ");
        double salarioInformado = scanner.nextDouble();

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(caminho))) {
            String[] conteudoLinha;
            String linha;
            List<Funcionario> funcionarios = new ArrayList<>();

            while ((linha = bufferedReader.readLine()) != null) {
                conteudoLinha = linha.split(",");

                String nome = conteudoLinha[0];
                String email = conteudoLinha[1];
                double salario = Double.parseDouble(conteudoLinha[2]);

                funcionarios.add(new Funcionario(nome, email, salario));
            }

            List<String> emails = funcionarios.stream()
                    .filter(f -> f.getSalario() > salarioInformado)
                    .map(Funcionario::getEmail)
                    .sorted(Comparator.comparing(String::toUpperCase))
                    .toList();


            System.out.printf("Email das pessoas com salário acima de %.2f:\n", salarioInformado);
            emails.forEach(System.out::println);

            double soma = funcionarios.stream()
                    .filter(f -> f.getNome().charAt(0) == 'M')
                    .map(Funcionario::getSalario)
                    .reduce(0.0, Double::sum);

            System.out.printf("Soma dos salários das pessoas que o nome começa com a letra 'M': %.2f", soma);
        } catch (Exception e) {
            System.out.println("Erro ao abrir o arquivo.");
        }

        scanner.close();
    }
}
