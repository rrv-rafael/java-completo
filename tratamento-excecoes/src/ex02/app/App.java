package ex02.app;

import ex02.model.excecoes.DominioExcecao;
import ex02.model.entidades.Conta;

import java.util.Locale;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner scan = new Scanner(System.in);

        try {
            System.out.println("Informe os dados da conta");
            System.out.print("Número da conta: ");
            int numeroConta = scan.nextInt();
            System.out.print("Títular da conta: ");
            scan.nextLine();
            String titularConta = scan.nextLine();
            System.out.print("Saldo inicial: ");
            double saldoInicial = scan.nextDouble();
            System.out.print("Limite de saque: ");
            double limiteSaque = scan.nextDouble();

            Conta conta = new Conta(numeroConta, titularConta, saldoInicial, limiteSaque);

            System.out.print("\nInforme o valor para o saque: ");
            double valorSaque = scan.nextDouble();

            conta.sacar(valorSaque);

            System.out.printf("Novo saldo: %.2f", conta.getSaldo());

        } catch (DominioExcecao e) {
            System.out.println("Erro ao sacar: " + e.getMessage());
        }

        scan.close();
    }
}
