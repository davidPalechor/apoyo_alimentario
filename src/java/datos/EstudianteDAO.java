package datos;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import negocio.Usuario;
import util.RHException;
import util.ServiceLocator;

public class EstudianteDAO {

    public EstudianteDAO() {
    }

    public String consultarEstado(Usuario usuario) throws Exception{
        System.out.println("CONSULTAR ESTADO");
        String respuesta = null;
        ServiceLocator sl = new ServiceLocator("principal", "u_principal");
        try {
            String strSQL = "SELECT I_estadoEstudiante FROM student where q_codigoEstudiante = ?";
            System.out.println(usuario.getUsuario());
            Connection conn = sl.tomarConexion();
            PreparedStatement st = conn.prepareStatement(strSQL);
            st.setInt(1, Integer.parseInt(usuario.getUsuario()));

            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                respuesta = rs.getString(1);
                //System.out.println(respuesta);
            } else {
                System.out.println("NO HAY ESTUDIANTE");
            }

        } catch (Exception e) {

            System.out.println(e.toString());
            respuesta = e.toString();
        } finally {
            sl.liberarConexion();
        }
        return respuesta;
    }

    public String crearUsuario(Usuario usuario) throws Exception {
        ServiceLocator sl = new ServiceLocator("principal", "u_principal");
        try {
            String strSQL = "CREATE USER u_" + usuario.getUsuario() + " IDENTIFIED BY " + usuario.getPasswd() + " default tablespace dba_apoyo_def temporary tablespace dba_apoyo_tmp quota 2m on dba_apoyo_def";

            Connection conexion = sl.tomarConexion();
            Statement prepStmt = conexion.createStatement();
            prepStmt.execute(strSQL);
            System.out.println(strSQL);
            prepStmt.close();
            sl.commit();

            strSQL = "GRANT connect, r_estudiante TO u_" + usuario.getUsuario() + "";
            prepStmt = conexion.createStatement();
            prepStmt.execute(strSQL);
            prepStmt.close();
            sl.commit();

            System.out.println("Usuario Creado");
            return null;
        } catch (SQLException e) {
            return e.toString();
        } finally {
            sl.liberarConexion();
        }
    }

    public String consultarCedulaEstudiante(String cod) throws Exception {
        ServiceLocator sl = new ServiceLocator("principal", "u_principal");
        String resultado = null;
        try {
            String sql = "SELECT k_cedulaestudiante from student where q_codigoestudiante =?";
            Connection conexion = sl.tomarConexion();
            
            PreparedStatement prepStmt = conexion.prepareStatement(sql);
            prepStmt.setString(1, cod);
            prepStmt.execute(sql);
            System.out.println(sql);
            prepStmt.close();
            sl.commit();
        } catch (Exception e) {
            resultado = e.toString();
        } finally {
            sl.liberarConexion();
        }
        return resultado;
    }
}
