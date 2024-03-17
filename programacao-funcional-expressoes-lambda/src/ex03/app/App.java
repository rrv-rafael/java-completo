package ex03.app;

import ex03.entidades.Produto;

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

        produtos.forEach(p -> p.setPreco(p.getPreco() * 1.1));

        produtos.forEach(System.out::println);
    }
}
