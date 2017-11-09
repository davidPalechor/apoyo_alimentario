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
public class Actividad_beneficio {
    private String estadoCumplimiento;
    private int idBeneficio;
    private String nomActividad;

    public Actividad_beneficio(String estadoCumplimiento, int idBeneficio, String nomActividad) {
        this.estadoCumplimiento = estadoCumplimiento;
        this.idBeneficio = idBeneficio;
        this.nomActividad = nomActividad;
    }

    public String getEstadoCumplimiento() {
        return estadoCumplimiento;
    }

    public void setEstadoCumplimiento(String estadoCumplimiento) {
        this.estadoCumplimiento = estadoCumplimiento;
    }

    public int getIdBeneficio() {
        return idBeneficio;
    }

    public void setIdBeneficio(int idBeneficio) {
        this.idBeneficio = idBeneficio;
    }

    public String getNomActividad() {
        return nomActividad;
    }

    public void setNomActividad(String nomActividad) {
        this.nomActividad = nomActividad;
    }
    
    
}
