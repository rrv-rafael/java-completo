package application;

import model.dao.DAOFactory;
import model.dao.DepartamentoDAO;
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
        DepartamentoDAO departamentoDAO = DAOFactory.createDepartamentoDAO();

        Departamento departamento;

        System.out.println("=== Teste 1: Vendedor findById ===");
        Vendedor vendedor = vendedorDAO.findById(9);
        System.out.println(vendedor);

        System.out.println("=== Teste 2: Vendedor findByDepartamento ===");
        departamento = new Departamento(2, null);
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

        System.out.println("=== Teste 7 departamento insert ===");
        System.out.print("Informe o nome do departamento: ");
        String nomeDepartamento = scanner.next();
        departamento = new Departamento(null, nomeDepartamento);
        departamentoDAO.insert(departamento);
        System.out.println("Inserido. Novo codDepartamento: " + departamento.getCodDepartamento());

        System.out.println("=== Teste 8 departamento delete ===");
        System.out.print("Informe o código do departamento que será deletado: ");
        int codDepartamento = scanner.nextInt();

        departamentoDAO.deleteById(codDepartamento);
        System.out.println("Delete completado.");

        System.out.println("=== Teste 9 departamento findById ===");
        departamento = departamentoDAO.findById(5);
        System.out.println(departamento);

        System.out.println("=== Teste 10 departamento update ===");
        departamento = departamentoDAO.findById(7);
        departamento.setNome("Vestuário");
        departamentoDAO.update(departamento);
        System.out.println("Update completado.");

        System.out.println("=== Teste 11 departamento findAll ===");
        List<Departamento> departamentos = departamentoDAO.findAll();

        for (Departamento d : departamentos) {
            System.out.println(d);
        }

        scanner.close();
    }
}
