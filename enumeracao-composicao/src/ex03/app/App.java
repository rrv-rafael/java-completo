package ex03.app;

import ex03.entidades.Cliente;

import java.time.LocalDate;
import java.util.Locale;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);

        Scanner scan = new Scanner(System.in);

        System.out.println("Informe os dados do cliente:");
        System.out.print("Nome: ");
        String nome = scan.nextLine();
        System.out.print("E-mail: ");
        String email = scan.nextLine();
        System.out.print("Data de nascimento: ");
        String dataInformada = scan.nextLine();

        LocalDate dataNascimento = LocalDate.parse(dataInformada, Cliente.FORMATTER);

        Cliente cliente = new Cliente(nome, email, dataNascimento);

        System.out.println("Informe os dados do pedido:");
        System.out.print("Status: ");
        String status = scan.nextLine();
        System.out.print("Quantos items neste pedido? ");
        int qtdItemsPedido = scan.nextInt();

        for (int i = 0; i < qtdItemsPedido; i++) {
            System.out.printf("Informe os dados do item #%d:\n", i + 1);
            System.out.print("Nome do produto: ");
            String nomeProduto = scan.nextLine();
            System.out.print("Preço do produto: ");
            double precoProduto = scan.nextDouble();
            System.out.print("Quantidade: ");
            int qtd = scan.nextInt();
        }
    }
}
