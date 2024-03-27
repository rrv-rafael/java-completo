package application;

import services.Crud;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        //Crud.buscarDados();
        /*
        System.out.print("Informe os dados para inserção no banco.");
        System.out.print("\nNome: ");
        String nome = scanner.nextLine();

        System.out.print("E-mail: ");
        String email = scanner.next();

        System.out.print("Data de nascimento: ");
        scanner.nextLine();
        LocalDate dataNascimento = LocalDate.parse(scanner.nextLine(), dateTimeFormatter);

        System.out.print("Sálario base: ");
        double salarioBase = scanner.nextDouble();

        System.out.print("Código do departamento: ");
        int codDepartamento = scanner.nextInt();

        Crud.inserirVendedor(nome, email, dataNascimento, salarioBase, codDepartamento);

        System.out.print("Informe os dados para atualizar.");
        System.out.print("\nInforme o valor do aumento salarial: ");
        double aumentoSalarial = scanner.nextDouble();

        System.out.print("Codigo do vendedor: ");
        int codVendedor = scanner.nextInt();

        Crud.atualizarDados(aumentoSalarial, codVendedor);


        System.out.println("Informe os dados para fazer o delete.");
        System.out.print("\nInforme o código do departamento: ");
        int codDepartamento = scanner.nextInt();

        Crud.deletarDados(codDepartamento);

        */
        System.out.print("Informe os dados para fazer o update.");
        System.out.print("\nInforme o código do vendedor: ");
        int codVendedor = scanner.nextInt();
        System.out.print("Informe o valor do aumento salarial: ");
        double aumentoSalarial = scanner.nextDouble();

        Crud.atualizarSalarioVendedores(codVendedor, aumentoSalarial);

        scanner.close();
    }
}
