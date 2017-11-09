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
public class Beneficio {
    private int idBeneficio;
    private String tipBeneficio;
    private int horasBeneficio;
    private String estadoBeneficio;
    private int conSolicitud;
    private int cedulaAdministrador;
    private String fRetiro;
    private String motivoRetiro;

    public Beneficio(int idBeneficio, String tipBeneficio, int horasBeneficio, String estadoBeneficio, int conSolicitud, int cedulaAdministrador, String fRetiro, String motivoRetiro) {
        this.idBeneficio = idBeneficio;
        this.tipBeneficio = tipBeneficio;
        this.horasBeneficio = horasBeneficio;
        this.estadoBeneficio = estadoBeneficio;
        this.conSolicitud = conSolicitud;
        this.cedulaAdministrador = cedulaAdministrador;
        this.fRetiro = fRetiro;
        this.motivoRetiro = motivoRetiro;
    }

    public int getIdBeneficio() {
        return idBeneficio;
    }

    public void setIdBeneficio(int idBeneficio) {
        this.idBeneficio = idBeneficio;
    }

    public String getTipBeneficio() {
        return tipBeneficio;
    }

    public void setTipBeneficio(String tipBeneficio) {
        this.tipBeneficio = tipBeneficio;
    }

    public int getHorasBeneficio() {
        return horasBeneficio;
    }

    public void setHorasBeneficio(int horasBeneficio) {
        this.horasBeneficio = horasBeneficio;
    }

    public String getEstadoBeneficio() {
        return estadoBeneficio;
    }

    public void setEstadoBeneficio(String estadoBeneficio) {
        this.estadoBeneficio = estadoBeneficio;
    }

    public int getConSolicitud() {
        return conSolicitud;
    }

    public void setConSolicitud(int conSolicitud) {
        this.conSolicitud = conSolicitud;
    }

    public int getCedulaAdministrador() {
        return cedulaAdministrador;
    }

    public void setCedulaAdministrador(int cedulaAdministrador) {
        this.cedulaAdministrador = cedulaAdministrador;
    }

    public String getfRetiro() {
        return fRetiro;
    }

    public void setfRetiro(String fRetiro) {
        this.fRetiro = fRetiro;
    }

    public String getMotivoRetiro() {
        return motivoRetiro;
    }

    public void setMotivoRetiro(String motivoRetiro) {
        this.motivoRetiro = motivoRetiro;
    }
    
    
}
