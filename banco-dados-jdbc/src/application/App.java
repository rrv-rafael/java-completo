package application;

import services.Crud;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import java.util.logging.Logger;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        //Crud.buscarDados();

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

        Crud.inserirDados(nome, email, dataNascimento, salarioBase, codDepartamento);

        scanner.close();
    }
}
