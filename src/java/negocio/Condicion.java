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
public class Condicion {
    private int idCondicion;
    private String nomCondicion;
    private int puntajeCondicion;

    public Condicion(int idCondicion, String nomCondicion, int puntajeCondicion) {
        this.idCondicion = idCondicion;
        this.nomCondicion = nomCondicion;
        this.puntajeCondicion = puntajeCondicion;
    }

    public int getIdCondicion() {
        return idCondicion;
    }

    public void setIdCondicion(int idCondicion) {
        this.idCondicion = idCondicion;
    }

    public String getNomCondicion() {
        return nomCondicion;
    }

    public void setNomCondicion(String nomCondicion) {
        this.nomCondicion = nomCondicion;
    }

    public int getPuntajeCondicion() {
        return puntajeCondicion;
    }

    public void setPuntajeCondicion(int puntajeCondicion) {
        this.puntajeCondicion = puntajeCondicion;
    }
    
    
}
