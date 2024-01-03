package ex01.app;

import ex01.model.entidades.Reserva;
import ex01.model.excecoes.DominioExcecao;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;

public class App {
    private static final Scanner SCAN = new Scanner(System.in);
    private static LocalDate dataEntrada, dataSaida;
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);

        try {
            System.out.print("Número do quarto: ");
            int numeroQuarto = SCAN.nextInt();

            lerData();

            Reserva reserva = new Reserva(numeroQuarto, dataEntrada, dataSaida);

            System.out.println(reserva);

            System.out.println("\nEntre com as datas para atualizar sua reserva:");

            lerData();

            reserva.atualizarData(dataEntrada, dataSaida);

            System.out.println(reserva);
        } catch (DateTimeParseException e) {
            System.out.println("Formato de data inválido.");
        } catch (DominioExcecao e) {
            System.out.println("Erro na reserva: " + e.getMessage());
        } catch (InputMismatchException e) {
            System.out.println("Digite valores numéricos para o número do quarto.");
        } catch (RuntimeException e) {
            System.out.println("Ocorreu um erro inesperado.");
        }

        SCAN.close();
    }

    private static void lerData() {
        System.out.print("Data de entrada (dd/MM/yyyy): ");
        dataEntrada = LocalDate.parse(SCAN.next(), Reserva.FORMATTER);
        System.out.print("Data de saída (dd/MM/yyyy): ");
        dataSaida = LocalDate.parse(SCAN.next(), Reserva.FORMATTER);
    }
}
