
package negocio;

import datos.ConvocatoriaDAO;
import java.util.logging.Level;
import java.util.logging.Logger;
import util.RHException;

public class ModuloConvocatoria {
    private ConvocatoriaDAO convDao;
    private Usuario usuario;
    private Convocatoria conv;
    public ModuloConvocatoria(Usuario usuario){
        convDao = new ConvocatoriaDAO();
        this.usuario = usuario;
    }
    
    public String crearConvocatoria(String anioConv, String perConv, String fInicio, String fFin)throws Exception{
        
        conv = new Convocatoria(anioConv,perConv,fInicio,fFin);
        String resultado = null;
        try {
            resultado = convDao.crearConvocatoria(conv, usuario);
        } catch (RHException e) {
            resultado = e.toString();
        }
        return resultado;
    }
    
    public String consultarConvocatoria(String anioConv, String perConv){
        System.out.println("MODULO CONV: " + anioConv);
        conv = new Convocatoria(anioConv, perConv, "", "");
        String resultado = null;
        try {
            Convocatoria consulta = convDao.consultarConvocatoria(conv, usuario);
            resultado = consulta.getfInicio()+","+consulta.getfFin();
            
            System.out.println("MODULOCONV" + resultado);
        } catch (Exception e) {
            return "MODULO CONV " + e.toString();
        }
        return resultado;
    }
    public String cambiarEstadoConvocatoria(){
        String resultado =null;
        try{
            resultado = convDao.cambiarEstadoConvocatoria(usuario);
        }catch(Exception e){
            resultado = e.toString();
        }
        return resultado;
    }
}
