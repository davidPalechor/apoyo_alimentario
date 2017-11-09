
package negocio;

import datos.EstudianteDAO;
import util.RHException;


public class ModuloEstudiante {
    private EstudianteDAO estudianteDao;
    
    public ModuloEstudiante(){
        this.estudianteDao = new EstudianteDAO();
    }
    
    
    public String RegistrarUsuario(String usuario, String password) throws RHException{
        String resultado = null;
        System.out.println("ME:REGISTRAR");
        try {
            Usuario u = new Usuario(usuario, password);
            //u.setUsuario(usuario);
            //u.setPasswd(password);
            System.out.println(u.getUsuario() + " " + u.getPasswd());
            String consulta = estudianteDao.consultarEstado(u);
            if(consulta.equals("activo")){
                resultado = estudianteDao.crearUsuario(u);
            } 
            if(consulta.equals("inactivo")){
                resultado = consulta;
            }
            
        } catch (Exception e) {
            resultado = e.toString();
        }
        return resultado;
    }
    
    public String consultarCedulaEstudiante(String cod){
        String resultado = null;
        try {
            resultado = estudianteDao.consultarCedulaEstudiante(cod);
        } catch (Exception e) {
            return resultado;
        }
        return resultado;
    }
}
