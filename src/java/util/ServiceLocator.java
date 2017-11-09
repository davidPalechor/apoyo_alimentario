package util;

import static java.lang.System.out;
import java.sql.Connection;
import java.sql.*;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import negocio.Usuario;

/**
 * Recursos Humanos
 *
 * @author Alba Consuelo Nieto
 */
public class ServiceLocator {

    /**
     * Instancia del ServiceLocator
     */
    private static ServiceLocator instance = null;

    /**
     * Conexion compartida a la Base de Datos
     */
    private Connection conexion = null;

    /**
     * Bandera que indica el estado de la conexion
     */
    private boolean conexionLibre = true;
    
    private String usuario;

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }
    /**
     * @return instancia del ServiceLocator para el manejo de la conexion
     */
    
    /*public static ServiceLocator getInstance(String usuario, String passwd) {

        if (instance == null) {
            try {
                instance = new ServiceLocator(usuario, passwd);

            } catch (Exception e) {
                e.printStackTrace();

            }
        }
        return instance;
    }*/

    private String error;

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }
    public ServiceLocator(String usuario, String passwd) throws Exception {
        
        try {
            this.setError(null);
            this.setUsuario(usuario);
            String url = "jdbc:oracle:thin:@localhost:1521:XE";
            String driver = "oracle.jdbc.OracleDriver";
            Class.forName(driver);
            conexion = DriverManager.getConnection(url, "u_" + usuario, passwd);
            System.err.println("SERVICE LOCATOR: " + usuario);
            conexion.setAutoCommit(false);
        } catch (Exception e) {
            this.setError(e.toString());
        }
    }
    
    public synchronized Connection tomarConexion() {
        System.out.println("SERVICELOCATOR " + conexionLibre);
        while (!conexionLibre) {
            try {
                System.out.println("SERVICELOCATOR" + conexionLibre);
                wait();
            } catch (InterruptedException e) {

                System.out.println("TOMAR CONEXION");
                e.printStackTrace();
            }
        }

        conexionLibre = false;
        notify();
        return conexion;
    }

    /**
     * Libera la conexion de la bases de datos para que ningun otro proceso la
     * pueda utilizar
     */
    public synchronized void liberarConexion() {
        while (conexionLibre) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        conexionLibre = true;
        notify();
    }

    /**
     * Cierra la conexion a la base de datos cuando se termina de ejecutar el
     * programa
     */
    public void close() {
        try {
            conexion.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Realiza los cambios en la base de datos. Con este metodo se asegura que
     * no halla inconsitencias en el modelo relacional de la Base de datos.
     *
     * Se utiliza cuando el procedimiento de insercion es terminado
     * correctamente y se asegura que los datos en el modelo estan bien
     * relacionados.
     */
    public void commit() {
        try {
            conexion.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Deshace los cambios en la base de datos. Con este metodo se asegura que
     * no halla inconsitencias en el modelo relacional de la Base de datos.
     *
     * Se utiliza por lo general cuando se devuelve una Exepcion. Los
     * procedimientos intermedios no deberia quedar almacenados en la base de
     * datos.
     */
    public void rollback() {
        try {
            conexion.rollback();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public String probarExistencia(String usuario, String clave) throws Exception {
        try {
            
            System.out.println("EXISTENCIA: " + usuario + " " + clave);
            this.tomarConexion();
            /*Class.forName("oracle.jdbc.OracleDriver");
            String BaseDeDatos = "jdbc:oracle:thin:@localhost:1521:XE";
            conexion = DriverManager.getConnection(BaseDeDatos, "u_" + usuario, clave);
            conexion.setAutoCommit(false);
            System.out.println("Conectado a la base de datos");
            conexion.close();*/
        } catch (Exception e) {
            return e.toString();
        }
        return null;
    }
}
