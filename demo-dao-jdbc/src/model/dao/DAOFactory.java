package model.dao;

import model.dao.impl.VendedorDAOImplJDBC;

public class DAOFactory {
    public static VendedorDAO createVendedorDAO() {
        return new VendedorDAOImplJDBC();
    }
}
