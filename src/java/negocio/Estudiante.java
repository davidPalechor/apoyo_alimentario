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
public class Estudiante {
    private int cedulaEstudiante;
    private String proyCurricular;
    private double promedio;
    private int numMatriculas;
    private String codigoBarras;
    private String estadoEstudiante;
    private int codigoEstudiante;
    private int estartoEstudiante;

    public Estudiante(int cedulaEstudiante, String proyCurricular, double promedio, int numMatriculas, String codigoBarras, String estadoEstudiante, int codigoEstudiante, int estartoEstudiante) {
        this.cedulaEstudiante = cedulaEstudiante;
        this.proyCurricular = proyCurricular;
        this.promedio = promedio;
        this.numMatriculas = numMatriculas;
        this.codigoBarras = codigoBarras;
        this.estadoEstudiante = estadoEstudiante;
        this.codigoEstudiante = codigoEstudiante;
        this.estartoEstudiante = estartoEstudiante;
    }

    public int getCedulaEstudiante() {
        return cedulaEstudiante;
    }

    public void setCedulaEstudiante(int cedulaEstudiante) {
        this.cedulaEstudiante = cedulaEstudiante;
    }

    public String getProyCurricular() {
        return proyCurricular;
    }

    public void setProyCurricular(String proyCurricular) {
        this.proyCurricular = proyCurricular;
    }

    public double getPromedio() {
        return promedio;
    }

    public void setPromedio(double promedio) {
        this.promedio = promedio;
    }

    public int getNumMatriculas() {
        return numMatriculas;
    }

    public void setNumMatriculas(int numMatriculas) {
        this.numMatriculas = numMatriculas;
    }

    public String getCodigoBarras() {
        return codigoBarras;
    }

    public void setCodigoBarras(String codigoBarras) {
        this.codigoBarras = codigoBarras;
    }

    public String getEstadoEstudiante() {
        return estadoEstudiante;
    }

    public void setEstadoEstudiante(String estadoEstudiante) {
        this.estadoEstudiante = estadoEstudiante;
    }

    public int getCodigoEstudiante() {
        return codigoEstudiante;
    }

    public void setCodigoEstudiante(int codigoEstudiante) {
        this.codigoEstudiante = codigoEstudiante;
    }

    public int getEstartoEstudiante() {
        return estartoEstudiante;
    }

    public void setEstartoEstudiante(int estartoEstudiante) {
        this.estartoEstudiante = estartoEstudiante;
    }  
}
