package ex08.app;

import ex08.entidades.Produto;

import java.util.HashMap;
import java.util.Map;

public class App {
    public static void main(String[] args) {
        Map<Produto, Double> estoque = new HashMap<>();

        Produto p1 = new Produto("TV", 900.0);
        Produto p2 = new Produto("Notebook", 1200.0);
        Produto p3 = new Produto("Tablet", 400.0);

        estoque.put(p1, 10000.0);
        estoque.put(p2, 20000.0);
        estoque.put(p3, 15000.0);

        Produto ps = new Produto("TV", 900.0);

        System.out.println("Contém 'ps' chave: " + estoque.containsKey(ps));
    }
}
