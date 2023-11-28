package produto.app;

import produto.entidades.Produto;

import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);

        Scanner scan = new Scanner(System.in);

        Produto produto = new Produto();

        System.out.println("Digite os dados do produto:");
        System.out.print("Nome: ");
        produto.setNome(scan.nextLine());
        System.out.print("Preço: ");
        produto.setPreco(scan.nextDouble());
        System.out.print("Quantidade: ");
        produto.setQuantidade(scan.nextInt());

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
