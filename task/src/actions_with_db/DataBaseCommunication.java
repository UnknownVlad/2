package actions_with_db;

import java.sql.*;
import java.util.List;

public class DataBaseCommunication {
    public static final String USER_NAME = "postgres";
    public static final String PASSWORD = "vlad";
    public static final String URL = "jdbc:postgresql://localhost:5432/postgres";
    public static final String DRIVER = "org.postgresql.Driver";


    public static Connection getDBConnection() {
        Connection connection = null;
        try {
            Class.forName(DRIVER);
            connection = DriverManager.getConnection(URL, USER_NAME, PASSWORD);
            System.out.println("Соединение с СУБД выполнено.");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            System.out.println("JDBC драйвер для СУБД не найден!");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Ошибка SQL !");
        }
        return connection;
    }

    public static void createTabel(String request, Connection connection) throws SQLException {
        Statement statement = null;
        try {
            statement = connection.createStatement();
            statement.execute(request);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void deleteTabel(String request, Connection connection){
        Statement statement = null;
        try {
            statement = connection.createStatement();
            statement.execute(request);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }
    public static void executeUpdate(String request, Connection connection) throws SQLException {
        connection.createStatement().executeUpdate(request);
    }
    public static ResultSet executeUpdateQuaery(String request, Connection connection) throws SQLException {
        return connection.createStatement().executeQuery(request);
    }
    public static void insertListToDataBase(List<String> insertRequests, Connection connection) throws SQLException {
        Statement statement = connection.createStatement();
        for (String a: insertRequests) {
            statement.executeUpdate(a);
        }
    }
    public static ResultSet getResultSet(String request, Connection connection) throws SQLException {
        return connection.createStatement().executeQuery(request);
    }

}
