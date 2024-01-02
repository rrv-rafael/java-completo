package ex01.app;

import ex01.model.entidades.Reserva;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner scan = new Scanner(System.in);

        String dataEntradaInformada, dataSaidaInformada;
        LocalDate dataEntrada, dataSaida;

        System.out.print("Número do quarto: ");
        int numeroQuarto = scan.nextInt();
        System.out.print("Data de entrada (dd/MM/yyyy): ");
        dataEntradaInformada = scan.next();
        System.out.print("Data de saída (dd/MM/yyyy): ");
        dataSaidaInformada = scan.next();

        dataEntrada = LocalDate.parse(dataEntradaInformada, Reserva.FORMATTER);
        dataSaida = LocalDate.parse(dataSaidaInformada, Reserva.FORMATTER);

        Reserva reserva = new Reserva(numeroQuarto, dataEntrada, dataSaida);

        System.out.println(reserva);

        System.out.println("\nEntre com a data para atualizar sua reserva:");
        System.out.print("Data de entrada (dd/MM/yyyy): ");
        dataEntradaInformada = scan.next();
        System.out.print("Data de saída (dd/MM/yyyy): ");
        dataSaidaInformada = scan.next();

        dataEntrada = LocalDate.parse(dataEntradaInformada, Reserva.FORMATTER);
        dataSaida = LocalDate.parse(dataSaidaInformada, Reserva.FORMATTER);

        reserva.atualizarData(dataEntrada, dataSaida);
        System.out.println(reserva);

        scan.close();
    }
}
