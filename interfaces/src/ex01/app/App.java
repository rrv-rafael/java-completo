package ex01.app;

import ex01.entidades.Locadora;
import ex01.entidades.Veiculo;
import ex01.services.BrasilTaxaService;
import ex01.services.LocadoraService;

import java.time.LocalDateTime;
import java.util.Locale;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);

        Scanner scan = new Scanner(System.in);

        System.out.println("Informe os dados da locação:");
        System.out.print("Modelo do veículo: ");
        String modeloVeiculo = scan.nextLine();
        System.out.print("Retirada (dd/MM/yyyy hh:mm): ");
        LocalDateTime dataRetirada = LocalDateTime.parse(scan.nextLine(), Locadora.FORMATTER);
        System.out.print("Devolução (dd/MM/yyyy hh:mm): ");
        LocalDateTime dataDevolucao = LocalDateTime.parse(scan.nextLine(), Locadora.FORMATTER);

        Locadora locadora = new Locadora(dataRetirada, dataDevolucao, new Veiculo(modeloVeiculo));

        System.out.print("Informe o preço por hora: ");
        double precoHora = scan.nextDouble();
        System.out.print("Informe o preço por dia: ");
        double precoDia = scan.nextDouble();

        LocadoraService locadoraService = new LocadoraService(precoHora, precoDia, new BrasilTaxaService());

        locadoraService.processarFatura(locadora);

        System.out.println("FATURA:");
        System.out.printf("Pagamento básico: %.2f", locadora.getFatura().getPagamentoBasico());
        System.out.printf("\nImposto: %.2f", locadora.getFatura().getTaxa());
        System.out.printf("\nPagamento total: %.2f", locadora.getFatura().getPagamentoTotal());

        scan.close();
    }
}
