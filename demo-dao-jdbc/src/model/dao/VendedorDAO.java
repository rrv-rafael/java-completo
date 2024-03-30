package model.dao;

import model.entidades.Departamento;
import model.entidades.Vendedor;

import java.util.List;

public interface VendedorDAO {
    void insert(Vendedor vendedor);
    void update(Vendedor vendedor);
    void deleteById(Integer codVendedor);
    Vendedor findById(Integer codVendedor);
    List<Vendedor> findAll();
    List<Vendedor> findByDepartamento(Departamento departamento);
}
