package model.dao.impl;

import db.DB;
import db.DbException;
import model.dao.DepartamentoDAO;
import model.entidades.Departamento;

import java.sql.*;
import java.util.List;

public class DepartamentoDAOImplJDBC implements DepartamentoDAO {
    private final Connection connection;

    public DepartamentoDAOImplJDBC(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void insert(Departamento departamento) {
        PreparedStatement preparedStatement = null;

        try {
            String query = "INSERT INTO departamento (Nome) VALUES (?)";

            preparedStatement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, departamento.getNome());

            int linhasAfetadas = preparedStatement.executeUpdate();

            if (linhasAfetadas > 0) {
                ResultSet resultSet = preparedStatement.getGeneratedKeys();

                if (resultSet.next()) {
                    int codDepartamento = resultSet.getInt(1);

                    departamento.setCodDepartamento(codDepartamento);
                }

                DB.closeResultSet(resultSet);
            } else {
                throw new DbException("Erro inesperado. Nenhuma linha afetada");
            }
        } catch (SQLException e) {
            throw new DbException("Ocorreu o seguinte erro: " + e.getMessage());
        } finally {
            DB.closeStatement(preparedStatement);
            DB.closeConnection();
        }
    }

    @Override
    public void update(Departamento departamento) {

    }

    @Override
    public void deleteById(Integer codDepartamento) {
        PreparedStatement preparedStatement = null;

        try {
            String query = "DELETE FROM departamento WHERE CodDepartamento = ?";

            preparedStatement = connection.prepareStatement(query);

            preparedStatement.setInt(1, codDepartamento);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new DbException("Ocorreu o seguinte erro: " + e.getMessage());
        } finally {
            DB.closeStatement(preparedStatement);
            DB.closeConnection();
        }
    }

    @Override
    public Departamento findById(Integer codDepartamento) {
        return null;
    }

    @Override
    public List<Departamento> findAll() {
        return null;
    }
}
