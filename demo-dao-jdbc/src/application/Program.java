package application;

import model.dao.DAOFactory;
import model.dao.VendedorDAO;
import model.entidades.Departamento;
import model.entidades.Vendedor;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        VendedorDAO vendedorDAO = DAOFactory.createVendedorDAO();

        System.out.println("=== Teste 1: Vendedor findById ===");
        Vendedor vendedor = vendedorDAO.findById(9);
        System.out.println(vendedor);

        System.out.println("=== Teste 2: Vendedor findByDepartamento ===");
        Departamento departamento = new Departamento(2, null);
        List<Vendedor> vendedores = vendedorDAO.findByDepartamento(departamento);

        for (Vendedor v : vendedores) {
            System.out.println(v);
        }

        System.out.println("=== Teste 3: Vendedor findAll ===");
        vendedores = vendedorDAO.findAll();

        for (Vendedor v : vendedores) {
            System.out.println(v);
        }

        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        System.out.println("=== Teste 4: Vendedor insert ===");
        Vendedor vendedorInsert = new Vendedor(null, "Greg", "greg@gmail.com", LocalDate.parse("21/03/1991", dateTimeFormatter), 4000.0, departamento);
        vendedorDAO.insert(vendedorInsert);
        System.out.println("Inserido. Novo codVendedor = " + vendedorInsert.getCodVendedor());

        System.out.println("=== Teste 5: Vendedor update ===");
        vendedor = vendedorDAO.findById(1);
        vendedor.setNome("Marta Waine");
        vendedorDAO.update(vendedor);
        System.out.println("Update completado");

        System.out.println("=== Teste 6 Vendedor delete ===");
        System.out.print("Informe o codVendedor que será deletado: ");
        int codVendedor = scanner.nextInt();
        vendedorDAO.deleteById(codVendedor);
        System.out.println("Delete completado.");

        scanner.close();
    }
}
