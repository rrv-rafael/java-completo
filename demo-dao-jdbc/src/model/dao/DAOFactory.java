package model.dao;

import db.DB;
import model.dao.impl.VendedorDAOImplJDBC;

public class DAOFactory {
    public static VendedorDAO createVendedorDAO() {
        return new VendedorDAOImplJDBC(DB.getConnection());
    }
}
