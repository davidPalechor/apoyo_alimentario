/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

/**
 *
 * @author laura
 */
public class Solicitud {
    private String estadoSolicitud;
    private String fRadicacion;
    private int puntajeSolicitud;
    private int cedulaEstudiante;
    private int cedulaAdministrador;
    private String anioConv;
    private String periodoConv;

    public Solicitud(String estadoSolicitud, String fRadicacion, int puntajeSolicitud, int cedulaEstudiante, int cedulaAdministrador, String anioConv, String periodoConv) {
        this.estadoSolicitud = estadoSolicitud;
        this.fRadicacion = fRadicacion;
        this.puntajeSolicitud = puntajeSolicitud;
        this.cedulaEstudiante = cedulaEstudiante;
        this.cedulaAdministrador = cedulaAdministrador;
        this.anioConv = anioConv;
        this.periodoConv = periodoConv;
    }

    public String getEstadoSolicitud() {
        return estadoSolicitud;
    }

    public void setEstadoSolicitud(String estadoSolicitud) {
        this.estadoSolicitud = estadoSolicitud;
    }

    public String getfRadicacion() {
        return fRadicacion;
    }

    public void setfRadicacion(String fRadicacion) {
        this.fRadicacion = fRadicacion;
    }

    public int getPuntajeSolicitud() {
        return puntajeSolicitud;
    }

    public void setPuntajeSolicitud(int puntajeSolicitud) {
        this.puntajeSolicitud = puntajeSolicitud;
    }

    public int getCedulaEstudiante() {
        return cedulaEstudiante;
    }

    public void setCedulaEstudiante(int cedulaEstudiante) {
        this.cedulaEstudiante = cedulaEstudiante;
    }

    public int getCedulaAdministrador() {
        return cedulaAdministrador;
    }

    public void setCedulaAdministrador(int cedulaAdministrador) {
        this.cedulaAdministrador = cedulaAdministrador;
    }

    public String getAnioConv() {
        return anioConv;
    }

    public void setAnioConv(String anioConv) {
        this.anioConv = anioConv;
    }

    public String getPeriodoConv() {
        return periodoConv;
    }

    public void setPeriodoConv(String periodoConv) {
        this.periodoConv = periodoConv;
    }
    
    
}
