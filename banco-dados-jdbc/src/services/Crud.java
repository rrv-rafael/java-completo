package services;

import application.App;
import db.DB;
import db.DbIntegrityException;

import java.sql.*;
import java.time.LocalDate;
import java.util.logging.Logger;

public class Crud {
    private static final Logger logger = Logger.getLogger(App.class.getName());
    private static Statement statement = null;
    private static PreparedStatement preparedStatement = null;
    private static ResultSet resultSet = null;

    public static void buscarDados() {
        try {
            Connection connection = DB.getConnection();
            statement = connection.createStatement();

            resultSet = statement.executeQuery("SELECT * FROM departamento");

            while (resultSet.next()) {
                System.out.println(resultSet.getInt("CodDepartamento") + " - " + resultSet.getString("Nome"));
            }
        } catch (SQLException e) {
            logger.severe("Ocorreu o seguinte erro: " + e.getMessage());
        } finally {
            DB.closeResultSet(resultSet);
            DB.closeStatement(statement);
            DB.closeConnection();
        }
    }

    public static void inserirVendedor(String nome, String email, LocalDate dataNascimento, double salariobase, int codDepartamento) {
        try {
            Connection connection = DB.getConnection();
            String query = "INSERT INTO vendedor (Nome, Email, DataNascimento, SalarioBase, CodDepartamento)" +
                           "VALUES (?, ?, ?, ?, ?)";

            preparedStatement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);

            preparedStatement.setString(1, nome);
            preparedStatement.setString(2, email);
            preparedStatement.setObject(3, dataNascimento);
            preparedStatement.setDouble(4, salariobase);
            preparedStatement.setInt(5, codDepartamento);

            int linhasAfetadas = preparedStatement.executeUpdate();

            if (linhasAfetadas > 0) {
                resultSet = preparedStatement.getGeneratedKeys();
                while (resultSet.next()) {
                    int codVendedor = resultSet.getInt(1);
                    System.out.println("Pronto! CodVendedor: " + codVendedor);
                }
            } else {
                System.out.println("Nenhuma linha alterada!");
            }
        } catch (SQLException e) {
            logger.severe("Ocorreu o seguinte erro: " + e.getMessage());
        } finally {
            DB.closeResultSet(resultSet);
            DB.closeStatement(preparedStatement);
            DB.closeConnection();
        }
    }

    public static void atualizarDados(double aumentoSalarial, int codVendedor) {
        try {
            Connection connection = DB.getConnection();
            String query = "UPDATE vendedor SET SalarioBase = SalarioBase + ? WHERE CodVendedor = ?";
            preparedStatement = connection.prepareStatement(query);

            preparedStatement.setDouble(1, aumentoSalarial);
            preparedStatement.setInt(2, codVendedor);

            int linhasAfetadas = preparedStatement.executeUpdate();
            System.out.println("Pronto! Linhas afetadas: " + linhasAfetadas);
        } catch (SQLException e) {
            logger.severe("Ocorreu o seguinte erro: " + e.getMessage());
        } finally {
            DB.closeStatement(preparedStatement);
            DB.closeConnection();
        }
    }

    public static void deletarDados(int codDepartamento) {
        try {
            Connection connection = DB.getConnection();
            String query = "DELETE FROM departamento WHERE CodDepartamento = ?";

            preparedStatement = connection.prepareStatement(query);

            preparedStatement.setInt(1, codDepartamento);

            int linhasAfetadas = preparedStatement.executeUpdate();
            System.out.println("Pronto! Linhas afetadas: " + linhasAfetadas);
        } catch (SQLException e) {
            throw new DbIntegrityException(e.getMessage());
        } finally {
            DB.closeStatement(preparedStatement);
            DB.closeConnection();
        }
    }
}
