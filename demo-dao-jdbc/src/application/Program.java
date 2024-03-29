package application;

import model.dao.DAOFactory;
import model.dao.VendedorDAO;
import model.entidades.Vendedor;

public class Program {
    public static void main(String[] args) {
        VendedorDAO vendedorDAO = DAOFactory.createVendedorDAO();

        System.out.println("=== Teste 1: Vendedor findById ===");

        Vendedor vendedor = vendedorDAO.findById(9);

        System.out.println(vendedor);
    }
}
