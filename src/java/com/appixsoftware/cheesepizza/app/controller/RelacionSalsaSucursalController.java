/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.appixsoftware.cheesepizza.app.controller;

import com.appixsoftware.cheesepizza.app.dto.RelacionSalsaSucursalDto;
import com.appixsoftware.cheesepizza.app.dto.SucursalDto;
import com.appixsoftware.cheesepizza.app.persistence.RelacionSalsaSucursalDao;
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
public class RelacionSalsaSucursalController extends HttpServlet {

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
            String accion=request.getParameter("accion");
            HttpSession sesion=request.getSession();
            SucursalDto sucursal=(SucursalDto) sesion.getAttribute("sucursal");
            
            switch (accion){
                case "insertar":
                String idSalsa=request.getParameter("idSalsa");
                RelacionSalsaSucursalDto r=new RelacionSalsaSucursalDto();
                r.setIdSalsa(idSalsa);
                r.setIdSucursal(sucursal.getId());
                RelacionSalsaSucursalDao.insertaRelacionSalsaSucursal(r);
                    List<RelacionSalsaSucursalDto> listaRelacionSalsaSucursal = RelacionSalsaSucursalDao.dameListaRelacionSalsaSucursal(sucursal.getId());
                    sesion.setAttribute("listaRelacionSalsaSucursal", listaRelacionSalsaSucursal);
                    request.getRequestDispatcher("relacionsalsasucursal.jsp").forward(request, response);
                    break;
                case "borrar":
                    idSalsa = request.getParameter("idSalsa");
                    String idSucursal = request.getParameter("idSucursal");
                    r = new RelacionSalsaSucursalDto();
                    r.setIdSalsa(idSalsa);
                    r.setIdSucursal(idSucursal);
                    RelacionSalsaSucursalDao.borraRelacionSalsaSucursal(r);
                    listaRelacionSalsaSucursal = RelacionSalsaSucursalDao.dameListaRelacionSalsaSucursal(sucursal.getId());
                    sesion.setAttribute("listaRelacionSalsaSucursal", listaRelacionSalsaSucursal);
                    request.getRequestDispatcher("relacionsalsasucursal.jsp").forward(request, response);
                    break;
                case "editar":
                    idSalsa = request.getParameter("idSalsa");
                    idSucursal = request.getParameter("idSucursal");
                    request.setAttribute("idSalsa", idSalsa);
                    request.setAttribute("idSucursal", idSucursal);
                    request.getRequestDispatcher("editarrelacionsalsasucursal.jsp").forward(request, response);
                    break;
                case "guardaedicion":
                    idSalsa = request.getParameter("idSalsa");
                    r = new RelacionSalsaSucursalDto();
                    r.setIdSalsa(idSalsa);
                    r.setIdSucursal(sucursal.getId());
                    RelacionSalsaSucursalDao.editaRelacionSalsaSucursal(r);
                    listaRelacionSalsaSucursal = RelacionSalsaSucursalDao.dameListaRelacionSalsaSucursal(sucursal.getId());
                    sesion.setAttribute("listaRelacionSalsaSucursal", listaRelacionSalsaSucursal);
                    request.getRequestDispatcher("relacionsalsasucursal.jsp").forward(request, response);
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
            Logger.getLogger(RelacionSalsaSucursalController.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(RelacionSalsaSucursalController.class.getName()).log(Level.SEVERE, null, ex);
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
