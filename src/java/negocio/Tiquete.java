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
public class Tiquete {
    private int idTiquete;
    private String fUso;
    private int idTiquetera;

    public Tiquete(int idTiquete, String fUso, int idTiquetera) {
        this.idTiquete = idTiquete;
        this.fUso = fUso;
        this.idTiquetera = idTiquetera;
    }

    public int getIdTiquete() {
        return idTiquete;
    }

    public void setIdTiquete(int idTiquete) {
        this.idTiquete = idTiquete;
    }

    public String getfUso() {
        return fUso;
    }

    public void setfUso(String fUso) {
        this.fUso = fUso;
    }

    public int getIdTiquetera() {
        return idTiquetera;
    }

    public void setIdTiquetera(int idTiquetera) {
        this.idTiquetera = idTiquetera;
    }
    
    
}
