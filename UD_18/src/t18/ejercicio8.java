package t18; // Añadiendo el paquete correcto

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class ejercicio8 {
    
    private Connection conexion;
    private Statement st;
    
    public ejercicio8() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            this.conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306", "root", "");
            this.st = conexion.createStatement();
            System.out.println("Server conectado");
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
        ejercicio8 app = new ejercicio8();
        String db = "grandesalmacenes";
        String tablaCajeros = "cajeros";
        String tablaMaquinas = "maq_registradoras";
        String tablaProductos = "productos";
        String tablaVenta = "venta";
        
        String atributosCajeros = "(" + 
            "  `codigo` int(11) NOT NULL AUTO_INCREMENT," +
            "  `nom_apels` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL," +
            "  PRIMARY KEY (`codigo`)" + 
            ")";
        
        String atributosMaquinas = "(" + 
            "  `codigo` int(11) NOT NULL AUTO_INCREMENT," +
            "  `piso` int(11) DEFAULT NULL," +
            "  PRIMARY KEY (`codigo`)" + 
            ")";
        
        String atributosProductos = "(" + 
            "  `codigo` int(11) NOT NULL AUTO_INCREMENT," + 
            "  `nombre` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL," +
            "  `precio` int(11) DEFAULT NULL," + 
            "  PRIMARY KEY (`codigo`)" + 
            ")";
        
        String atributosVenta = "(" + 
                "  `cod_cajero` int(11) NOT NULL," + 
                "  `cod_maq` int(11) NOT NULL," + 
                "  `cod_producto` int(11) NOT NULL," + 
                "  PRIMARY KEY (`cod_cajero`, `cod_maq`, `cod_producto`)," +
                "  KEY `fk_maquina_venta` (`cod_maq`)," + 
                "  KEY `fk_producto_venta` (`cod_producto`)," +
                "  CONSTRAINT `fk_cajero_venta` FOREIGN KEY (`cod_cajero`) REFERENCES `cajeros` (`codigo`) ON DELETE CASCADE ON UPDATE CASCADE," +
                "  CONSTRAINT `fk_maquina_venta` FOREIGN KEY (`cod_maq`) REFERENCES `maq_registradoras` (`codigo`) ON DELETE CASCADE ON UPDATE CASCADE," +
                "  CONSTRAINT `fk_producto_venta` FOREIGN KEY (`cod_producto`) REFERENCES `productos` (`codigo`) ON DELETE CASCADE ON UPDATE CASCADE" +
                ")";
        
        String datosCajeros = "(10, 'Nacho González'), " +
                              "(11, 'Pablo Fernández'), " +
                              "(12, 'Andy Escudero'), " +
                              "(13, 'David Concha'), " +
                              "(14, 'Nacho Trigueros')";
        
        String datosMaquinas = "(301, '2')," +
                               "(302, '3')," +
                               "(303, '1')," +
                               "(304, '3')," +
                               "(305, '1')";
        
        String datosProductos = "(206, 'riñonera', '10')," +
                                "(207, 'pulsera', '8')," +
                                "(208, 'guantes', '12')," +
                                "(209, 'calentadores', '15')," +
                                "(210, 'calzado', '45')";
       
        String datosVentas = "(201, '10', '301')," +
                "(202, '11', '302')," +
                "(203, '12', '303')," +
                "(204, '13', '33')," +
                "(205, '14', '45')";
        
        app.createDB(db);
//        app.createTable(db, tablaCajeros, atributosCajeros);
        app.insertData(db, tablaCajeros, datosCajeros);
//        app.createTable(db, tablaMaquinas, atributosMaquinas);
        app.insertData(db, tablaMaquinas, datosMaquinas);
//        app.createTable(db, tablaProductos, atributosProductos);
        app.insertData(db, tablaProductos, datosProductos);
//        app.createTable(db, tablaVenta, atributosVenta);
        
       app.insertData(db, tablaVenta, datosVentas);
       app.closeConnection();
    }
}
