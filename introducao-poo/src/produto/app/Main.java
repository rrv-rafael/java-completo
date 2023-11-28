package produto.app;

import produto.entidades.Produto;

import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);

        Scanner scan = new Scanner(System.in);

        System.out.println("Digite os dados do produto:");
        System.out.print("Nome: ");
        String nome = scan.nextLine();
        System.out.print("Preço: ");
        double preco = scan.nextDouble();
        System.out.print("Quantidade: ");
        int quantidade = scan.nextInt();

        Produto produto = new Produto(nome, preco, quantidade);

        System.out.println("Dados do Produto: " + produto);

        System.out.print("\nEntre com o número de produtos que deseja adicionar no estoque: ");
        produto.adicionarProduto(scan.nextInt());

        System.out.println("Dados atualizados: " + produto);

        System.out.print("\nEntre com o número de produtos que deseja remover do estoque: ");
        produto.removerProduto(scan.nextInt());

        System.out.println("Dados atualizados: " + produto);

        scan.close();
    }
}
