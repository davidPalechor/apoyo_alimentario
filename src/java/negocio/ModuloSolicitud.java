package negocio;

import datos.SolicitudDAO;
import datos.Solicitud_condicionDAO;
import java.util.ArrayList;

public class ModuloSolicitud {

    private Usuario usuario;
    private SolicitudDAO solDao;
    private Solicitud_condicionDAO solCondicion;
    private Solicitud solicitud;

    public ModuloSolicitud(Usuario usuario) {
        this.usuario = usuario;
        this.solDao = new SolicitudDAO();
        this.solCondicion = new Solicitud_condicionDAO();
    }

    public String crearSolicitud(String estado, String f_Rad, int puntaje, int cedEst, int cedAdm, String anioConv, String periodo) {
        String resultado = null;
        try {
            this.solicitud = new Solicitud(estado, f_Rad, puntaje, cedEst, cedAdm, anioConv, periodo);
            resultado = solDao.registrarSolicitud(solicitud, usuario);
        } catch (Exception e) {
            resultado = e.toString();
        }
        return resultado;
    }

    public String llenarSolicitudCondicion(String[] condiciones, String[] archivos, int conSolicitud) {
        String resultado = null;
        try {
            for (int i = 0; i < condiciones.length; i++) {
                solCondicion.registrarSolicitud_Condicion(new Solicitud_condicion("",condiciones[i], 0, null, conSolicitud, i + 13, archivos[i]), usuario);
            }
        } catch (Exception e) {
            resultado = e.toString();
        }
        return resultado;
    }

    public String cambiarEstadoSolicitud(int cedEstudiante){
        String resultado = "";
        try {
            resultado = solDao.cambiarEstadoSolicitud(usuario, cedEstudiante);
        } catch (Exception e) {
            resultado = e.toString();
        }
        return resultado;
    }
    
    public String asignarPuntajeCondicion(int idCondicion,int cedEstudiante, int valor){
        String resultado = "";
        try {
            resultado = solDao.asignarPuntajeCondicion(usuario,idCondicion, cedEstudiante, valor);
        } catch (Exception e) {
            resultado = e.toString();
        }
        return resultado;
    }
    
    public String calcularPuntajeSolicitud(int idCondicion, int cedAdmin){
        String resultado = "";
        try {
            resultado = solDao.calcularPuntajeSolicitudes(usuario,idCondicion, cedAdmin);
        } catch (Exception e) {
            resultado = e.toString();
        }
        return resultado;
    }
    
    public int consultarConsecutivo(int cedEstudiante) {
        int resultado = 0;
        try {
            resultado = solDao.consultarConsecutivo(usuario, cedEstudiante);
        } catch (Exception e) {
            resultado = -1;
        }
        return resultado;
    }

    public String verificarExistencia(int cedEstudiante, String anioConv, String periodo) {
        String resultado = null;
        try {
            resultado = solDao.verificarExistencia(cedEstudiante, anioConv, periodo, usuario);
        } catch (Exception e) {
            resultado = e.toString();
        }
        return resultado;
    }

    public String consultarSolicitud(int cedEstudiante) {
        String resultado = null;
        try {
            resultado = solDao.consultarSolicitud(usuario, cedEstudiante);
        } catch (Exception e) {
            resultado = e.toString();
        }
        return resultado;
    }

    public ArrayList consultarSolicitudes(String anio, String periodo) {
        ArrayList resultado = new ArrayList();
        try {
            resultado = solDao.consultarSolicitudes(usuario, anio, periodo);
        } catch (Exception e) {
            System.out.println(e.toString());
            //return resultado;
        }
        return resultado;
    }
    
    public ArrayList consultarSolicitudesAprobadas(String anio, String periodo) {
        ArrayList resultado = new ArrayList();
        try {
            resultado = solDao.consultarSolicitudesAprobadas(usuario, anio, periodo);
            System.out.println(resultado);
        } catch (Exception e) {
            System.out.println(e.toString());
            //return resultado;
        }
        return resultado;
    }
    
        
    public ArrayList consultarCondicionesSolicitud(String cedula){
        ArrayList resultado = new ArrayList();
        try {
            resultado = solCondicion.consultarCondiciones(usuario, cedula);
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        return resultado;
    }
}
