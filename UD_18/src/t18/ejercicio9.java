package t18;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class ejercicio9 {
    private static final String CONTRASEÑA = null;
	private static final String URL = null;
	private static final String USUARIO = null;
	private Connection conexion;
    private Statement st;

    public ejercicio9() {
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

    private void createDB(Connection connection, String nombreBD) {
		// TODO Auto-generated method stub
		
	}

	public void crearTabla(String nombreBD, String nombreTabla, String atributos) {
        try (Connection connection = DriverManager.getConnection(URL + nombreBD, USUARIO, CONTRASEÑA)) {
            createTable(connection, nombreTabla, atributos);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void createTable(Connection connection, String nombreTabla, String atributos) {
		// TODO Auto-generated method stub
		
	}

	public void insertarDatos(String nombreBD, String nombreTabla, String valores) {
        try (Connection connection = DriverManager.getConnection(URL + nombreBD, USUARIO, CONTRASEÑA)) {
            insertData(connection, nombreTabla, valores);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void insertData(Connection connection, String nombreTabla, String valores) {
		// TODO Auto-generated method stub
		
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
        ejercicio9 c = new ejercicio9();
        String db = "investigadores";
        String tabla1 = "equipos", tabla2 = "facultad", tabla3 = "investigadores", tabla4 = "reserva";

        String values1 = "('K111', 'FACULTAD EXTRA0', '11')," +
                "('L112', 'FACULTAD EXTRA1', '12')," +
                "('M113', 'FACULTAD EXTRA2', '13')," +
                "('N114', 'FACULTAD EXTRA 3', '14')," +
                "('O115', 'FACULTAD EXTRA 4', '15')";

        String values2 = "('11', 'extra1')," +
                "('12', 'extra2')," +
                "('13', 'extra3')," +
                "('14', 'extra4')," +
                "('15', 'extra5')";

        String values3 = "('1213435P', 'NIÑOEXTRA1', '11')," +
                "('3557676I', 'NIÑOEXTRA2', '12')," +
                "('6724422E', 'NIÑOEXTRA3', '13')," +
                "('345213R', 'NIÑOEXTRA4', '14')," +
                "('8887612W', 'NIÑOEXTRA5', '15')";

        String values4 = "('1213435P', 'K111', '2024-04-16 00:00:00', '2024-04-26 00:00:00')," +
                "('3557676I', 'L112', '2024-04-16 00:00:00', '2024-04-26 00:00:00')," +
                "('6724422E', 'M113', '2024-04-16 00:00:00', '2024-04-26 00:00:00')," +
                "('345213R', 'N114', '2024-04-16 00:00:00', '2024-04-26 00:00:00')," +
                "('8887612W', 'O115', '2024-04-16 00:00:00', '2024-04-26 00:00:00')";

        c.crearBD(db);

//            c.crearTabla(db, tabla1, atributos1);
        c.insertarDatos(db, tabla1, values1);

//            c.crearTabla(db, tabla2, atributos2);
        c.insertarDatos(db, tabla2, values2);

//            c.crearTabla(db, tabla3, atributos3);
        c.insertarDatos(db, tabla3, values3);

//            c.crearTabla(db, tabla4, atributos4);
        c.insertarDatos(db, tabla4, values4);

        c.cerrarConexion();
    }}