package application;

import model.dao.DAOFactory;
import model.dao.VendedorDAO;
import model.entidades.Departamento;
import model.entidades.Vendedor;

import java.util.List;

public class Program {
    public static void main(String[] args) {
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
    }
}
