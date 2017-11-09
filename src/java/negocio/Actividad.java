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
public class Actividad {
    private String nomActividad;
    private String tipoActividad;
    private String desActividad;
    private int cedulaAdministrador;
    private int horasActividad;

    public Actividad(String nomActividad, String tipoActividad, String desActividad, int cedulaAdministrador, int horasActividad) {
        this.nomActividad = nomActividad;
        this.tipoActividad = tipoActividad;
        this.desActividad = desActividad;
        this.cedulaAdministrador = cedulaAdministrador;
        this.horasActividad = horasActividad;
    }

    public String getNomActividad() {
        return nomActividad;
    }

    public void setNomActividad(String nomActividad) {
        this.nomActividad = nomActividad;
    }

    public String getTipoActividad() {
        return tipoActividad;
    }

    public void setTipoActividad(String tipoActividad) {
        this.tipoActividad = tipoActividad;
    }

    public String getDesActividad() {
        return desActividad;
    }

    public void setDesActividad(String desActividad) {
        this.desActividad = desActividad;
    }

    public int getCedulaAdministrador() {
        return cedulaAdministrador;
    }

    public void setCedulaAdministrador(int cedulaAdministrador) {
        this.cedulaAdministrador = cedulaAdministrador;
    }

    public int getHorasActividad() {
        return horasActividad;
    }

    public void setHorasActividad(int horasActividad) {
        this.horasActividad = horasActividad;
    }
    
}
