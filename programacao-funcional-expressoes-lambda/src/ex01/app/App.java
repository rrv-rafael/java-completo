package ex01.app;

import ex01.entidades.Produto;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;

public class App {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);

        List<Produto> produtos = new ArrayList<>();

        produtos.add(new Produto("TV", 900.00));
        produtos.add(new Produto("Notebook", 1200.00));
        produtos.add(new Produto("Tablet", 450.00));

        produtos.sort(Comparator.comparing(p -> p.getNome().toUpperCase()));

        for (Produto p : produtos) {
            System.out.println(p);
        }
    }
}
