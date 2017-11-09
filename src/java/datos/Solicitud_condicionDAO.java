/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import negocio.Solicitud_condicion;
import negocio.Usuario;
import util.ServiceLocator;
import util.RHException;

/**
 *
 * @author David
 */
public class Solicitud_condicionDAO {

    
    public String  registrarSolicitud_Condicion(Solicitud_condicion sc, Usuario usuario) throws RHException, Exception {
    String resultado=null;   
    ServiceLocator sl = new ServiceLocator(usuario.getUsuario(), usuario.getPasswd());
    try {
            String strSQL = "INSERT INTO request_benefit VALUES(?,?,null,null,?,?)";
            Connection conexion = sl.tomarConexion();
            
            PreparedStatement prepStmt = conexion.prepareStatement(strSQL);
            prepStmt.setString(1, sc.getArchivo());
            prepStmt.setString(2, sc.getValorCondicion());
            prepStmt.setInt(3, sc.getConSolicitud());
            prepStmt.setInt(4, sc.getIdCondicion());

            prepStmt.executeUpdate();
            prepStmt.close();
            sl.commit();
            
            resultado = "Solicitud_convocatoria creada";
            System.out.println("Solicitud_Convocatoria Creada");

        } catch (SQLException e) {
            resultado = e.toString();
            System.out.println(resultado);
        } finally {
            sl.liberarConexion();
        }
        return resultado;
    }
    
    public ArrayList consultarCondiciones(Usuario usuario, String cedula) throws Exception{
        ServiceLocator sl = new ServiceLocator(usuario.getUsuario(), usuario.getPasswd());
        ArrayList sol_cond = new ArrayList();
        sol_cond.add("");
        try { 
            String strSQL = "select c.n_nomcondicion, rb.n_adjunto, rb.n_valorCondicion "
                    + "from request_benefit rb, condition c, request r "
                    + "where r.fk_cedulaEstudiante = ? and rb.fk_conSolicitud = r.k_conSolicitud and c.k_idcondicion = rb.fk_idcondicion";
            
            Connection conexion = sl.tomarConexion();
            PreparedStatement prepStmt = conexion.prepareStatement(strSQL);
            prepStmt.setString(1, cedula);
            
            ResultSet rs = prepStmt.executeQuery();
            while(rs.next()){
                sol_cond.add(new Solicitud_condicion(rs.getString(1),rs.getString(3), 0, null, 0, 0, rs.getString(2)));
            }
            sl.commit();
            prepStmt.close();
        } catch (Exception ex) {
            sol_cond.set(0, ex.toString());
        }finally{
            sl.liberarConexion();
        }      
       return sol_cond;
    }
}
