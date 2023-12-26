package ex01.app;

import ex01.entidades.Contrato;
import ex01.entidades.Departamento;
import ex01.entidades.Funcionario;
import ex01.entidades.enums.NivelFuncionario;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        Scanner scan = new Scanner(System.in);

        System.out.print("Informe o nome do departamento: ");
        String nomeDepartamento = scan.nextLine();

        Departamento departamento = new Departamento(nomeDepartamento);

        System.out.println("\nInforme os dados do funcionário:");
        System.out.print("Nome: ");
        String nome = scan.nextLine();
        System.out.print("Nível: ");
        String nivelFuncionario = scan.nextLine();
        System.out.print("Salário base: ");
        double salarioBase = scan.nextDouble();

        Funcionario funcionario = new Funcionario(nome, NivelFuncionario.valueOf(nivelFuncionario), salarioBase, departamento);

        System.out.print("\nQuantos contratos para este funcionário: ");
        int qtdContrato = scan.nextInt();

        for (int i = 0; i < qtdContrato; i++) {
            System.out.printf("\nInforme os dados do contrato #%d:\n", i + 1);
            System.out.print("Data (DD/MM/YYYY): ");
            String dataInformada = scan.next();
            System.out.print("Valor por hora: ");
            double valorHora = scan.nextDouble();
            System.out.print("Duração (em horas): ");
            int duracaoContrato = scan.nextInt();

            LocalDate dataContrato = LocalDate.parse(dataInformada, formatter);

            Contrato contrato = new Contrato(dataContrato, valorHora, duracaoContrato);

            funcionario.addContrato(contrato);
        }

        System.out.print("\nInforme o mês e ano para calcular o rendimento (MM/YYYY): ");
        String dataInformada = scan.next();
        LocalDate localDate = LocalDate.parse("01/" + dataInformada, formatter);
        int mes = localDate.getMonthValue();
        int ano = localDate.getYear();

        System.out.println(funcionario);
        System.out.printf("Rendimentos referente à %s: %.2f", dataInformada, funcionario.rendimento(ano, mes));

        scan.close();
    }
}
