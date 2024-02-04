package ex02.app;

import ex02.entidades.Contrato;
import ex02.entidades.Parcela;
import ex02.services.ContratoService;
import ex02.services.PaypalService;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Application {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);

        Scanner scan = new Scanner(System.in);

        System.out.println("Informe os dados do contrato:");
        System.out.print("Número: ");
        int numeroContrato = scan.nextInt();
        System.out.print("Data (dd/MM/yyyy): ");
        LocalDate dataContrato = LocalDate.parse(scan.next(), Parcela.FORMATTER);
        System.out.print("Valor do contrato: ");
        double valorContrato = scan.nextDouble();

        Contrato contrato = new Contrato(numeroContrato, dataContrato, valorContrato);

        System.out.print("Informe o número de parcelas: ");
        int numeroParcelas = scan.nextInt();

        ContratoService contratoService = new ContratoService(new PaypalService());

        contratoService.processarContrato(contrato, numeroParcelas);

        System.out.println("Parcelas:");

        for (Parcela parcela : contrato.getParcelas()) {
            System.out.println(parcela);
        }

        scan.close();
    }
}
