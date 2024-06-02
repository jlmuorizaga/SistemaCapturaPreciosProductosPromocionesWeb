/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.appixsoftware.cheesepizza.app.controller;

import com.appixsoftware.cheesepizza.app.dto.SucursalDto;
import com.appixsoftware.cheesepizza.app.dto.TamanioPizzaDto;
import com.appixsoftware.cheesepizza.app.persistence.TamanioPizzaDao;
import com.appixsoftware.cheesepizza.app.utils.UniqueKey;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author LUIS.MU
 */
public class TamanioPizzaController extends HttpServlet {

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
            throws ServletException, IOException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        System.out.println("Entré a processRequest**************************************************");
        try (PrintWriter data = response.getWriter()) {
            String accion = request.getParameter("accion");
            HttpSession sesion = request.getSession();
            SucursalDto sucursal = (SucursalDto) sesion.getAttribute("sucursal");

            switch (accion) {
                case "insertar":
                    String nombre = request.getParameter("nombre");
                    TamanioPizzaDto t = new TamanioPizzaDto();
                    //t.setId(UniqueKey.generateUniqueKey(sucursal.getClave()));
                    t.setId(UniqueKey.generateUniqueKey("00CHP"));
                    t.setNombre(nombre);
                    TamanioPizzaDao.insertaTamanioPizzaNuevo(t);
                    List<TamanioPizzaDto> listaTamanioPizza = TamanioPizzaDao.dameListaTamanioPizza(sucursal.getClave());
                    sesion.setAttribute("listaTamanioPizza", listaTamanioPizza);
                    request.getRequestDispatcher("catalogotamaniopizza.jsp").forward(request, response);
                    break;
                case "borrar":
                    String id = request.getParameter("id");
                    TamanioPizzaDto t1 = new TamanioPizzaDto();
                    t1.setId(id);
                    TamanioPizzaDao.borraTamanioPizza(t1);
                    listaTamanioPizza = TamanioPizzaDao.dameListaTamanioPizza(sucursal.getClave());
                    sesion.setAttribute("listaTamanioPizza", listaTamanioPizza);
                    request.getRequestDispatcher("catalogotamaniopizza.jsp").forward(request, response);
                    break;
                case "editar":
                    String idEditar = request.getParameter("id");
                    String nombreEditar = request.getParameter("nombre");
                    //String aplica2x1Editar=request.getParameter("aplica2x1");
                    //String aplicaP1Editar=request.getParameter("aplicaP1");
                    request.setAttribute("idEditar", idEditar);
                    request.setAttribute("nombreEditar", nombreEditar);
                    //request.setAttribute("aplica2x1Editar", aplica2x1Editar);
                    //request.setAttribute("aplicaP1Editar", aplicaP1Editar);
                    request.getRequestDispatcher("editartamaniopizza.jsp").forward(request, response);
                    break;
                case "guardaedicion":
                    id = request.getParameter("id");
                    nombre = request.getParameter("nombre");
                    //aplica2x1=request.getParameter("aplica2x1");
                    //aplicaP1=request.getParameter("aplicaP1");
                    t1 = new TamanioPizzaDto();
                    t1.setId(id);
                    t1.setNombre(nombre);
                    //t1.setAplica2x1(aplica2x1);
                    //t1.setAplicaP1(aplicaP1);
                    TamanioPizzaDao.editaTamanioPizza(t1);
                    listaTamanioPizza = TamanioPizzaDao.dameListaTamanioPizza(sucursal.getClave());
                    sesion.setAttribute("listaTamanioPizza", listaTamanioPizza);
                    request.getRequestDispatcher("catalogotamaniopizza.jsp").forward(request, response);
                    break;

                default:
                    break;
            }
           // data.print("null");
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
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(TamanioPizzaController.class.getName()).log(Level.SEVERE, null, ex);
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
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(TamanioPizzaController.class.getName()).log(Level.SEVERE, null, ex);
        }
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
