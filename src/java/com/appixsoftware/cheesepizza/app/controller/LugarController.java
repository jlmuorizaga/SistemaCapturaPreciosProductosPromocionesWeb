/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.appixsoftware.cheesepizza.app.controller;

import com.appixsoftware.cheesepizza.app.dto.LugarDto;
import com.appixsoftware.cheesepizza.app.dto.SucursalDto;
import com.appixsoftware.cheesepizza.app.persistence.LugarDao;
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
public class LugarController extends HttpServlet {

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
        try (PrintWriter out = response.getWriter()) {
            String accion = request.getParameter("accion");
            HttpSession sesion = request.getSession();
            SucursalDto sucursal = (SucursalDto) sesion.getAttribute("sucursal");

            switch (accion) {
                case "insertar":
                    String nombre = request.getParameter("nombre");
                    LugarDto l = new LugarDto();
                    l.setId(UniqueKey.generateUniqueKey("00CHP"));
                    l.setNombre(nombre);
                    LugarDao.insertaLugarNuevo(l);
                    List<LugarDto> listaLugar = LugarDao.dameListaLugar();
                    sesion.setAttribute("listaLugar", listaLugar);
                    request.getRequestDispatcher("lugar.jsp").forward(request, response);
                    break;
                case "borrar":
                    String id = request.getParameter("id");
                    l = new LugarDto();
                    l.setId(id);
                    LugarDao.borraLugar(l);
                    listaLugar = LugarDao.dameListaLugar();
                    sesion.setAttribute("listaLugar", listaLugar);
                    request.getRequestDispatcher("lugar.jsp").forward(request, response);
                    break;
                case "editar":
                    id = request.getParameter("id");
                    nombre = request.getParameter("nombre");
                    request.setAttribute("id", id);
                    request.setAttribute("nombre", nombre);
                    request.getRequestDispatcher("editarlugar.jsp").forward(request, response);
                    break;
                case "guardaedicion":
                    id = request.getParameter("id");
                    nombre=request.getParameter("nombre");
                    l = new LugarDto();
                    l.setId(id);
                    l.setNombre(nombre);
                    LugarDao.editaLugar(l);
                    listaLugar = LugarDao.dameListaLugar();
                    sesion.setAttribute("listaLugar", listaLugar);
                    request.getRequestDispatcher("lugar.jsp").forward(request, response);
                    break;                    
                    
                default:
                    break;
            }

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
            Logger.getLogger(LugarController.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(LugarController.class.getName()).log(Level.SEVERE, null, ex);
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
