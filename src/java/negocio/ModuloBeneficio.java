/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import datos.BeneficioDAO;

/**
 *
 * @author David
 */
public class ModuloBeneficio {

    private Usuario usuario;
    private BeneficioDAO bnfc_dao;
    private Beneficio beneficio;

    public ModuloBeneficio(Usuario usuario) {
        this.usuario = usuario;
        this.bnfc_dao = new BeneficioDAO();
    }

    public String adjudicarBeneficio() {
        String resultado = null;
        try {
            resultado = bnfc_dao.adjudicarBeneficio(usuario);
        } catch (Exception e) {
            resultado = e.toString();
        }
        return resultado;
    }

    public String generarListado() {
        String resultado = null;
        try {
            resultado = bnfc_dao.generarListado(usuario);
        } catch (Exception e) {
            resultado = e.toString();
        }
        return resultado;
    }
}
