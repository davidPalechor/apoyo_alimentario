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
import negocio.ModuloBeneficio;
import negocio.ModuloSolicitud;
import negocio.ModuloConvocatoria;
import negocio.Usuario;
import negocio.Correo;

/**
 *
 * @author David
 */

@WebServlet(name = "S_Validacion", urlPatterns = {"/S_Validacion"})
public class S_Validacion extends HttpServlet {
    String anio = "";
    String periodo = "";
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
            out.println("<title>Servlet S_Validacion</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet S_Validacion at " + request.getContextPath() + "</h1>");
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
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Usuario user = new Usuario((String) request.getSession().getAttribute("usuario"), (String) request.getSession().getAttribute("passwd"));
        ModuloSolicitud msol = new ModuloSolicitud(user);
        anio = request.getParameter("anio");
        periodo = request.getParameter("periodo");
        ArrayList res = msol.consultarSolicitudes(anio, periodo );
        
        ModuloConvocatoria mcon = new ModuloConvocatoria(user);
        String aux = mcon.cambiarEstadoConvocatoria();
        System.out.println("[SERVLET] " + aux);
        if (aux.equals("verdadero")){
            request.setAttribute("mensaje", res);
            request.getRequestDispatcher("validarSolicitudes.jsp").forward(request, response);
        }
        else if (aux.equals("falso")){
            request.setAttribute("mensaje", null);
            request.setAttribute("cierre", "error");
            request.getRequestDispatcher("validarSolicitudes.jsp").forward(request, response);
        }else{
            if (res.isEmpty()){
                for(int i=1; i<24; i++){
                    msol.calcularPuntajeSolicitud(i+12, Integer.parseInt(user.getUsuario()));
                }
            }
            request.setAttribute("mensaje", res);
            request.getRequestDispatcher("validarSolicitudes.jsp").forward(request, response);
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
        Usuario user = new Usuario((String) request.getSession().getAttribute("usuario"), (String) request.getSession().getAttribute("passwd"));
        ModuloBeneficio mod_ben = new ModuloBeneficio(user);
        String mens = "Su solicitud al apoyo alimentario ha sido aprobada.";
        String res = mod_ben.adjudicarBeneficio();
        ModuloSolicitud msol = new ModuloSolicitud(user);
        ArrayList<String> correos = msol.consultarSolicitudesAprobadas(anio, periodo);
        Correo correo = new Correo();
        for (String s : correos){
            System.out.println("ENTRE AL FOR");
            correo.SendMail(mens, s, "Resultados apoyo alimentario");
        }
        System.out.println("LLEGUÉ AL POST " + res);        
        response.sendRedirect("validarSolicitudes.jsp");
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
