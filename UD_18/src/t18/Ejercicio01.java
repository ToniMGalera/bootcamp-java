package t18;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Ejercicio01 {

    private static final String URL = "jdbc:mysql://localhost:3306/";
    private static final String USER = "root";
    private static final String PASSWORD = "";

    public static void main(String[] args) {
        String dbName = "tiendainformatica";
        String tabla1 = "articulos";
        String tabla2 = "fabricantes";

        String values1 = "(`cod_articulos`, `nombre`, `precio`, `cod_fabricantes`) VALUES" +
                "(1, 'a1', 9, 1)," +
                "(2, 'a2', 18, 2)," +
                "(3, 'a3', 27, 3)," +
                "(4, 'a4', 36, 4)," +
                "(5, 'a5', 45, 5)," +
                "(6, 'a6', 54, 6)," +
                "(7, 'a7', 63, 7)," +
                "(8, 'Impresora Laser', 72, 8)," +
                "(9, 'a9', 81, 9)," +
                "(10, 'a10', 90, 10)," +
                "(11, 'a11', 170, 3)," +
                "(12, 'Altavoz', 63, 2);";
        
        String values2 = "(`cod_fabricantes`, `nombre`) VALUES" +
        		"(11, 'f1')," +
                "(12, 'f2')," +
                "(13, 'f3')," +
                "(14, 'f4')," +
                "(15, 'f5')," +
                "(16, 'f6')," +
                "(17, 'f7')," +
                "(18, 'f8')," +
                "(19, 'f9')," +
                "(20, 'f10');";

      

        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)) {
//            createDB(connection, dbName);
//            createTable(connection, dbName, tabla2, atributos2);
            insertData(connection, dbName, tabla2, values2);
//            createTable(connection, dbName, tabla1, atributos1);
            insertData(connection, dbName, tabla1, values1);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void createDB(Connection connection, String dbName) throws SQLException {
        try (Statement statement = connection.createStatement()) {
            statement.executeUpdate("CREATE DATABASE IF NOT EXISTS " + dbName);
            System.out.println("Database created or already exists: " + dbName);
        }
    }

    private static void createTable(Connection connection, String dbName, String tableName, String attributes) throws SQLException {
        try (Statement statement = connection.createStatement()) {
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS " + dbName + "." + tableName + " " + attributes);
            System.out.println("Table created or already exists: " + tableName);
        }
    }

    private static void insertData(Connection connection, String dbName, String tableName, String values) throws SQLException {
        try (Statement statement = connection.createStatement()) {
            statement.executeUpdate("INSERT INTO " + dbName + "." + tableName + " " + values);
            System.out.println("Data inserted into table: " + tableName);
        }
    }
}
