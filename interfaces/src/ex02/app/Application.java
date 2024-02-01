package ex02.app;

import ex02.entidades.Contrato;
import ex02.services.ContratoService;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Application {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        Scanner scan = new Scanner(System.in);

        System.out.println("Informe os dados do contrato:");
        System.out.print("Número: ");
        int numeroContrato = scan.nextInt();
        System.out.print("Data (dd/MM/yyyy): ");
        LocalDate dataContrato = LocalDate.parse(scan.next(), formatter);
        System.out.print("Valor do contrato: ");
        double valorContrato = scan.nextDouble();

        System.out.print("Informe o número de parcelas: ");
        int numeroParcelas = scan.nextInt();

        Contrato contrato = new Contrato(numeroContrato, dataContrato, valorContrato);

        ContratoService contratoService = new ContratoService();

        contratoService.processarContrato(contrato, numeroParcelas);

        System.out.println("Parcelas:");

        for (int i = 0; i < contrato.getParcelas().size(); i++) {
            System.out.println(contrato.getParcelas().get(i).getDataPagamento() + " - " + contrato.getParcelas().get(i).getValor());
        }

        scan.close();
    }
}
