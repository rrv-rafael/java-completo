package ex01.entidades;

import java.util.Comparator;

public class MyComparator implements Comparator<Produto> {

    @Override
    public int compare(Produto p1, Produto p2) {
        return p1.getNome().toUpperCase().compareTo(p2.getNome().toUpperCase());
    }
}
