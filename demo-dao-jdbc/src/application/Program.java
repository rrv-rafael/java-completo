package application;

import model.entidades.Departamento;

public class Program {
    public static void main(String[] args) {
        Departamento departamento = new Departamento(1, "Livros");

        System.out.println(departamento);
    }
}
