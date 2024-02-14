package ex05.app;

import java.util.Locale;
import java.util.Scanner;

import ex05.model.entidades.Emprestimo;
import ex05.model.interfaces.IJurosService;
import ex05.model.services.BrasilJurosService;

public class Application {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);

        Scanner scanner = new Scanner(System.in);

        System.out.print("Quantia: ");
        double quantia = scanner.nextDouble();
        System.out.print("Meses: ");
        int meses = scanner.nextInt();

        Emprestimo emprestimo = new Emprestimo(quantia, meses);

        IJurosService jurosService = new BrasilJurosService(2.0);

        double valorCalculado = jurosService.pagamento(emprestimo.getQuantia(), emprestimo.getDuracao());

        System.out.printf("Pagamento após %d meses:", emprestimo.getDuracao());

        System.out.printf("\n%.2f", valorCalculado);

        scanner.close();
    }
}
