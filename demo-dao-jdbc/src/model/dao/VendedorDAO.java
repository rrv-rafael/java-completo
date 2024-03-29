package model.dao;

import model.entidades.Vendedor;

import java.util.List;

public interface VendedorDAO {
    void insert(Vendedor vendedor);
    void update(Vendedor vendedor);
    void delete(Vendedor vendedor);
    Vendedor findById(Integer codVendedor);
    List<Vendedor> findAll();
}
