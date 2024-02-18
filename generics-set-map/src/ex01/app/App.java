package ex01.app;

import ex01.model.services.PrintService;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Quantos valores serão informados: ");
        int qtdValores = scanner.nextInt();

        PrintService<String> printService = new PrintService<>();

        for (int i = 0; i < qtdValores; i++) {
            printService.addValor(scanner.next());
        }

        printService.imprimir();

        System.out.printf("Primeiro valor: %s", printService.primeiroValor());

        scanner.close();
    }
}
