package banco.app;

import banco.entidades.ContaBancaria;

import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);

        Scanner scan = new Scanner(System.in);
        ContaBancaria conta;

        System.out.print("Informe o número da conta: ");
        String numeroConta = scan.next();
        scan.nextLine();
        System.out.print("Informe o seu nome: ");
        String nome = scan.nextLine();

        System.out.print("Deseja realizar um depósito na criação da conta (S/N)? ");
        char decisao = scan.next().charAt(0);

        if (decisao == 'S' || decisao == 's') {
            System.out.print("Informe o valor do depósito: ");
            double valorDeposito = scan.nextDouble();

            conta = new ContaBancaria(numeroConta, nome, valorDeposito);
        } else {
            conta = new ContaBancaria(numeroConta, nome);
        }

        System.out.println("Conta bancária, criada com sucesso!" + conta);

        System.out.print("\nInforme um valor para realizar o depósito: ");
        conta.realizarDeposito(scan.nextDouble());

        System.out.println("\nSaque realizado com sucesso!" + conta);

        System.out.print("\nInforme um valor para realizar o um saque: ");
        conta.realizarSaque(scan.nextDouble());

        System.out.println("\nDepósito realizado com sucesso!" + conta);

        scan.close();
    }
}
