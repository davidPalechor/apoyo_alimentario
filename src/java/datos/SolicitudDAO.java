/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import negocio.Convocatoria;
import negocio.Solicitud;
import negocio.Usuario;
import util.ServiceLocator;
import util.RHException;

/**
 *
 * @author David
 */
public class SolicitudDAO {

    public int consultarConsecutivo(Usuario usuario, int cedEstudiante) throws Exception {
        ServiceLocator sl = new ServiceLocator(usuario.getUsuario(), usuario.getPasswd());
        int resultado = 0;
        try {
            String sql = "select k_consolicitud from request where fk_cedulaestudiante = ?";
            Connection conexion = sl.tomarConexion();

            PreparedStatement prepStmt = conexion.prepareStatement(sql);
            prepStmt.setInt(1, cedEstudiante);

            ResultSet rs = prepStmt.executeQuery();

            while (rs.next()) {
                resultado = rs.getInt(1);
                System.out.println("SolDAO: " + resultado);
            }
            sl.commit();
            prepStmt.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sl.liberarConexion();
        }
        return resultado;
    }
    
    
    public String cambiarEstadoSolicitud(Usuario usuario, int cedEstudiante) throws RHException, Exception{
        ServiceLocator sl = new ServiceLocator(usuario.getUsuario(), usuario.getPasswd());
        String mensaje ="";
        try{
            Connection conexion = sl.tomarConexion();
            CallableStatement cs = null;
            int consecutivo = consultarEnVerificacion(usuario, cedEstudiante);
            cs = conexion.prepareCall("{call u_apoyo.pk_solicitudes.pr_cambiar_estado_solicitud(?)}");
            cs.setInt(1, consecutivo);
            cs.execute();
            sl.commit();
        } catch(SQLException e){
            System.out.println("CONVOCATORIA " + e);
            mensaje = e.toString();
        }finally{
            sl.liberarConexion();
        }
        return mensaje;
    } 
    
    public String asignarPuntajeCondicion(Usuario usuario, int idCondicion,int cedEstudiante, int valor) throws Exception{
        ServiceLocator sl = new ServiceLocator(usuario.getUsuario(), usuario.getPasswd());
        String mensaje ="";
        try{
            Connection conexion = sl.tomarConexion();
            CallableStatement cs = null;
            int consecutivo = consultarEnVerificacion(usuario, cedEstudiante);
            cs = conexion.prepareCall("{call u_apoyo.pk_solicitudes.pr_verificar_solicitud_cond(?,?,?)}");
            cs.setInt(1, idCondicion);
            cs.setInt(2,consecutivo);
            cs.setInt(3, valor);
            cs.execute();
            sl.commit();
        } catch(SQLException e){
            System.out.println("CONVOCATORIA " + e);
            mensaje = e.toString();
        }finally{
            sl.liberarConexion();
        }
        return mensaje;
    }
    
    public String calcularPuntajeSolicitudes(Usuario usuario, int idCondicion, int cedAdmin) throws Exception{
        ServiceLocator sl = new ServiceLocator(usuario.getUsuario(), usuario.getPasswd());
        String mensaje ="";
        try{
            Connection conexion = sl.tomarConexion();
            CallableStatement cs = null;
            cs = conexion.prepareCall("{call u_apoyo.pk_solicitudes.pr_calcular_pun_solicitudes(?,?)}");
            cs.setInt(1, idCondicion);
            cs.setInt(2, cedAdmin);
            cs.execute();
            sl.commit();
        } catch(SQLException e){
            System.out.println("CONVOCATORIA " + e);
            mensaje = e.toString();
        }finally{
            sl.liberarConexion();
        }
        return mensaje;
    }
    
    public int consultarEnVerificacion(Usuario usuario, int cedEstudiante) throws Exception {
        ServiceLocator sl = new ServiceLocator(usuario.getUsuario(), usuario.getPasswd());
        int resultado = 0;
        try {
            String sql = "select r.k_consolicitud "
                    + "from request r , summons s "
                    + "where r.fk_cedulaestudiante=? and s.i_estadoconvocatoria='en_validacion' "
                    + "and r.fk_anioconv = s.k_anioconv and r.fk_periodoconv = s.k_periodoconv";

            Connection conexion = sl.tomarConexion();

            PreparedStatement prepStmt = conexion.prepareStatement(sql);
            prepStmt.setInt(1, cedEstudiante);

            ResultSet rs = prepStmt.executeQuery();

            while (rs.next()) {
                resultado = rs.getInt(1);
            }
            sl.commit();
            prepStmt.close();
        } catch (Exception e) {
        } finally {
            sl.liberarConexion();
        }
        return resultado;
    }

    public String consultarSolicitud(Usuario usuario, int cedEstudiante) throws Exception {
        ServiceLocator sl = new ServiceLocator(usuario.getUsuario(), usuario.getPasswd());
        String resultado = null;
        try {
            String sql = "select fk_cedulaestudiante, i_estadoSolicitud, f_radicacion, fk_anioconv, fk_periodoconv from request where fk_cedulaestudiante = ?";
            Connection conexion = sl.tomarConexion();

            PreparedStatement prepStmt = conexion.prepareStatement(sql);
            prepStmt.setInt(1, cedEstudiante);

            ResultSet rs = prepStmt.executeQuery();

            while (rs.next()) {
                resultado = rs.getInt(1) + "," + rs.getString(2) + "," + rs.getString(3) + "," + rs.getString(4);
            }
            if (resultado == null) {
                resultado = "No existe solicitud";
            }
            sl.commit();
            prepStmt.close();
        } catch (Exception e) {
            resultado = e.toString();
        } finally {
            sl.liberarConexion();
        }
        return resultado;
    }

    public String registrarSolicitud(Solicitud solicitud, Usuario usuario) throws Exception {
        ServiceLocator sl = new ServiceLocator(usuario.getUsuario(), usuario.getPasswd());
        String resultado = null;
        try {
            System.out.println("SOLICITUDDAO: REGISTRO");
            String strSQL = "insert into request (i_estadosolicitud, f_radicacion,q_puntajesolicitud,fk_cedulaestudiante,fk_cedulaadministrador,fk_anioconv,fk_periodoconv) values (?,sysdate,null,?,null,?,?)";
            Connection conexion = sl.tomarConexion();

            PreparedStatement prepStmt = conexion.prepareStatement(strSQL);
            prepStmt.setString(1, solicitud.getEstadoSolicitud());
            prepStmt.setInt(2, solicitud.getCedulaEstudiante());
            prepStmt.setString(3, solicitud.getAnioConv());
            prepStmt.setString(4, solicitud.getPeriodoConv());

            prepStmt.executeUpdate();
            prepStmt.close();
            sl.commit();

            resultado = "Solicitud Creada";
            System.out.println("Solicitud creada");
        } catch (Exception e) {
            resultado = e.toString();
        } finally {
            sl.liberarConexion();
        }

        return resultado;
    }

    public String verificarExistencia(int cedEstudiante, String anioConv, String periodo, Usuario usuario) throws Exception {
        ServiceLocator sl = new ServiceLocator(usuario.getUsuario(), usuario.getPasswd());
        String resultado = null;
        try {
            String sql = "select k_consolicitud from request where fk_cedulaestudiante = ? and fk_anioconv=? and fk_periodoconv=?";
            Connection conexion = sl.tomarConexion();

            PreparedStatement prepStmt = conexion.prepareStatement(sql);
            prepStmt.setInt(1, cedEstudiante);
            prepStmt.setString(2, anioConv);
            prepStmt.setString(3, periodo);

            ResultSet rs = prepStmt.executeQuery();
            if (rs.next()) {
                resultado = "Encontrado un registro para " + cedEstudiante;
            } else {
                resultado = null;
            }

        } catch (Exception e) {
            resultado = e.toString();
        } finally {
            sl.liberarConexion();
        }
        return resultado;
    }

    public ArrayList consultarSolicitudes(Usuario usuario, String anioConv, String periodoConv) throws Exception {
        ServiceLocator sl = new ServiceLocator(usuario.getUsuario(), usuario.getPasswd());
        String resultado = null;

        ArrayList<Solicitud> solicitudes = new ArrayList();
        try {
            String sql = "select i_estadoSolicitud, to_char(f_radicacion, 'dd/month/yyyy'), q_puntajeSolicitud, fk_cedulaestudiante, fk_cedulaadministrador from request where fk_anioconv=? and fk_periodoConv=? and i_estadoSolicitud='en_proceso'";
            Connection conexion = sl.tomarConexion();

            PreparedStatement prepStmt = conexion.prepareStatement(sql);
            prepStmt.setString(1, anioConv);
            prepStmt.setString(2, periodoConv);

            ResultSet rs = prepStmt.executeQuery();

            while (rs.next()) {
                solicitudes.add(new Solicitud(rs.getString(1), rs.getString(2), rs.getInt(3), rs.getInt(4), rs.getInt(5), anioConv, periodoConv));
            }

            sl.commit();
            prepStmt.close();
        } catch (Exception e) {
            resultado = e.toString();
        } finally {
            sl.liberarConexion();
        }
        return solicitudes;
    }
    
    public ArrayList consultarSolicitudesAprobadas(Usuario usuario, String anioConv, String periodoConv) throws Exception {
        ServiceLocator sl = new ServiceLocator("apoyo", "u_apoyo");
        String resultado = null;

        ArrayList<String> correos = new ArrayList();
        try {
           
            String sql = "select p.n_correopersona"
                    + " from person p, student e, request s, summons c"
                    + " where p.K_CEDULAPERSONA = e.K_CEDULAESTUDIANTE and s.FK_CEDULAESTUDIANTE = e.K_CEDULAESTUDIANTE "
                    + " and c.k_anioconv=? and c.k_periodoConv=? and s.i_estadoSolicitud='aprobada'";
            Connection conexion = sl.tomarConexion();
            PreparedStatement prepStmt = conexion.prepareStatement(sql);
            System.out.println("paso1");
            prepStmt.setString(1, anioConv);
            System.out.println("paso2");
            prepStmt.setString(2, periodoConv);
            System.out.println("paso3");

            ResultSet rs = prepStmt.executeQuery();
            System.out.println("paso4");
            while (rs.next()) {
                System.out.println("paso5");
                correos.add(rs.getString(1));
            }

            sl.commit();
            prepStmt.close();
        } catch (Exception e) {
            System.out.println(e.toString());
            resultado = e.toString();
        } finally {
            sl.liberarConexion();
        }
        return correos;
    }
}
