package ex01.app;

import ex01.model.entidades.Reserva;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class App {
    public static Scanner scan = new Scanner(System.in);
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);

        System.out.print("Número do quarto: ");
        int numeroQuarto = scan.nextInt();

        List<LocalDate> datas = lerData();

        Reserva reserva = new Reserva(numeroQuarto, datas.getFirst(), datas.getLast());

        System.out.println(reserva);

        System.out.println("\nEntre com a data para atualizar sua reserva:");

        datas = lerData();

        reserva.atualizarData(datas.getFirst(), datas.getLast());
        System.out.println(reserva);

        scan.close();
    }

    public static List<LocalDate> lerData() {
        System.out.print("Data de entrada (dd/MM/yyyy): ");
        String dataEntradaInformada = scan.next();
        System.out.print("Data de saída (dd/MM/yyyy): ");
        String dataSaidaInformada = scan.next();

        LocalDate dataEntrada = LocalDate.parse(dataEntradaInformada, Reserva.FORMATTER);
        LocalDate dataSaida = LocalDate.parse(dataSaidaInformada, Reserva.FORMATTER);

        List<LocalDate> datas = new ArrayList<>();

        datas.add(dataEntrada);
        datas.add(dataSaida);

        return datas;
    }
}
