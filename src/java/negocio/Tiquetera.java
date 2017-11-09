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
public class Tiquetera {

    private int idTiquetera;
    private String fEntrega;
    private int costoTiquetera;
    private int idBeneficio;

    public Tiquetera(int idTiquetera, String fEntrega, int costoTiquetera, int idBeneficio) {
        this.idTiquetera = idTiquetera;
        this.fEntrega = fEntrega;
        this.costoTiquetera = costoTiquetera;
        this.idBeneficio = idBeneficio;
    }

    public int getIdTiquetera() {
        return idTiquetera;
    }

    public void setIdTiquetera(int idTiquetera) {
        this.idTiquetera = idTiquetera;
    }

    public String getfEntrega() {
        return fEntrega;
    }

    public void setfEntrega(String fEntrega) {
        this.fEntrega = fEntrega;
    }

    public int getCostoTiquetera() {
        return costoTiquetera;
    }

    public void setCostoTiquetera(int costoTiquetera) {
        this.costoTiquetera = costoTiquetera;
    }

    public int getIdBeneficio() {
        return idBeneficio;
    }

    public void setIdBeneficio(int idBeneficio) {
        this.idBeneficio = idBeneficio;
    }

}
