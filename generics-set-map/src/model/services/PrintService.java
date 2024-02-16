package model.services;

import java.util.ArrayList;
import java.util.List;

public class PrintService<T> {
    private final List<T> lista = new ArrayList<>();
    public void addValor(T valor) {
        lista.add(valor);
    }

    public T primeiroValor() {
        if (lista.isEmpty()) {
            throw new IllegalArgumentException("A lista está vazia.");
        }

        return lista.getFirst();
    }

    public void imprimir() {
        System.out.println(lista);
    }
}