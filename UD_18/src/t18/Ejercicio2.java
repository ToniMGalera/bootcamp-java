package t18;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Ejercicio2 {

    private static final String URL = "jdbc:mysql://localhost:3306/";
    private static final String USUARIO = "root";
    private static final String CONTRASEÑA = "";
    private Connection conexion;

    public Ejercicio2() {
        try {
            this.conexion = DriverManager.getConnection(URL, USUARIO, CONTRASEÑA);
            System.out.println("Conexion establecida");
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
        Ejercicio2 app = new Ejercicio2();
        String db = "empleados";
        String tabla1 = "departamentos";
        String tabla2 = "empleados";

     // Esquema corregido para la tabla departamentos
//        String atributos1 = "("
//                + "  `codigo` int(11) NOT NULL AUTO_INCREMENT,"
//                + "  `nombre` varchar(100) DEFAULT NULL,"
//                + "  `presupuesto` int(11) DEFAULT NULL,"
//                + "  PRIMARY KEY (`codigo`)"
//                + ")";
//
//        // Esquema corregido para la tabla empleados
//        String atributos2 = "("
//                + "  `dni` varchar(8) NOT NULL,"
//                + "  `nombre` varchar(100) DEFAULT NULL,"
//                + "  `apellidos` varchar(255) DEFAULT NULL,"
//                + "  `departamento` int(11) DEFAULT NULL,"
//                + "  PRIMARY KEY (`dni`),"
//                + "  KEY `FK_empleados_departamentos` (`departamento`),"
//                + "  CONSTRAINT `FK_empleados_departamentos` FOREIGN KEY (`departamento`) REFERENCES `departamentos` (`codigo`) ON DELETE CASCADE ON UPDATE CASCADE"
//                + ")";


        String valores1 = "(`cod_departamento`, `nombre`, `presupuesto`) VALUES"
                + "(12, 'Innovación', 20000),"
                + "(13, 'Atención al Cliente', 14000),"
                + "(14, 'Tecnología de la Información', 17500),"
                + "(15, 'Legal', 15000),"
                + "(16, 'Compras', 13000);";

        String valores2 = "(`dni`, `nombre`, `apellidos`, `cod_departamento`) VALUES"
                + "('01234567', 'Elena', 'Díaz', 10),"
                + "('11223344', 'Alejandro', 'Hernández', 1),"
                + "('12345678', 'Juan', 'Pérez', 1),"
                + "('22334455', 'Patricia', 'Santos', 2),"
                + "('23456789', 'María', 'García', 2),"
                + "('33445566', 'Javier', 'Vargas', 3),"
                + "('34567890', 'Carlos', 'López', 3),"
                + "('44556677', 'Isabel', 'Fuentes', 4),"
                + "('45678901', 'Laura', 'Martínez', 4),"
                + "('55667788', 'Daniel', 'Moreno', 5),"
                + "('56789012', 'Pedro', 'Sánchez', 5),"
                + "('67890123', 'Ana', 'Rodríguez', 6),"
                + "('78901234', 'David', 'Fernández', 7),"
                + "('89012345', 'Sofía', 'Ruiz', 8),"
                + "('89267109', 'Esther', 'Vázquez', 11),"
                + "('90123456', 'Luis', 'Gómez', 4);";

        // Crear base de datos
//        app.crearBD(db);
        // Crear tabla departamentos e insertar datos
//        app.crearTabla(db, tabla1, atributos1);
        app.insertarDatos(db, tabla1, valores1);
        // Crear tabla empleados e insertar datos
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

