/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import java.io.File;

/**
 *
 * @author laura
 */
public class Solicitud_condicion{ 
    
    private String valorCondicion;
    private int puntajeCondicion;
    private String estadoCondicion;
    private int conSolicitud;
    private int idCondicion;
    private String archivo;
    private String nom_condicion;

    public Solicitud_condicion(String nom_condicion, String valorCondicion, int puntajeCondicion, String estadoCondicion, int conSolicitud, int idCondicion, String archivo) {
        this.archivo = archivo;
        this.valorCondicion = valorCondicion;
        this.puntajeCondicion = puntajeCondicion;
        this.estadoCondicion = estadoCondicion;
        this.conSolicitud = conSolicitud;
        this.idCondicion = idCondicion;
        this.nom_condicion = nom_condicion;
    }

    public String getNom_condicion() {
        return nom_condicion;
    }

    public void setNom_condicion(String nom_condicion) {
        this.nom_condicion = nom_condicion;
    }

    public String getArchivo() {
        return archivo;
    }

    public void setArchivo(String archivo) {
        this.archivo = archivo;
    }

   

    public String getValorCondicion() {
        return valorCondicion;
    }

    public void setValorCondicion(String valorCondicion) {
        this.valorCondicion = valorCondicion;
    }

    public int getPuntajeCondicion() {
        return puntajeCondicion;
    }

    public void setPuntajeCondicion(int puntajeCondicion) {
        this.puntajeCondicion = puntajeCondicion;
    }

    public String getEstadoCondicion() {
        return estadoCondicion;
    }

    public void setEstadoCondicion(String estadoCondicion) {
        this.estadoCondicion = estadoCondicion;
    }

    public int getConSolicitud() {
        return conSolicitud;
    }

    public void setConSolicitud(int conSolicitud) {
        this.conSolicitud = conSolicitud;
    }

    public int getIdCondicion() {
        return idCondicion;
    }

    public void setIdCondicion(int idCondicion) {
        this.idCondicion = idCondicion;
    }
    
    
}
