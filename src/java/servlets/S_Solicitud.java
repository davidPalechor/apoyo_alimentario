/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.System.out;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ServiceLoader;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;
import negocio.ModuloEstudiante;
import negocio.ModuloSolicitud;
import negocio.Usuario;
import util.ServiceLocator;

/**
 *
 * @author David
 */
@WebServlet(name = "RegistroSolicitud", urlPatterns = {"/RegistroSolicitud"})
public class S_Solicitud extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String usuario = (String) request.getSession().getAttribute("usuario");
        String passwd = (String) request.getSession().getAttribute("passwd");
            
        Usuario user = new Usuario(usuario, passwd);
        String cedulaEst = request.getParameter("identificacion");
        System.out.println(cedulaEst);

        ModuloSolicitud modSol = new ModuloSolicitud(user);
        String res = modSol.consultarSolicitud(Integer.parseInt(cedulaEst));
        System.out.println("Solicitud " + res);
        
        if (res != null) {
                if(res.toLowerCase().contains("exception")){
                  request.setAttribute("mensaje","No hay fechas para mostrar");  
                  request.getRequestDispatcher("consultaConv.jsp").forward(request, response);
            }else{
                request.setAttribute("mensaje",res);
                request.getRequestDispatcher("consultaConv.jsp").forward(request, response);
                }
            }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {

            String[] CONDICIONES = {request.getParameter("ingresos"),
                request.getParameter("sostiene_hogar"),
                request.getParameter("sostiene_si_mismo"),
                request.getParameter("vive_fuera"),
                request.getParameter("personas_a_cargo"),
                request.getParameter("vive_casa_empleador"),
                request.getParameter("desplazado"),
                request.getParameter("municipio"),
                request.getParameter("vulnerabilidad"),
                request.getParameter("discapacidad"),
                request.getParameter("patologia")
            };

            String[] ARCHIVOS = {request.getParameter("archivo_ingresos"),
                request.getParameter("archivo_sostiene_hogar"),
                request.getParameter("archivo_sostiene_si_mismo"),
                request.getParameter("archivo_vive_fuera"),
                request.getParameter("archivo_personas_a_cargo"),
                request.getParameter("archivo_vive_casa_empleador"),
                request.getParameter("archivo_desplazado"),
                request.getParameter("archivo_municipio"),
                request.getParameter("archivo_vulnerabilidad"),
                request.getParameter("archivo_discapacidad"),
                request.getParameter("archivo_patologia")
            };

            Usuario user = new Usuario((String) request.getSession().getAttribute("usuario"), (String) request.getSession().getAttribute("passwd"));

            String cedulaEst = request.getParameter("identificacion");
            String anioConv = request.getParameter("anio");
            String periodo = request.getParameter("periodo");
            System.out.println(cedulaEst);

            ModuloSolicitud modSol = new ModuloSolicitud(user);

            if (modSol.verificarExistencia(Integer.parseInt(cedulaEst), anioConv, periodo) == null) {
                System.out.println("PROBANDO EXISTENCIA");
                String res = modSol.crearSolicitud("en_proceso", null, 0, Integer.parseInt(cedulaEst), 0, anioConv, periodo);
                if (res.toLowerCase().contains("exception")) {
                    System.out.println(res);
                    request.setAttribute("mensaje", res);
                } else {
                    request.setAttribute("mensaje", "Solicitud para " + cedulaEst + " creada");
                    int conSolicitud = modSol.consultarConsecutivo(Integer.parseInt(request.getParameter("identificacion")));
                    String resultado = modSol.llenarSolicitudCondicion(CONDICIONES, ARCHIVOS, conSolicitud);
                    System.out.println(resultado);
                }
            } else {
                System.out.println("YA HAY SOLICITUD");
                request.setAttribute("mensaje", null);
            }

            request.getRequestDispatcher("reg_solicitud.jsp").forward(request, response);

        } catch (Exception e) {
            System.out.println("ERROR SERVLET REGISTRO SOLICITUD" + e.toString());
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
