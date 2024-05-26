package t18;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class ejercicio4 {
    
    private static final String URL = "jdbc:mysql://localhost:3306/";
    private static final String USUARIO = "root";
    private static final String CONTRASEÑA = "";
    private Connection conexion;

    public ejercicio4() {
        try {
            this.conexion = DriverManager.getConnection(URL, USUARIO, CONTRASEÑA);
            System.out.println("Conexión establecida");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void createDB(String dbName) {
        try (Connection connection = DriverManager.getConnection(URL, USUARIO, CONTRASEÑA)) {
            createDBInternal(connection, dbName);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void createTable(String dbName, String tableName, String attributes) {
        try (Connection connection = DriverManager.getConnection(URL + dbName, USUARIO, CONTRASEÑA)) {
            createTableInternal(connection, tableName, attributes);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void insertData(String dbName, String tableName, String values) {
        try (Connection connection = DriverManager.getConnection(URL + dbName, USUARIO, CONTRASEÑA)) {
            insertDataInternal(connection, tableName, values);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void closeConnection() {
        if (conexion != null) {
            try {
                conexion.close();
                System.out.println("Conexión cerrada.");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    private void createDBInternal(Connection connection, String dbName) throws SQLException {
        try (Statement statement = connection.createStatement()) {
            statement.executeUpdate("CREATE DATABASE IF NOT EXISTS " + dbName);
            System.out.println("Base de datos creada o ya existe: " + dbName);
        }
    }

    private void createTableInternal(Connection connection, String tableName, String attributes) throws SQLException {
        try (Statement statement = connection.createStatement()) {
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS " + tableName + " " + attributes);
            System.out.println("Tabla creada o ya existe: " + tableName);
        }
    }

    private void insertDataInternal(Connection connection, String tableName, String values) throws SQLException {
        try (Statement statement = connection.createStatement()) {
            statement.executeUpdate("INSERT INTO " + tableName + " " + values);
            System.out.println("Datos insertados en la tabla: " + tableName);
        }
    }

    public static void main(String[] args) {
        ejercicio4 app = new ejercicio4();
        String db = "pelisalas";
        String tabla1 = "peliculas";
        String tabla2 = "salas";

        // Esquema para la tabla peliculas
        String atributos1 = "("
                + "  `codigo` int(11) NOT NULL AUTO_INCREMENT,"
                + "  `nombre` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,"
                + "  `calificacion_edad` int(11) DEFAULT NULL,"
                + "  PRIMARY KEY (`codigo`)"
                + ")";

        // Esquema para la tabla salas
        String atributos2 = "("
                + "  `codigo` int(11) NOT NULL AUTO_INCREMENT,"
                + "  `nombre` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,"
                + "  `pelicula` int(11) DEFAULT NULL,"
                + "  PRIMARY KEY (`codigo`),"
                + "  KEY `fk_salas_peliculas` (`pelicula`),"
                + "  CONSTRAINT `fk_salas_peliculas` FOREIGN KEY (`pelicula`) REFERENCES `peliculas` (`codigo`) ON DELETE CASCADE ON UPDATE CASCADE"
                + ")";

        // Valores para la tabla peliculas
        String values1 = "(`codigo`, `nombre`, `calificacion_edad`) VALUES"
                + "  (112, 'Snatch: Cerdos y Diamantes', 18),"
                + "  (113, 'Batman', 12),"
                + "  (114, 'Mad Max', 16),"
                + "  (115, 'Beetlejuice', 8),"
                + "  (116, 'Joker', 16)";

        // Valores para la tabla salas
        String values2 = "(`codigo`, `nombre`, `pelicula`) VALUES"
                + "  (8, 'Sala 8', 107),"
                + "  (9, 'Sala 9', 108),"
                + "  (10, 'Sala 10', 109),"
                + "  (11, 'Sala 11', 111),"
                + "  (12, 'Sala 12', 112)";

        app.createDB(db);
        app.createTable(db, tabla1, atributos1);
        app.insertData(db, tabla1, values1);
        app.createTable(db, tabla2, atributos2);
        app.insertData(db, tabla2, values2);
        app.closeConnection();
    }
}

