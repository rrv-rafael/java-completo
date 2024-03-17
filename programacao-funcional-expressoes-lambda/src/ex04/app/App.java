package ex04.app;

import ex04.entidades.Produto;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

public class App {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);

        List<Produto> produtos = new ArrayList<>();

        produtos.add(new Produto("TV", 900.00));
        produtos.add(new Produto("Mouse", 50.00));
        produtos.add(new Produto("Tablet", 350.50));
        produtos.add(new Produto("HD Case", 80.90));

        List<String> nomes = produtos.stream().map(p -> p.getNome().toUpperCase()).toList();

        nomes.forEach(System.out::println);
    }
}
