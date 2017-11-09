/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import negocio.Usuario;
import util.ServiceLocator;

/**
 *
 * @author David
 */
public class BeneficioDAO {
    
    public String adjudicarBeneficio(Usuario usuario) throws Exception{
        ServiceLocator sl = new ServiceLocator(usuario.getUsuario(), usuario.getPasswd());
        String mensaje ="";
        try{
            Connection conexion = sl.tomarConexion();
            CallableStatement cs = null;
            cs = conexion.prepareCall("{call u_apoyo.pk_solicitudes.pr_adjudicar_beneficio}");
            cs.execute();
            sl.commit();
        } catch(SQLException e){
            mensaje = e.toString();
        }finally{
            sl.liberarConexion();
        }
        return mensaje;
    }
    
    public String generarListado(Usuario usuario) throws Exception{
        ServiceLocator sl = new ServiceLocator(usuario.getUsuario(), usuario.getPasswd());
        String mensaje ="";
        try{
            Connection conexion = sl.tomarConexion();
            CallableStatement cs = null;
            cs = conexion.prepareCall("{call u_apoyo.pk_solicitudes.pr_generar_listado}");
            cs.execute();
            sl.commit();
        } catch(SQLException e){
            mensaje = e.toString();
        }finally{
            sl.liberarConexion();
        }
        return mensaje;
    }
    
}
