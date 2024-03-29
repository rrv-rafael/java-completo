package model.dao;

import model.entidades.Departamento;

import java.util.List;

public interface DepartamentoDAO {
    void insert(Departamento departamento);
    void update(Departamento departamento);
    void delete(Departamento departamento);
    Departamento findById(Integer codDepartamento);
    List<Departamento> findAll();
}
