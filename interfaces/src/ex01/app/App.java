package ex01.app;

import ex01.entidades.Locadora;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);

        Scanner scan = new Scanner(System.in);

        System.out.println("Informe os dados da locação:");
        System.out.print("Modelo do veículo: ");
        String modeloVeiculo = scan.nextLine();
        System.out.print("Retirada: ");
        LocalDateTime dataRetirada = LocalDateTime.parse(scan.nextLine(), Locadora.FORMATTER);
        System.out.print("Devolução: ");
        LocalDateTime dataDevolucao = LocalDateTime.parse(scan.nextLine(), Locadora.FORMATTER);
        System.out.print("Informe o preço por hora: ");
        double precoHora = scan.nextDouble();
        System.out.print("Informe o preço por dia: ");
        double precoDia = scan.nextDouble();

        Locadora locadora = new Locadora(modeloVeiculo, dataRetirada, dataDevolucao, precoHora, precoDia);

        System.out.println("FATURA:");
        System.out.println(locadora);

        scan.close();
    }
}
