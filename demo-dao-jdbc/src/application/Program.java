package application;

import model.entidades.Departamento;
import model.entidades.Vendedor;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Program {
    public static void main(String[] args) {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        Departamento departamento = new Departamento(1, "Livros");

        Vendedor vendedor = new Vendedor(1, "Rafael Rodrigues Vitor", "rafael.vitor@gmail.com", LocalDate.parse("12/11/1992", dateTimeFormatter), 3.000, departamento);

        System.out.println(vendedor);
    }
}
