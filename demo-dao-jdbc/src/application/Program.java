package application;

import model.dao.DAOFactory;
import model.dao.VendedorDAO;
import model.entidades.Vendedor;

public class Program {
    public static void main(String[] args) {
        VendedorDAO vendedorDAO = DAOFactory.createVendedorDAO();

        Vendedor vendedor = vendedorDAO.findById(3);

        System.out.println(vendedor);
    }
}
