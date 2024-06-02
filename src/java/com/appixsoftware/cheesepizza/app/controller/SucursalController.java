/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.appixsoftware.cheesepizza.app.controller;

import com.appixsoftware.cheesepizza.app.dto.SucursalDto;
import com.appixsoftware.cheesepizza.app.persistence.SucursalDao;
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
public class SucursalController extends HttpServlet {

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
                    String clave = request.getParameter("clave");
                    String nombreSucursal = request.getParameter("nombreSucursal");
                    String rfc = request.getParameter("rfc");
                    String domicilio = request.getParameter("domicilio");
                    String telefono = request.getParameter("telefono");
                    String horaInicio = request.getParameter("horaInicio");
                    String horaFin = request.getParameter("horaFin");
                    String latitud = request.getParameter("latitud");
                    String longitud = request.getParameter("longitud");
                    String idLugar = request.getParameter("idLugar");
                    String ventaActiva=request.getParameter("ventaActiva");
                    SucursalDto s = new SucursalDto();
                    s.setId(UniqueKey.generateUniqueKey("00CHP"));
                    s.setClave(clave);
                    s.setNombreSucursal(nombreSucursal);
                    s.setRfc(rfc);
                    s.setDomicilio(domicilio);
                    s.setTelefono(telefono);
                    s.setHoraInicio(horaInicio);
                    s.setHoraFin(horaFin);
                    s.setLatitud(Double.parseDouble(latitud));
                    s.setLongitud(Double.parseDouble(longitud));
                    s.setIdLugar(idLugar);
                    s.setVentaActiva(ventaActiva);
                    SucursalDao.insertaSucursalNueva(s);
                    List<SucursalDto> listaSucursal = SucursalDao.dameListaSucursales();
                    sesion.setAttribute("listaSucursal", listaSucursal);
                    request.getRequestDispatcher("sucursal.jsp").forward(request, response);
                    break;
                case "borrar":
                    String id = request.getParameter("id");
                    s = new SucursalDto();
                    s.setId(id);
                    SucursalDao.borraSucursal(s);
                    listaSucursal = SucursalDao.dameListaSucursales();
                    sesion.setAttribute("listaSucursal", listaSucursal);
                    request.getRequestDispatcher("sucursal.jsp").forward(request, response);
                    break;
                case "editar":
                    id = request.getParameter("id");
                    clave = request.getParameter("clave");
                    nombreSucursal = request.getParameter("nombreSucursal");
                    rfc = request.getParameter("rfc");
                    domicilio = request.getParameter("domicilio");
                    telefono = request.getParameter("telefono");
                    horaInicio = request.getParameter("horaInicio");
                    horaFin = request.getParameter("horaFin");
                    latitud = request.getParameter("latitud");
                    longitud = request.getParameter("longitud");
                    idLugar = request.getParameter("idLugar");
                    ventaActiva=request.getParameter("ventaActiva");                            
                    request.setAttribute("id", id);
                    request.setAttribute("clave", clave);
                    request.setAttribute("nombreSucursal", nombreSucursal);
                    request.setAttribute("rfc", rfc);
                    request.setAttribute("domicilio", domicilio);
                    request.setAttribute("telefono", telefono);
                    request.setAttribute("horaInicio", horaInicio);
                    request.setAttribute("horaFin", horaFin);
                    request.setAttribute("latitud", latitud);
                    request.setAttribute("longitud", longitud);
                    request.setAttribute("idLugar", idLugar);
                    request.setAttribute("ventaActiva", ventaActiva);
                    request.getRequestDispatcher("editarsucursal.jsp").forward(request, response);
                    break;
                case "guardaedicion":
                    id = request.getParameter("id");
                    clave = request.getParameter("clave");
                    nombreSucursal = request.getParameter("nombreSucursal");
                    rfc = request.getParameter("rfc");
                    domicilio = request.getParameter("domicilio");
                    telefono = request.getParameter("telefono");
                    horaInicio = request.getParameter("horaInicio");
                    horaFin = request.getParameter("horaFin");
                    latitud = request.getParameter("latitud");
                    longitud = request.getParameter("longitud");
                    idLugar = request.getParameter("idLugar");
                    ventaActiva=request.getParameter("ventaActiva");
                    s = new SucursalDto();
                    s.setId(id);
                    s.setClave(clave);
                    s.setNombreSucursal(nombreSucursal);
                    s.setRfc(rfc);
                    s.setDomicilio(domicilio);
                    s.setTelefono(telefono);
                    s.setHoraInicio(horaInicio);
                    s.setHoraFin(horaFin);
                    s.setLatitud(Double.parseDouble(latitud));
                    s.setLongitud(Double.parseDouble(longitud));
                    s.setIdLugar(idLugar);
                    s.setVentaActiva(ventaActiva);
                    SucursalDao.editaSucursal(s);
                    listaSucursal = SucursalDao.dameListaSucursales();
                    sesion.setAttribute("listaSucursal", listaSucursal);
                    request.getRequestDispatcher("sucursal.jsp").forward(request, response);
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
            Logger.getLogger(SucursalController.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(SucursalController.class.getName()).log(Level.SEVERE, null, ex);
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
