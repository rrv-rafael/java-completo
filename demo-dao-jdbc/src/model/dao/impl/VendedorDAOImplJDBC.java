package model.dao.impl;

import db.DB;
import db.DbException;
import model.dao.VendedorDAO;
import model.entidades.Departamento;
import model.entidades.Vendedor;

import java.sql.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class VendedorDAOImplJDBC implements VendedorDAO {
    private final Connection connection;

    public VendedorDAOImplJDBC(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void insert(Vendedor vendedor) {

    }

    @Override
    public void update(Vendedor vendedor) {

    }

    @Override
    public void delete(Vendedor vendedor) {

    }

    @Override
    public Vendedor findById(Integer codVendedor) {
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            String query = "SELECT v.*, d.Nome AS NomeDepartamento " +
                           "FROM vendedor v INNER JOIN departamento d " +
                           "ON v.CodDepartamento = d.CodDepartamento " +
                           "WHERE v.CodVendedor = ?";

            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, codVendedor);
            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                Departamento departamento = instatiateDepartamento(resultSet);

                return instatiateVendedor(resultSet, departamento);
            }

            return null;

        } catch (SQLException e) {
            throw new DbException("Ocorreu o seguinte erro: " + e.getMessage());
        } finally {
            DB.closeStatement(preparedStatement);
            DB.closeResultSet(resultSet);
        }
    }

    private Vendedor instatiateVendedor(ResultSet resultSet, Departamento departamento) throws SQLException {
        Vendedor vendedor = new Vendedor();
        vendedor.setCodVendedor(resultSet.getInt("CodVendedor"));
        vendedor.setNome(resultSet.getString("Nome"));
        vendedor.setEmail(resultSet.getString("Email"));
        Timestamp timestamp = resultSet.getTimestamp("DataNascimento");
        LocalDateTime localDateTime = timestamp.toLocalDateTime();
        LocalDate localDate = localDateTime.toLocalDate();
        vendedor.setDataNascimento(localDate);
        vendedor.setSalarioBase(resultSet.getDouble("SalarioBase"));
        vendedor.setDepartamento(departamento);

        return vendedor;
    }

    private Departamento instatiateDepartamento(ResultSet resultSet) throws SQLException {
        Departamento departamento = new Departamento();
        departamento.setCodDepartamento(resultSet.getInt("CodDepartamento"));
        departamento.setNome(resultSet.getString("NomeDepartamento"));

        return departamento;
    }

    @Override
    public List<Vendedor> findAll() {
        return null;
    }

    @Override
    public List<Vendedor> findByDepartamento(Departamento departamento) {
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            String query = "SELECT v.*, d.Nome AS NomeDepartamento " +
                           "FROM vendedor v INNER JOIN departamento d " +
                           "ON v.CodDepartamento = d.CodDepartamento " +
                           "WHERE d.CodDepartamento = ? " +
                           "ORDER BY v.Nome";

            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, departamento.getCodDepartamento());
            resultSet = preparedStatement.executeQuery();

            List<Vendedor> vendedores = new ArrayList<>();
            Map<Integer, Departamento> map = new HashMap<>();

            while (resultSet.next()) {
                departamento = map.get(resultSet.getInt("CodDepartamento"));

                if (departamento == null) {
                    departamento = instatiateDepartamento(resultSet);
                    map.put(resultSet.getInt("CodDepartamento"), departamento);
                }

                Vendedor vendedor = instatiateVendedor(resultSet, departamento);
                vendedores.add(vendedor);
            }

            return vendedores;

        } catch (SQLException e) {
            throw new DbException("Ocorreu o seguinte erro: " + e.getMessage());
        } finally {
            DB.closeStatement(preparedStatement);
            DB.closeResultSet(resultSet);
        }
    }
}
