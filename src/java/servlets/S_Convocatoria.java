/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import negocio.ModuloConvocatoria;
import negocio.Usuario;

/**
 *
 * @author David
 */
@WebServlet(name = "S_Convocatoria", urlPatterns = {"/S_Convocatoria"})
public class S_Convocatoria extends HttpServlet {

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
            out.println("<title>Servlet S_CrearConvocatoria</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet S_CrearConvocatoria at " + request.getContextPath() + "</h1>");
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
        try {
            Usuario user = new Usuario((String) request.getSession().getAttribute("usuario"), (String) request.getSession().getAttribute("passwd"));
            
            System.out.println("PASSWD " + user.getPasswd());
            System.out.println("USUARIO ACTUAL " + user.getUsuario());
            ModuloConvocatoria mconv = new ModuloConvocatoria(user);
            String aux = mconv.consultarConvocatoria(request.getParameter("anio"), request.getParameter("periodo"));
            
            if (aux != null) {
                if(aux.toLowerCase().contains("exception")){
                  request.setAttribute("conv","No hay fechas para mostrar");  
                  request.getRequestDispatcher("consultaConv.jsp").forward(request, response);
            }else{
                request.setAttribute("conv",aux);
                request.getRequestDispatcher("consultaConv.jsp").forward(request, response);
                }
            }
           
        } catch (Exception e) {
            
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {

            Usuario user = new Usuario((String) request.getSession().getAttribute("usuario"), (String) request.getSession().getAttribute("passwd"));

            ModuloConvocatoria mconv = new ModuloConvocatoria(user);
            String res = mconv.crearConvocatoria(request.getParameter("anio"), request.getParameter("periodo"), request.getParameter("f_In"), request.getParameter("f_Fin"));
            if (res != null) {
                
                request.setAttribute("mensaje",res);
                request.getRequestDispatcher("crearConvocatoria.jsp").forward(request, response);
            } else {
                request.setAttribute("mensaje", "Convocatoria creada exitosamente");
                request.getRequestDispatcher("crearConvocatoria.jsp").forward(request, response);
            }

        } catch (Exception e) {

        }
    }
}
