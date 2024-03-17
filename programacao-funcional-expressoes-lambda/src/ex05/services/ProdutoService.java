package ex05.services;

import ex05.entidades.Produto;

import java.util.List;
import java.util.function.Predicate;

public class ProdutoService {
    public double filtroSoma(List<Produto> produtos, Predicate<Produto> criterio) {
        double soma = 0;

        for (Produto p : produtos) {
            if (criterio.test(p)) {
                soma += p.getPreco();
            }
        }

        return soma;
    }
}
