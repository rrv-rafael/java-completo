package ex02.model.services;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class CalculoService {
    public static <T> T maior(List<T> lista, Comparator<T> comparator) {
        if (lista.isEmpty()) {
            throw new IllegalArgumentException("A lista não pode ser vazia.");
        }

        return Collections.max(lista, comparator);
    }
}
