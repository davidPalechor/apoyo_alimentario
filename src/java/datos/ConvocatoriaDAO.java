
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;

import java.sql.CallableStatement;
import util.RHException;
import negocio.Usuario;
import negocio.Convocatoria;
import util.ServiceLocator;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;

/**
 *
 * @author laura
 */
public class ConvocatoriaDAO {

    public String crearConvocatoria(Convocatoria convocatoria, Usuario usuario) throws RHException, Exception {
        String resultado = null;
        ServiceLocator sl = new ServiceLocator(usuario.getUsuario(), usuario.getPasswd());
        try {

            String strSQL = "INSERT INTO summons VALUES(?,?,to_date(?,'yyyy-mm-dd'),to_date(?,'yyyy-mm-dd'),'abierta')";
            System.out.println("PASSWD " + usuario.getPasswd());
            System.out.println("USUARIO ACTUAL " + usuario.getUsuario());

            //Connection conexion = ServiceLocator.getInstance(usuario.getUsuario(), usuario.getPasswd()).tomarConexion();
            Connection conexion = sl.tomarConexion();

            PreparedStatement prepStmt = conexion.prepareStatement(strSQL);
            prepStmt.setString(1, convocatoria.getAnioConvocatoria());
            prepStmt.setString(2, convocatoria.getPeriodoConvocatoria());
            prepStmt.setString(3, convocatoria.getfInicio());
            prepStmt.setString(4, convocatoria.getfFin());

            prepStmt.executeUpdate();
            prepStmt.close();
            sl.commit();

            System.out.println("Convocatoria Creada");

        } catch (SQLException e) {
            System.out.println("CONVOCATORIA" + e);
            return resultado = e.toString();
        } finally {
            sl.liberarConexion();
        }
        return resultado;
    }

    public Convocatoria consultarConvocatoria(Convocatoria convocatoria, Usuario usuario) throws RHException, Exception {
        Convocatoria convocatoriaResultado = null;
        ServiceLocator sl = new ServiceLocator(usuario.getUsuario(), usuario.getPasswd());
        try {

            String strSQL = "SELECT to_char(f_inicio,'dd/month/yyyy'), to_char(f_fin,'dd/month/yyyy') FROM summons WHERE K_ANIOCONV=? AND K_PERIODOCONV=?";
            Connection conexion = sl.tomarConexion();
            PreparedStatement prepStmt = conexion.prepareStatement(strSQL);
            prepStmt.setString(1, convocatoria.getAnioConvocatoria());
            prepStmt.setString(2, convocatoria.getPeriodoConvocatoria());
            ResultSet rs = prepStmt.executeQuery();

            while (rs.next()) {
                convocatoriaResultado = (new Convocatoria(convocatoria.getAnioConvocatoria(), convocatoria.getPeriodoConvocatoria(), rs.getString(1), rs.getString(2)));
            }
        } catch (SQLException e) {
            throw new RHException("ConvocatoriaDAO", "No pudo traer convocatoria " + e.getMessage());
        } finally {
            sl.liberarConexion();
        }
        return convocatoriaResultado;
    }
    
    public String cambiarEstadoConvocatoria(Usuario usuario) throws RHException, Exception{
        ServiceLocator sl = new ServiceLocator(usuario.getUsuario(), usuario.getPasswd());
        String mensaje ="";
        try{
            Connection conexion = sl.tomarConexion();
            CallableStatement cs = null;
            cs = conexion.prepareCall("{? = call u_apoyo.pk_solicitudes.fu_cambiar_estado_convocatoria()}");
            cs.registerOutParameter(1, oracle.jdbc.OracleTypes.INTEGER);
            cs.execute();
            sl.commit();
            int retorno = cs.getInt(1);
            if (retorno == 1){
                mensaje = "verdadero";
            } else{
                mensaje = "falso";
            }
            
        } catch(SQLException e){
            System.out.println("CONVOCATORIA " + e);
            mensaje = e.toString();
        }finally{
            sl.liberarConexion();
        }
        return mensaje;
    } 

}
