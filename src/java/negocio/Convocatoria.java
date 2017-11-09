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
public class Convocatoria {
    private String anioConvocatoria;
    private String periodoConvocatoria;
    private String fInicio;
    private String fFin;

    public Convocatoria(String anioConvocatoria, String periodoConvocatoria, String fInicio, String fFin) {
        this.anioConvocatoria = anioConvocatoria;
        this.periodoConvocatoria = periodoConvocatoria;
        this.fInicio = fInicio;
        this.fFin = fFin;
    }

    public String getAnioConvocatoria() {
        return anioConvocatoria;
    }

    public void setAnioConvocatoria(String anioConvocatoria) {
        this.anioConvocatoria = anioConvocatoria;
    }

    public String getPeriodoConvocatoria() {
        return periodoConvocatoria;
    }

    public void setPeriodoConvocatoria(String periodoConvocatoria) {
        this.periodoConvocatoria = periodoConvocatoria;
    }

    public String getfInicio() {
        return fInicio;
    }

    public void setfInicio(String fInicio) {
        this.fInicio = fInicio;
    }

    public String getfFin() {
        return fFin;
    }

    public void setfFin(String fFin) {
        this.fFin = fFin;
    }
    
    
}
