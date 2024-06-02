/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.appixsoftware.cheesepizza.app.controller;

import com.appixsoftware.cheesepizza.app.dto.EspecialidadPizzaDto;
import com.appixsoftware.cheesepizza.app.dto.LugarDto;
import com.appixsoftware.cheesepizza.app.dto.ProductoDto;
import com.appixsoftware.cheesepizza.app.dto.ProductoTipoDto;
import com.appixsoftware.cheesepizza.app.dto.PromocionEspecialDto;
import com.appixsoftware.cheesepizza.app.dto.RelacionEspecialidadTamanioPrecioSucursalDto;
import com.appixsoftware.cheesepizza.app.dto.RelacionProductoSucursalDto;
import com.appixsoftware.cheesepizza.app.dto.RelacionPromocionEspecialSucursalDto;
import com.appixsoftware.cheesepizza.app.dto.RelacionSalsaSucursalDto;
import com.appixsoftware.cheesepizza.app.dto.SalsaDto;
import com.appixsoftware.cheesepizza.app.dto.SucursalDto;
import com.appixsoftware.cheesepizza.app.dto.TamanioPizzaDto;
import com.appixsoftware.cheesepizza.app.dto.UsuarioDto;
import com.appixsoftware.cheesepizza.app.persistence.EspecialidadPizzaDao;
import com.appixsoftware.cheesepizza.app.persistence.LugarDao;
import com.appixsoftware.cheesepizza.app.persistence.ProductoDao;
import com.appixsoftware.cheesepizza.app.persistence.ProductoTipoDao;
import com.appixsoftware.cheesepizza.app.persistence.PromocionEspecialDao;
import com.appixsoftware.cheesepizza.app.persistence.RelacionEspecialidadTamanioPrecioSucursalDao;
import com.appixsoftware.cheesepizza.app.persistence.RelacionProductoSucursalDao;
import com.appixsoftware.cheesepizza.app.persistence.RelacionPromocionEspecialSucursalDao;
import com.appixsoftware.cheesepizza.app.persistence.RelacionSalsaSucursalDao;
import com.appixsoftware.cheesepizza.app.persistence.SalsaDao;
import com.appixsoftware.cheesepizza.app.persistence.SucursalDao;
import com.appixsoftware.cheesepizza.app.persistence.TamanioPizzaDao;
import com.appixsoftware.cheesepizza.app.persistence.UsuarioDao;
import com.google.gson.Gson;
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
public class ValidaUsuario extends HttpServlet {

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
        try (PrintWriter data = response.getWriter()) {
            HttpSession sesion = request.getSession();
            String usuario = request.getParameter("usuario");
            String contrasenia = request.getParameter("contrasenia");
            String sucursal = request.getParameter("sucursal");
            UsuarioDto u = new UsuarioDto();
            String urlServidor="http://ec2-52-53-193-189.us-west-1.compute.amazonaws.com/";
            u.setUsuario(usuario);
            u.setContrasenia(contrasenia);
            UsuarioDto usu = UsuarioDao.dameUsuario(u);
            if (usu != null) {
                data.print(new Gson().toJson(usu));
            } else {
                data.print("null");
            }
            SucursalDto s = SucursalDao.getSucursal(sucursal);
            List<TamanioPizzaDto> listaTamanioPizza = TamanioPizzaDao.dameListaTamanioPizza(s.getClave());
            sesion.setAttribute("listaTamanioPizza", listaTamanioPizza);

            List<EspecialidadPizzaDto> listaEspecialidadPizza = EspecialidadPizzaDao.dameListaEspecialidadPizza();
            sesion.setAttribute("listaEspecialidadPizza", listaEspecialidadPizza);

            List<ProductoTipoDto> listaProductoTipo = ProductoTipoDao.dameListaProductoTipo(s.getClave());
            sesion.setAttribute("listaProductoTipo", listaProductoTipo);

            List<SalsaDto> listaSalsa = SalsaDao.dameListaSalsa();
            sesion.setAttribute("listaSalsa", listaSalsa);

            List<LugarDto> listaLugar = LugarDao.dameListaLugar();
            sesion.setAttribute("listaLugar", listaLugar);

            List<SucursalDto> listaSucursal = SucursalDao.dameListaSucursales();
            sesion.setAttribute("listaSucursal", listaSucursal);

            List<RelacionEspecialidadTamanioPrecioSucursalDto> listaRelacionEspecialidadTamanioPrecioSucursal = RelacionEspecialidadTamanioPrecioSucursalDao.dameListaRelacionEspecialidadTamanioPrecioSucursal(s.getId());
            sesion.setAttribute("listaRelacionEspecialidadTamanioPrecioSucursal", listaRelacionEspecialidadTamanioPrecioSucursal);

            List<ProductoDto> listaProducto = ProductoDao.dameListaProductos();
            sesion.setAttribute("listaProducto", listaProducto);

            List<PromocionEspecialDto> listaPromocion = PromocionEspecialDao.dameListaPromocionEspecial();
            sesion.setAttribute("listaPromocion", listaPromocion);

            List<RelacionProductoSucursalDto> listaRelacionProductoSucursal = RelacionProductoSucursalDao.dameListaRelacionProductoSucursal(s.getId());
            sesion.setAttribute("listaRelacionProductoSucursal", listaRelacionProductoSucursal);

            List<RelacionPromocionEspecialSucursalDto> listaRelacionPromocionEspecialSucursal = RelacionPromocionEspecialSucursalDao.dameListaRelacionPromocionEspecialSucursal(s.getId());
            sesion.setAttribute("listaRelacionPromocionEspecialSucursal", listaRelacionPromocionEspecialSucursal);

            List<RelacionSalsaSucursalDto> listaRelacionSalsaSucursal = RelacionSalsaSucursalDao.dameListaRelacionSalsaSucursal(s.getId());
            sesion.setAttribute("listaRelacionSalsaSucursal", listaRelacionSalsaSucursal);  
            
            sesion.setAttribute("urlServidor", urlServidor);

            sesion.setAttribute("sucursal", s);
            sesion.setAttribute("usuario", usu);
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
            Logger.getLogger(ValidaUsuario.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(ValidaUsuario.class.getName()).log(Level.SEVERE, null, ex);
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
