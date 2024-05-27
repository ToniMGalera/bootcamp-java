package t18;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class ejercicio6 {

    private Connection conexion;
    private Statement st;

    public ejercicio6() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            this.conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306", "root", "");
            this.st = conexion.createStatement();
            System.out.println("Server conectado ");
        } catch (SQLException | ClassNotFoundException e) {
            System.out.println("No se ha podido conectar con la base de datos.");
            e.printStackTrace();
        }
    }

    public void closeConnection() {
        try {
            this.conexion.close();
            System.out.println("Conexión cerrada.");
        } catch (SQLException e) {
            System.out.println("Error cerrando la conexión con el servidor.");
            e.printStackTrace();
        }
    }

    public void createDB(String name) {
        try {
            String query = "CREATE DATABASE IF NOT EXISTS " + name;
            st.executeUpdate(query);
            System.out.println("Se ha creado la base de datos " + name + " exitosamente.");
        } catch (SQLException e) {
            System.out.println("Error creando la base de datos " + name);
            e.printStackTrace();
        }
    }

    public void createTable(String db, String name, String attributes) {
        try {
            useDB(db);
            String query = "CREATE TABLE IF NOT EXISTS " + name + attributes;
            st.executeUpdate(query);
            System.out.println("Se ha creado la tabla " + name + " exitosamente.");
        } catch (SQLException e) {
            System.out.println("Error creando la tabla " + name);
            e.printStackTrace();
        }
    }

    public void insertData(String db, String table, String values) {
        try {
            useDB(db);
            String query = "INSERT INTO " + table + " VALUES " + values;
            st.executeUpdate(query);
            System.out.println("Se han insertado los datos en la tabla " + table + " exitosamente.");
        } catch (SQLException e) {
            System.out.println("Error insertando datos en la tabla " + table);
            e.printStackTrace();
        }
    }

    private void useDB(String db) {
        try {
            String query = "USE " + db;
            st.executeUpdate(query);
        } catch (SQLException e) {
            System.out.println("Error usando la base de datos " + db);
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        ejercicio6 app = new ejercicio6();
        String db = "Piezas_y_Proveedores";
        String tabla1 = "piezas";
        String tabla2 = "proveedores";
        String tabla3 = "suministra";

        String atributos1 = "(codigo INT NOT NULL AUTO_INCREMENT, nombre VARCHAR(100) NOT NULL, PRIMARY KEY (codigo))";
        String atributos2 = "(codigo INT NOT NULL AUTO_INCREMENT, nombre VARCHAR(100) NOT NULL, precio DECIMAL(10, 2) NOT NULL, PRIMARY KEY (codigo))";
        String atributos3 = "(id INT NOT NULL AUTO_INCREMENT, codigo_pieza INT NOT NULL, id_proveedor INT NOT NULL, precio DECIMAL(10, 2) NOT NULL, PRIMARY KEY (id))";

        String datosPiezas = "(nombre) VALUES " +
                "('pieza1'), " +
                "('pieza2'), " +
                "('pieza3'), " +
                "('pieza4'), " +
                "('pieza5')";

        String datosProveedores = "(nombre, precio) VALUES " +
                "('proveedor1', 10.00), " +
                "('proveedor2', 20.00), " +
                "('proveedor3', 30.00), " +
                "('proveedor4', 40.00), " +
                "('proveedor5', 50.00)";

        String datosSuministra = "(codigo_pieza, id_proveedor, precio) VALUES " +
                "(1, 1, 15.00), " +
                "(2, 2, 25.00), " +
                "(3, 3, 35.00), " +
                "(4, 4, 45.00), " +
                "(5, 5, 55.00)";

        app.createDB(db);
        app.createTable(db, tabla1, atributos1);
        app.insertData(db, tabla1, datosPiezas);
        app.createTable(db, tabla2, atributos2);
        app.insertData(db, tabla2, datosProveedores);
        app.createTable(db, tabla3, atributos3);
        app.insertData(db, tabla3, datosSuministra);
        app.closeConnection();
    }
}
