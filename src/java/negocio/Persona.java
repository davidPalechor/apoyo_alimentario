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
public class Persona {
   private int cedulaPersona;
   private String nomPersona;
   private String apePersona;
   private String tipoId;
   private String correoPersona;
   private String direccionPersona;
   private int telefonoPersona;

    public Persona(int cedulaPersona, String nomPersona, String apePersona, String tipoId, String correoPersona, String direccionPersona, int telefonoPersona) {
        this.cedulaPersona = cedulaPersona;
        this.nomPersona = nomPersona;
        this.apePersona = apePersona;
        this.tipoId = tipoId;
        this.correoPersona = correoPersona;
        this.direccionPersona = direccionPersona;
        this.telefonoPersona = telefonoPersona;
    }

    public int getCedulaPersona() {
        return cedulaPersona;
    }

    public void setCedulaPersona(int cedulaPersona) {
        this.cedulaPersona = cedulaPersona;
    }

    public String getNomPersona() {
        return nomPersona;
    }

    public void setNomPersona(String nomPersona) {
        this.nomPersona = nomPersona;
    }

    public String getApePersona() {
        return apePersona;
    }

    public void setApePersona(String apePersona) {
        this.apePersona = apePersona;
    }

    public String getTipoId() {
        return tipoId;
    }

    public void setTipoId(String tipoId) {
        this.tipoId = tipoId;
    }

    public String getCorreoPersona() {
        return correoPersona;
    }

    public void setCorreoPersona(String correoPersona) {
        this.correoPersona = correoPersona;
    }

    public String getDireccionPersona() {
        return direccionPersona;
    }

    public void setDireccionPersona(String direccionPersona) {
        this.direccionPersona = direccionPersona;
    }

    public int getTelefonoPersona() {
        return telefonoPersona;
    }

    public void setTelefonoPersona(int telefonoPersona) {
        this.telefonoPersona = telefonoPersona;
    }
   
   
}
