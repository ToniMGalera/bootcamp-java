package t18;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class ejercicio5 {

    private static final String URL = "jdbc:mysql://localhost:3306/";
    private static final String USUARIO = "root";
    private static final String CONTRASEÑA = "";
    private Connection conexion;

    public ejercicio5() {
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

    public void clearTable(String dbName, String tableName) {
        try (Connection connection = DriverManager.getConnection(URL + dbName, USUARIO, CONTRASEÑA)) {
            disableForeignKeyChecks(connection);
            clearTableInternal(connection, tableName);
            enableForeignKeyChecks(connection);
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

    private void clearTableInternal(Connection connection, String tableName) throws SQLException {
        try (Statement statement = connection.createStatement()) {
            statement.executeUpdate("DELETE FROM " + tableName);
            System.out.println("Datos eliminados de la tabla: " + tableName);
        }
    }

    private void disableForeignKeyChecks(Connection connection) throws SQLException {
        try (Statement statement = connection.createStatement()) {
            statement.executeUpdate("SET FOREIGN_KEY_CHECKS = 0");
        }
    }

    private void enableForeignKeyChecks(Connection connection) throws SQLException {
        try (Statement statement = connection.createStatement()) {
            statement.executeUpdate("SET FOREIGN_KEY_CHECKS = 1");
        }
    }

    public static void main(String[] args) {
        ejercicio5 app = new ejercicio5();
        String db = "directores";
        String tabla1 = "despachos";
        String tabla2 = "directores";

        // Esquema para la tabla despachos
        String atributos1 = "("
                + "  `numero` int(11) NOT NULL,"
                + "  `capacidad` int(11) DEFAULT NULL,"
                + "  PRIMARY KEY (`numero`)"
                + ")";

        // Esquema para la tabla directores
        String atributos2 = "("
                + "  `dni` varchar(8) NOT NULL,"
                + "  `nom_apels` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,"
                + "  `dni_jefe` varchar(8) DEFAULT NULL,"
                + "  `despacho` int(11) DEFAULT NULL,"
                + "  PRIMARY KEY (`dni`),"
                + "  KEY `fk_despachos_directores` (`despacho`),"
                + "  KEY `fk_directores_directores` (`dni_jefe`),"
                + "  CONSTRAINT `fk_despachos_directores` FOREIGN KEY (`despacho`) REFERENCES `despachos` (`numero`) ON DELETE CASCADE ON UPDATE CASCADE,"
                + "  CONSTRAINT `fk_directores_directores` FOREIGN KEY (`dni_jefe`) REFERENCES `directores` (`dni`) ON DELETE CASCADE ON UPDATE CASCADE"
                + ")";

        // Valores para la tabla despachos
        String values1 = "(`numero`, `capacidad`) VALUES"
                + "  (1, 10),"
                + "  (2, 20),"
                + "  (3, 30),"
                + "  (4, 40),"
                + "  (5, 50),"
                + "  (6, 60),"
                + "  (7, 70),"
                + "  (8, 80),"
                + "  (9, 90),"
                + "  (10, 100)";

        // Valores para la tabla directores
        String values2 = "(`DNI`, `NomApels`, `DNIJefe`, `Despacho`) VALUES"
                + "  ('0672523P', 'francisco', NULL, 9),"
                + "  ('0827137K', 'pedro', NULL, 2),"
                + "  ('3287390R', 'maria', NULL, 1),"
                + "  ('3374683Z', 'javier', NULL, 6),"
                + "  ('5478699Y', 'carlos', NULL, 4),"
                + "  ('7305597S', 'montse', NULL, 5),"
                + "  ('7357072Y', 'rosa', '5478699Y', 4),"
                + "  ('7869261K', 'juan', NULL, 3),"
                + "  ('7845859G', 'cristina', '7869261K', 3),"
                + "  ('9861511N', 'ana', '0672523P', 9)";

//        app.createDB(db);
//        app.createTable(db, tabla1, atributos1);
        app.clearTable(db, tabla1);
        app.insertData(db, tabla1, values1);
//        app.createTable(db, tabla2, atributos2);
        app.clearTable(db, tabla2);
        app.insertData(db, tabla2, values2);
        app.closeConnection();
    }
}
