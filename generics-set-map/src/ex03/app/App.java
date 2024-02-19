package ex03.app;

import ex03.model.entidades.Circulo;
import ex03.model.entidades.Retangulo;
import ex03.model.interfaces.Forma;

import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) {
        List<Forma> formas = new ArrayList<>();

        formas.add(new Retangulo(3.0, 2.0));
        formas.add(new Circulo(2.0));

        System.out.println("Área total: " + areaTotal(formas));
    }

    public static double areaTotal(List<? extends Forma> lista) {
        double total = 0;

        for (Forma forma : lista) {
            total += forma.area();
        }

        return total;
    }
}
