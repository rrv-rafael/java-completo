package services;

import application.App;
import db.DB;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Formatter;
import java.util.Queue;
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

    public static void inserirDados(String nome, String email, LocalDate dataNascimento, double salariobase, int codDepartamento) {
        try {
            Connection connection = DB.getConnection();
            String query = "INSERT INTO vendedor (Nome, Email, DataNascimento, SalarioBase, CodDepartamento)" +
                           "VALUES (?, ?, ?, ?, ?)";

            preparedStatement = connection.prepareStatement(query);

            preparedStatement.setString(1, nome);
            preparedStatement.setString(2, email);
            preparedStatement.setObject(3, dataNascimento);
            preparedStatement.setDouble(4, salariobase);
            preparedStatement.setInt(5, codDepartamento);

            int linhasAfetadas = preparedStatement.executeUpdate();

            System.out.println("Pronto! Linhas afetadas: " + linhasAfetadas);
        } catch (SQLException e) {
            logger.severe("Ocorreu o seguinte erro: " + e.getMessage());
        } finally {
            DB.closeStatement(preparedStatement);
            DB.closeConnection();
        }
    }
}
