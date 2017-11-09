/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import negocio.ModuloSolicitud;
import negocio.Solicitud;
import negocio.Solicitud_condicion;
import negocio.Usuario;

/**
 *
 * @author David
 */
@WebServlet(name = "S_Revision", urlPatterns = {"/S_Revision"})
public class S_Revision extends HttpServlet {

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
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet S_Revision</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet S_Revision at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
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
    String cedula = "";
    ArrayList res = new ArrayList();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        cedula = request.getParameter("cedula");
        Usuario user = new Usuario((String) request.getSession().getAttribute("usuario"), (String) request.getSession().getAttribute("passwd"));
        ModuloSolicitud msol = new ModuloSolicitud(user);
        res = msol.consultarCondicionesSolicitud(cedula);

        request.setAttribute("mensaje", res);
        request.getRequestDispatcher("revisarSolicitud.jsp").forward(request, response);
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
        Usuario user = new Usuario((String) request.getSession().getAttribute("usuario"), (String) request.getSession().getAttribute("passwd"));
        ModuloSolicitud msol = new ModuloSolicitud(user);

        msol.cambiarEstadoSolicitud(Integer.parseInt(cedula));
        
        int j = 23;
        for (int i = 1; i < res.size(); i++) {

            Solicitud_condicion aux = (Solicitud_condicion) res.get(i);
            String valor = request.getParameter(aux.getNom_condicion());
            msol.asignarPuntajeCondicion(j, Integer.parseInt(cedula), Integer.parseInt(valor));
            j--;
        }

        //request.setAttribute("mensaje", mensaje);
        request.getRequestDispatcher("validarSolicitudes.jsp").forward(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
