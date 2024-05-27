package t18;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class ejercicio7 {

    private Connection conexion;
    private Statement st;

    public ejercicio7() {
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
        ejercicio7 app = new ejercicio7();
        String db = "cientificos";
        String tabla1 = "asignado_a";
        String tabla2 = "cientificos";
        String tabla3 = "proyecto";

        String atributos1 = "(Id INT NOT NULL AUTO_INCREMENT, Cientifico VARCHAR(100) NOT NULL, Proyecto VARCHAR(100) NOT NULL, PRIMARY KEY (Id))";
        String atributos2 = "(DNI VARCHAR(8) NOT NULL, NomApels VARCHAR(255) NOT NULL, PRIMARY KEY (DNI))";
        String atributos3 = "(Proyecto VARCHAR(100) NOT NULL, Nombre VARCHAR(100) NOT NULL, Horas INT NOT NULL, PRIMARY KEY (Proyecto))";

        String datosAsignado = "('11', '000000001', 'K121'), " +
                "('12', '000000002', 'L122'), " +
                "('13', '000000003', 'M123'), " +
                "('14', '000000004', 'N124'), " +
                "('15', '000000005', 'O125')";

        String datosCientificos = "('12345678A', 'Cientifico diez'), " +
                "('23456789B', 'Cientifico once'), " +
                "('34567890C', 'Cientifico doce'), " +
                "('45678901D', 'Cientifico trece'), " +
                "('56789012E', 'Cientifico catorce')";

        String datosProyecto = "('K121', 'Proyecto diez', 100), " +
                "('L122', 'Proyecto once', 200), " +
                "('M123', 'Proyecto doce', 150), " +
                "('N124', 'Proyecto trece', 300), " +
                "('O125', 'Proyecto catorce', 250)";

//        app.createDB(db);
//        app.createTable(db, tabla1, atributos1);
        app.insertData(db, tabla1, datosAsignado);
//        app.createTable(db, tabla2, atributos2);
        app.insertData(db, tabla2, datosCientificos);
//        app.createTable(db, tabla3, atributos3);
        app.insertData(db, tabla3, datosProyecto);
        app.closeConnection();
    }
}
