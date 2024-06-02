/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.appixsoftware.cheesepizza.app.controller;

import com.appixsoftware.cheesepizza.app.dto.RelacionEspecialidadTamanioPrecioSucursalDto;
import com.appixsoftware.cheesepizza.app.dto.SucursalDto;
import com.appixsoftware.cheesepizza.app.persistence.RelacionEspecialidadTamanioPrecioSucursalDao;
import com.appixsoftware.cheesepizza.app.utils.UniqueKey;
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
public class RelacionEspecialidadTamanioPrecioSucursalController extends HttpServlet {

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
                    String idEspecialidad = request.getParameter("idEspecialidad");
                    String idTamanioPizza = request.getParameter("idTamanioPizza");
//                    String idSucursal = request.getParameter("idSucursal");
//                    String [] itemsSucursal = request.getParameterValues("idSucursal");
//                    for (String item : itemsSucursal) {
//                        System.out.println("idSucursal="+item);
//                        
//                    }
                    String precio = request.getParameter("precio");
                    String precioP1 = request.getParameter("precioP1");
                    String aplica2x1 = request.getParameter("aplica2x1");
                    String aplicaP1 = request.getParameter("aplicaP1");
                    String aplicaBebidaChicaGratis=request.getParameter("aplicaBebidaChicaGratis");

                    RelacionEspecialidadTamanioPrecioSucursalDto r = new RelacionEspecialidadTamanioPrecioSucursalDto();

                    r.setIdEspecialidad(idEspecialidad);
                    r.setIdTamanioPizza(idTamanioPizza);
                    //p.setId(UniqueKey.generateUniqueKey(sucursal.getClave()));
                    r.setIdSucursal(sucursal.getId());
                    //r.setIdSucursal(UniqueKey.generateUniqueKey(sucursal.getClave()));
                    r.setPrecio(new BigDecimal(precio));
                    r.setPrecioP1(new BigDecimal(precioP1));
                    r.setAplica2x1(aplica2x1);
                    r.setAplicaP1(aplicaP1);
                    r.setAplicaBebidaChicaGratis(aplicaBebidaChicaGratis);

                    RelacionEspecialidadTamanioPrecioSucursalDao.insertaRelacionEspecialidadTamanioPrecioSucursal(r);

                    List<RelacionEspecialidadTamanioPrecioSucursalDto> listaRelacionEspecialidadTamanioPrecioSucursal = 
                            RelacionEspecialidadTamanioPrecioSucursalDao.dameListaRelacionEspecialidadTamanioPrecioSucursal(sucursal.getId());
                    sesion.setAttribute("listaRelacionEspecialidadTamanioPrecioSucursal", listaRelacionEspecialidadTamanioPrecioSucursal);
                    request.getRequestDispatcher("relacionespecialidadtamaniopreciosucursal.jsp").forward(request, response);
                    break;
                case "borrar":
                    idEspecialidad = request.getParameter("idEspecialidad");
                    idTamanioPizza = request.getParameter("idTamanioPizza");
                    //idSucursal = request.getParameter("idSucursal");

                    r = new RelacionEspecialidadTamanioPrecioSucursalDto();

                    r.setIdEspecialidad(idEspecialidad);
                    r.setIdTamanioPizza(idTamanioPizza);
                    r.setIdSucursal(sucursal.getId());

                    RelacionEspecialidadTamanioPrecioSucursalDao.borraRelacionEspecialidadTamanioPrecioSucursal(r);
                    listaRelacionEspecialidadTamanioPrecioSucursal = RelacionEspecialidadTamanioPrecioSucursalDao.dameListaRelacionEspecialidadTamanioPrecioSucursal(sucursal.getId());
                    sesion.setAttribute("listaRelacionEspecialidadTamanioPrecioSucursal", listaRelacionEspecialidadTamanioPrecioSucursal);
                    request.getRequestDispatcher("relacionespecialidadtamaniopreciosucursal.jsp").forward(request, response);
                    break;
                case "editar":
                    idEspecialidad = request.getParameter("idEspecialidad");
                    idTamanioPizza = request.getParameter("idTamanioPizza");
                    //idSucursal = request.getParameter("idSucursal");
                    precio = request.getParameter("precio");
                    precioP1 = request.getParameter("precioP1");
                    aplica2x1 = request.getParameter("aplica2x1");
                    aplicaP1 = request.getParameter("aplicaP1");
                    aplicaBebidaChicaGratis=request.getParameter("aplicaBebidaChicaGratis");
                    
                    
                    request.setAttribute("idEspecialidad", idEspecialidad);
                    request.setAttribute("idTamanioPizza", idTamanioPizza);
                    request.setAttribute("idSucursal", sucursal.getId());
                    request.setAttribute("precio", precio);
                    request.setAttribute("precioP1", precioP1);
                    request.setAttribute("aplica2x1", aplica2x1);
                    request.setAttribute("aplicaP1", aplicaP1);
                    request.setAttribute("aplicaBebidaChicaGratis", aplicaBebidaChicaGratis);
                    request.getRequestDispatcher("editarrelacionespecialidadtamaniopreciosucursal.jsp").forward(request, response);
                    break;
                case "guardaedicion":
                    idEspecialidad = request.getParameter("idEspecialidad");
                    idTamanioPizza = request.getParameter("idTamanioPizza");
                    //idSucursal = request.getParameter("idSucursal");
                    precio = request.getParameter("precio");
                    precioP1=request.getParameter("precioP1");
                    aplica2x1 = request.getParameter("aplica2x1");
                    aplicaP1 = request.getParameter("aplicaP1");
                    aplicaBebidaChicaGratis=request.getParameter("aplicaBebidaChicaGratis");                    
                    
                    r = new RelacionEspecialidadTamanioPrecioSucursalDto();
                    
                    r.setIdEspecialidad(idEspecialidad);
                    r.setIdTamanioPizza(idTamanioPizza);
                    r.setIdSucursal(sucursal.getId());
                    r.setPrecio(new BigDecimal(precio));
                    r.setPrecioP1(new BigDecimal(precioP1));
                    r.setAplica2x1(aplica2x1);
                    r.setAplicaP1(aplicaP1);
                    r.setAplicaBebidaChicaGratis(aplicaBebidaChicaGratis);
                    RelacionEspecialidadTamanioPrecioSucursalDao.editaRelacionEspecialidadTamanioPrecioSucursal(r);
                    
                    listaRelacionEspecialidadTamanioPrecioSucursal = RelacionEspecialidadTamanioPrecioSucursalDao.dameListaRelacionEspecialidadTamanioPrecioSucursal(sucursal.getId());
                    sesion.setAttribute("listaRelacionEspecialidadTamanioPrecioSucursal", listaRelacionEspecialidadTamanioPrecioSucursal);
                    request.getRequestDispatcher("relacionespecialidadtamaniopreciosucursal.jsp").forward(request, response);
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
            Logger.getLogger(RelacionEspecialidadTamanioPrecioSucursalController.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(RelacionEspecialidadTamanioPrecioSucursalController.class.getName()).log(Level.SEVERE, null, ex);
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
