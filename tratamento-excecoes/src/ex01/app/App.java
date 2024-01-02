package ex01.app;

import ex01.model.entidades.Reserva;

import java.time.LocalDate;
import java.util.Locale;
import java.util.Scanner;

public class App {
    private static final Scanner SCAN = new Scanner(System.in);
    private static LocalDate dataEntrada, dataSaida;
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);

        System.out.print("Número do quarto: ");
        int numeroQuarto = SCAN.nextInt();

        lerData();

        Reserva reserva = new Reserva(numeroQuarto, dataEntrada, dataSaida);

        System.out.println(reserva);

        System.out.println("\nEntre com a data para atualizar sua reserva:");

        lerData();

        reserva.atualizarData(dataEntrada, dataSaida);
        System.out.println(reserva);

        SCAN.close();
    }

    private static void lerData() {
        System.out.print("Data de entrada (dd/MM/yyyy): ");
        dataEntrada = LocalDate.parse(SCAN.next(), Reserva.FORMATTER);
        System.out.print("Data de saída (dd/MM/yyyy): ");
        dataSaida = LocalDate.parse(SCAN.next(), Reserva.FORMATTER);
    }
}
