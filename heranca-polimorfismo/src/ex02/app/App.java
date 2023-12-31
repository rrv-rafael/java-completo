package ex02.app;

import ex02.entidades.Produto;
import ex02.entidades.ProdutoImportato;
import ex02.entidades.ProdutoUsado;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner scan = new Scanner(System.in);

        List<Produto> produtos = new ArrayList<>();

        System.out.print("Informe o número de produtos: ");
        int qtdProdutos = scan.nextInt();

        for (int i = 0; i < qtdProdutos; i++) {
            System.out.printf("Dados do produto #%d:\n", i + 1);
            System.out.print("Comum, usado ou importado (c/u/i)? ");
            char tipoProduto = scan.next().charAt(0);

            System.out.print("Nome: ");
            scan.nextLine();
            String nome = scan.nextLine();
            System.out.print("Preço: ");
            double preco = scan.nextDouble();

            if (tipoProduto == 'i' || tipoProduto == 'I') {
                System.out.print("Taxa da alfândega: ");
                double taxaAlfandega = scan.nextDouble();

                produtos.add(new ProdutoImportato(nome, preco, taxaAlfandega));
            } else if (tipoProduto == 'u' || tipoProduto == 'U') {
                System.out.print("Data de fabricação (DD/MM/YYYY): ");
                String dataInformada = scan.next();

                LocalDate dataFabricacao = LocalDate.parse(dataInformada, ProdutoUsado.FORMATTER);

                produtos.add(new ProdutoUsado(nome, preco, dataFabricacao));
            } else {
                produtos.add(new Produto(nome, preco));
            }
        }

        System.out.println("\nETIQUETAS DE PREÇO:");

        for (Produto p : produtos) {
            System.out.println(p.etiquetaPreco());
        }

        scan.close();
    }
}
