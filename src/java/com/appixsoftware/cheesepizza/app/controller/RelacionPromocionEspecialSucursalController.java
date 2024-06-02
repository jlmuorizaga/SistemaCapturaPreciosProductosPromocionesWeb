/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.appixsoftware.cheesepizza.app.controller;

import com.appixsoftware.cheesepizza.app.dto.RelacionPromocionEspecialSucursalDto;
import com.appixsoftware.cheesepizza.app.dto.SucursalDto;
import com.appixsoftware.cheesepizza.app.persistence.RelacionPromocionEspecialSucursalDao;
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
 * @author jlmuo
 */
public class RelacionPromocionEspecialSucursalController extends HttpServlet {

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
            throws ServletException, IOException,SQLException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            String accion = request.getParameter("accion");
            HttpSession sesion = request.getSession();
            SucursalDto sucursal = (SucursalDto) sesion.getAttribute("sucursal");
            switch (accion){
                case "insertar":
                    String idPromocion = request.getParameter("idPromocion");
                    RelacionPromocionEspecialSucursalDto r = new RelacionPromocionEspecialSucursalDto();
                    String activa = request.getParameter("activa");
                    r.setIdPromocion(idPromocion);
                    r.setIdSucursal(sucursal.getId());
                    r.setActiva(activa);
                    RelacionPromocionEspecialSucursalDao.insertaRelacionPromocionEspecialSucursal(r);
                    List<RelacionPromocionEspecialSucursalDto> listaRelacionPromocionEspecialSucursal = RelacionPromocionEspecialSucursalDao.dameListaRelacionPromocionEspecialSucursal(sucursal.getId());
                    sesion.setAttribute("listaRelacionPromocionEspecialSucursal", listaRelacionPromocionEspecialSucursal);
                    request.getRequestDispatcher("relacionpromocionespecialsucursal.jsp").forward(request, response);
                    break;
                case "borrar":
                    idPromocion=request.getParameter("idPromocion");
                    String idSucursal = request.getParameter("idSucursal");
                    r = new RelacionPromocionEspecialSucursalDto();
                    r.setIdPromocion(idPromocion);
                    r.setIdSucursal(idSucursal);
                    RelacionPromocionEspecialSucursalDao.borraRelacionPromocionEspecialSucursal(r);
                    listaRelacionPromocionEspecialSucursal = RelacionPromocionEspecialSucursalDao.dameListaRelacionPromocionEspecialSucursal(sucursal.getId());
                    sesion.setAttribute("listaRelacionPromocionEspecialSucursal", listaRelacionPromocionEspecialSucursal);
                    request.getRequestDispatcher("relacionpromocionespecialsucursal.jsp").forward(request, response);
                    break;
                case "editar":
                    idPromocion = request.getParameter("idPromocion");
                    idSucursal = request.getParameter("idSucursal");
                    activa = request.getParameter("activa");
                    request.setAttribute("idPromocion", idPromocion);
                    request.setAttribute("idSucursal", idSucursal);
                    request.setAttribute("activa", activa);
                    request.getRequestDispatcher("editarrelacionpromocionespecialsucursal.jsp").forward(request, response);
                    break;
                case "guardaedicion":
                    idPromocion = request.getParameter("idPromocion");
                    //idSucursal = request.getParameter("idSucursal");
                    activa = request.getParameter("activa");
                    r = new RelacionPromocionEspecialSucursalDto();
                    r.setIdPromocion(idPromocion);
                    r.setIdSucursal(sucursal.getId());
                    r.setActiva(activa);
                    RelacionPromocionEspecialSucursalDao.editaRelacionPromocionEspecialSucursal(r);
                    listaRelacionPromocionEspecialSucursal = RelacionPromocionEspecialSucursalDao.dameListaRelacionPromocionEspecialSucursal(sucursal.getId());
                    sesion.setAttribute("listaRelacionPromocionEspecialSucursal", listaRelacionPromocionEspecialSucursal);
                    request.getRequestDispatcher("relacionpromocionespecialsucursal.jsp").forward(request, response);
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
            Logger.getLogger(RelacionPromocionEspecialSucursalController.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(RelacionPromocionEspecialSucursalController.class.getName()).log(Level.SEVERE, null, ex);
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
