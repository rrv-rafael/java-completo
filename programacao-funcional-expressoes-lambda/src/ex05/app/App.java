package ex05.app;

import ex05.entidades.Produto;
import ex05.services.ProdutoService;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class App {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);

        List<Produto> produtos = new ArrayList<>();

        produtos.add(new Produto("TV", 900.00));
        produtos.add(new Produto("Mouse", 50.00));
        produtos.add(new Produto("Tablet", 350.50));
        produtos.add(new Produto("HD Case", 80.90));

        ProdutoService produtoService = new ProdutoService();

        double soma = produtoService.filtroSoma(produtos, p -> p.getNome().charAt(0) == 'M');

        System.out.printf("Soma dos produtos que começam com a letra T: %.2f", soma);
    }
}
