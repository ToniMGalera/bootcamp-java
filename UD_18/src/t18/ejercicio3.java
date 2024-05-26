package t18;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class ejercicio3 {

    private static final String URL = "jdbc:mysql://localhost:3306/";
    private static final String USUARIO = "root";
    private static final String CONTRASEÑA = "";
    private Connection conexion;

    public ejercicio3() {
        try {
            this.conexion = DriverManager.getConnection(URL, USUARIO, CONTRASEÑA);
            System.out.println("Conexión establecida");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void crearBD(String nombreBD) {
        try (Connection connection = DriverManager.getConnection(URL, USUARIO, CONTRASEÑA)) {
            createDB(connection, nombreBD);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void crearTabla(String nombreBD, String nombreTabla, String atributos) {
        try (Connection connection = DriverManager.getConnection(URL + nombreBD, USUARIO, CONTRASEÑA)) {
            createTable(connection, nombreTabla, atributos);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void insertarDatos(String nombreBD, String nombreTabla, String valores) {
        try (Connection connection = DriverManager.getConnection(URL + nombreBD, USUARIO, CONTRASEÑA)) {
            insertData(connection, nombreTabla, valores);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void cerrarConexion() {
        if (conexion != null) {
            try {
                conexion.close();
                System.out.println("Conexión cerrada.");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        ejercicio3 app = new ejercicio3();
        String db = "almacenes";
        String tabla1 = "almacenes";
        String tabla2 = "cajas";

//        // Esquema para la tabla almacenes
//        String atributos1 = "("
//                + "  `codigo` int(11) NOT NULL AUTO_INCREMENT,"
//                + "  `lugar` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,"
//                + "  `capacidad` int(11) DEFAULT NULL,"
//                + "  PRIMARY KEY (`codigo`)"
//                + ")";
//
//        // Esquema para la tabla cajas
//        String atributos2 = "("
//                + "  `num_referencia` char(5) NOT NULL,"
//                + "  `contenido` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,"
//                + "  `valor` int(11) DEFAULT NULL,"
//                + "  `almacen` int(11) DEFAULT NULL,"
//                + "  PRIMARY KEY (`num_referencia`),"
//                + "  KEY `fk_cajas_almacenes` (`almacen`),"
//                + "  CONSTRAINT `fk_cajas_almacenes` FOREIGN KEY (`almacen`) REFERENCES `almacenes` (`codigo`) ON DELETE CASCADE ON UPDATE CASCADE"
//                + ")";

        // Valores para la tabla almacenes
        String valores1 = "(`codigo`,`nombre`, `lugar`, `capacidad`) VALUES"
        		  + "(13, 'Almacén M', 'Madrid', 1500),"
                  + "(14, 'Almacén N', 'Sevilla', 1200),"
                  + "(15, 'Almacén O', 'Zaragoza', 950),"
                  + "(16, 'Almacén P', 'Málaga', 700),"
                  + "(17, 'Almacén Q', 'Murcia', 600);";

        // Valores para la tabla cajas
        String valores2 = "(`num_referencia`, `contenido`, `valor`, `almacen`) VALUES"
        		   + "('Al11', 'Juguetes', 300, 11),"
                   + "('Al12', 'Herramientas', 500, 12),"
                   + "('Al13', 'Muebles', 1200, 13),"
                   + "('Al14', 'Electrodomésticos', 800, 14),"
                   + "('Al15', 'Material de oficina', 150, 15);";

        // Crear base de datos
//        app.crearBD(db);
        // Crear tabla almacenes e insertar datos
//        app.crearTabla(db, tabla1, atributos1);
        app.insertarDatos(db, tabla1, valores1);
        // Crear tabla cajas e insertar datos
//        app.crearTabla(db, tabla2, atributos2);
        app.insertarDatos(db, tabla2, valores2);
        // Cerrar la conexión
        app.cerrarConexion();
    }

    private static void createDB(Connection connection, String dbName) throws SQLException {
        try (Statement statement = connection.createStatement()) {
            statement.executeUpdate("CREATE DATABASE IF NOT EXISTS " + dbName);
            System.out.println("Base de datos creada o ya existe: " + dbName);
        }
    }

    private static void createTable(Connection connection, String tableName, String attributes) throws SQLException {
        try (Statement statement = connection.createStatement()) {
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS " + tableName + " " + attributes);
            System.out.println("Tabla creada o ya existe: " + tableName);
        }
    }

    private static void insertData(Connection connection, String tableName, String values) throws SQLException {
        try (Statement statement = connection.createStatement()) {
            statement.executeUpdate("INSERT INTO " + tableName + " " + values);
            System.out.println("Datos insertados en la tabla: " + tableName);
        }
    }
}
