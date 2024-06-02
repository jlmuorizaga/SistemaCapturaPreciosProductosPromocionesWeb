/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.appixsoftware.cheesepizza.app.controller;

import com.appixsoftware.cheesepizza.app.dto.RelacionProductoSucursalDto;
import com.appixsoftware.cheesepizza.app.dto.SucursalDto;
import com.appixsoftware.cheesepizza.app.persistence.RelacionProductoSucursalDao;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
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
public class RelacionProductoSucursalController extends HttpServlet {

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
                    String idProducto = request.getParameter("idProducto");
                    String precioNormal = request.getParameter("precioNormal");
                    String aplicaBebidaChicaGratis=request.getParameter("aplicaBebidaChicaGratis");

                    RelacionProductoSucursalDto r = new RelacionProductoSucursalDto();

                    r.setIdProducto(idProducto);
                    //r.setIdSucursal(idSucursal);
                    r.setIdSucursal(sucursal.getId());
                    r.setPrecioNormal(new BigDecimal(precioNormal));
                    r.setAplicaBebidaChicaGratis(aplicaBebidaChicaGratis);
                   RelacionProductoSucursalDao.insertaRelacionProductoSucursal(r);                    

                    List<RelacionProductoSucursalDto> listaRelacionProductoSucursal = RelacionProductoSucursalDao.dameListaRelacionProductoSucursal(sucursal.getId());
                    sesion.setAttribute("listaRelacionProductoSucursal", listaRelacionProductoSucursal);
                    request.getRequestDispatcher("relacionproductosucursal.jsp").forward(request, response);
                    break;
                case "borrar":
                    idProducto = request.getParameter("idProducto");
                    String idSucursal = request.getParameter("idSucursal");

                    r = new RelacionProductoSucursalDto();

                    r.setIdProducto(idProducto);
                    r.setIdSucursal(idSucursal);

                    RelacionProductoSucursalDao.borraRelacionProductoSucursal(r);
                    listaRelacionProductoSucursal = RelacionProductoSucursalDao.dameListaRelacionProductoSucursal(sucursal.getId());
                    sesion.setAttribute("listaRelacionProductoSucursal", listaRelacionProductoSucursal);
                    request.getRequestDispatcher("relacionproductosucursal.jsp").forward(request, response);
                    break;
                case "editar":
                    idProducto = request.getParameter("idProducto");
                    idSucursal = request.getParameter("idSucursal");
                    precioNormal = request.getParameter("precioNormal");
                    aplicaBebidaChicaGratis=request.getParameter("aplicaBebidaChicaGratis");
                    request.setAttribute("idProducto", idProducto);
                    request.setAttribute("idSucursal", idSucursal);
                    request.setAttribute("precioNormal", precioNormal);
                    request.setAttribute("aplicaBebidaChicaGratis", aplicaBebidaChicaGratis);
                    request.getRequestDispatcher("editarrelacionproductosucursal.jsp").forward(request, response);
                    break;
                case "guardaedicion":
                    idProducto = request.getParameter("idProducto");
                    //idSucursal = request.getParameter("idSucursal");
                    precioNormal = request.getParameter("precioNormal");
                    aplicaBebidaChicaGratis=request.getParameter("aplicaBebidaChicaGratis");

                    r = new RelacionProductoSucursalDto();

                    r.setIdProducto(idProducto);
                    r.setIdSucursal(sucursal.getId());
                    r.setPrecioNormal(new BigDecimal(precioNormal));
                    r.setAplicaBebidaChicaGratis(aplicaBebidaChicaGratis);
                    
                    RelacionProductoSucursalDao.editaRelacionProductoSucursal(r);

                    listaRelacionProductoSucursal = RelacionProductoSucursalDao.dameListaRelacionProductoSucursal(sucursal.getId());
                    sesion.setAttribute("listaRelacionProductoSucursal", listaRelacionProductoSucursal);
                    request.getRequestDispatcher("relacionproductosucursal.jsp").forward(request, response);
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
            Logger.getLogger(RelacionProductoSucursalController.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(RelacionProductoSucursalController.class.getName()).log(Level.SEVERE, null, ex);
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
