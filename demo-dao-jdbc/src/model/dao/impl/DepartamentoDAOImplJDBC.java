package model.dao.impl;

import db.DB;
import db.DbException;
import model.dao.DepartamentoDAO;
import model.entidades.Departamento;
import model.entidades.Vendedor;

import java.sql.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
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
        }
    }

    @Override
    public void update(Departamento departamento) {
        PreparedStatement preparedStatement = null;

        try {
            String query = "UPDATE departamento SET Nome = ? WHERE CodDepartamento = ?";
            preparedStatement = connection.prepareStatement(query);

            preparedStatement.setString(1, departamento.getNome());
            preparedStatement.setInt(2, departamento.getCodDepartamento());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new DbException("Ocorreu o seguinte erro: " + e.getMessage());
        } finally {
            DB.closeStatement(preparedStatement);
        }
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
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            String query = "SELECT * FROM departamento WHERE CodDepartamento = ?";
            preparedStatement = connection.prepareStatement(query);

            preparedStatement.setInt(1, codDepartamento);

            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                return instatiateDepartamento(resultSet);
            }

            return null;
        } catch (SQLException e) {
            throw new DbException("Ocorreu o seguinte erro: " + e.getMessage());
        } finally {
            DB.closeStatement(preparedStatement);
            DB.closeResultSet(resultSet);
        }
    }

    private Departamento instatiateDepartamento(ResultSet resultSet) throws SQLException {
        Departamento departamento = new Departamento();
        departamento.setCodDepartamento(resultSet.getInt("CodDepartamento"));
        departamento.setNome(resultSet.getString("Nome"));

        return departamento;
    }

    @Override
    public List<Departamento> findAll() {
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            String query = "SELECT * FROM departamento";

            preparedStatement = connection.prepareStatement(query);

            resultSet = preparedStatement.executeQuery();

            List<Departamento> departamentos = new ArrayList<>();

            while (resultSet.next()) {
                departamentos.add(instatiateDepartamento(resultSet));
            }

            return departamentos;
        } catch (SQLException e) {
            throw new DbException("Ocorreu o seguinte erro: " + e.getMessage());
        } finally {
            DB.closeStatement(preparedStatement);
            DB.closeResultSet(resultSet);
        }
    }
}
