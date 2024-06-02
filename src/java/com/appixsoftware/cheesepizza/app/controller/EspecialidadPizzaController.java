/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.appixsoftware.cheesepizza.app.controller;

import com.appixsoftware.cheesepizza.app.dto.EspecialidadPizzaDto;
import com.appixsoftware.cheesepizza.app.dto.SucursalDto;
import com.appixsoftware.cheesepizza.app.dto.TamanioPizzaDto;
import com.appixsoftware.cheesepizza.app.persistence.EspecialidadPizzaDao;
import com.appixsoftware.cheesepizza.app.persistence.TamanioPizzaDao;
import com.appixsoftware.cheesepizza.app.utils.UniqueKey;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;
import org.apache.tomcat.util.http.fileupload.disk.DiskFileItemFactory;

/**
 *
 * @author LUIS.MU
 */
@MultipartConfig
public class EspecialidadPizzaController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    private String saveFile(Part part, File pathUploads, String nombreImagen) {
        String pathAbsolute = "";
        try {
            Path path = Paths.get(part.getSubmittedFileName());
            //String fileName = path.getFileName().toString();
            //String fileName = nombreImagen;
            String fileName=path.toString();
            InputStream input = part.getInputStream();
            if (input != null) {
                File file = new File(pathUploads, fileName);
                //pathAbsolute=file.getAbsolutePath();
                //pathAbsolute = "/img/especialidades/" + fileName;
                //pathAbsolute = "/var/www/html/img/especialidades/" + fileName;
                //pathAbsolute = "/home/ubuntu/api-rest-pedidos/img/especialidades/" + fileName;
                pathAbsolute = "\\home\\ubuntu\\api-rest-pedidos\\img\\especialidades\\" + fileName;
                
//                if (!Files.exists(file.toPath())) {
                Files.copy(input, file.toPath());
                //Files.move(input)
                //              }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return pathAbsolute;
    }

    private boolean isExtension(String fileName, String[] extensions) {
        for (String et : extensions) {
            if (fileName.toLowerCase().endsWith(et)) {
                return true;
            }
        }
        return false;
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        //response.setContentType("text/html;charset=UTF-8");
        response.setContentType("text/html;charset=ISO-8859-1");
        try {
            //String pathFiles = "D:\\NetBeansProjects\\CHPSystem\\2023\\SistemaCapturaPreciosProductosPromocionesWeb\\web\\img\\";
            //String pathFiles="D:\\CHPAppMovil\\Desarrollo\\api-rest-pedidos\\img\\especialidades\\";
            String pathFiles="/img/especialidades/";
            File uploads = new File(pathFiles);
            String[] extensiones = {"*.png", "*.jpg", "*.jpeg"};
            //           processRequest(request, response);
            String accion = request.getParameter("accion");
            HttpSession sesion = request.getSession();
            SucursalDto sucursal = (SucursalDto) sesion.getAttribute("sucursal");
            switch (accion) {
                case "insertar":
                    String nombreEspecialidad = request.getParameter("nombreEspecialidad");
                    String ingredientesEspecialidad = request.getParameter("ingredientesEspecialidad");
                    String aplica2x1Especialidad=request.getParameter("aplica2x1Especialidad");
                    String aplicaP1Especialidad=request.getParameter("aplicaP1Especialidad");
                    Part part = request.getPart("imagenEspecialidad");
                    
                    Path path = Paths.get(part.getSubmittedFileName());
                    String fileName=path.toString();

                    
                    String nombreImagen = UniqueKey.generateUniqueKey("00CHP") + ".jpg";
                    String imagen = saveFile(part, uploads, nombreImagen);
                    EspecialidadPizzaDto e = new EspecialidadPizzaDto();
                    e.setIdEspecialidad(UniqueKey.generateUniqueKey("00CHP"));
                    e.setNombreEspecialidad(nombreEspecialidad);
                    e.setIngredientesEspecialidad(ingredientesEspecialidad);
                    e.setAplica2x1Especialidad(aplica2x1Especialidad);
                    e.setAplicaP1Especialidad(aplicaP1Especialidad);
                    
                    //Agrega a img_url: pathFiles: /img/especialidades+
                    //                  fileName : nombre_archivo
                    e.setImgUrl(pathFiles+fileName);
                    EspecialidadPizzaDao.insertaEspecialidadPizza(e);
                    List<EspecialidadPizzaDto> listaEspecialidadPizza = EspecialidadPizzaDao.dameListaEspecialidadPizza();
                    sesion.setAttribute("listaEspecialidadPizza", listaEspecialidadPizza);
                    request.getRequestDispatcher("catalogoespecialidades.jsp").forward(request, response);
                    break;
                case "borrar":
                    String id = request.getParameter("id");
                    e = new EspecialidadPizzaDto();
                    e.setIdEspecialidad(id);
                    EspecialidadPizzaDao.borraEspecialidadPizza(e);
                    listaEspecialidadPizza = EspecialidadPizzaDao.dameListaEspecialidadPizza();
                    sesion.setAttribute("listaEspecialidadPizza", listaEspecialidadPizza);
                    request.getRequestDispatcher("catalogoespecialidades.jsp").forward(request, response);
                    break;
                case "editar":
                    String idEspecialidad = request.getParameter("id");
                    nombreEspecialidad = request.getParameter("nombre");
                    ingredientesEspecialidad = request.getParameter("ingredientes");
                    aplica2x1Especialidad=request.getParameter("aplica2x1Especialidad");
                    aplicaP1Especialidad=request.getParameter("aplicaP1Especialidad");
                    
                    String imgUrl = request.getParameter("imgUrl");
                    request.setAttribute("idEspecialidad", idEspecialidad);
                    request.setAttribute("nombreEspecialidad", nombreEspecialidad);
                    request.setAttribute("ingredientesEspecialidad", ingredientesEspecialidad);
                    request.setAttribute("aplica2x1Especialidad",aplica2x1Especialidad);
                    request.setAttribute("aplicaP1Especialidad",aplicaP1Especialidad);
                    request.setAttribute("imgUrl", imgUrl);
                    request.getRequestDispatcher("editarespecialidad.jsp").forward(request, response);
                    break;
                case "guardaedicion":
                    idEspecialidad = request.getParameter("idEspecialidad");
                    nombreEspecialidad = request.getParameter("nombreEspecialidad");
                    ingredientesEspecialidad = request.getParameter("ingredientesEspecialidad");
                    part = request.getPart("imagenEspecialidad");
                    nombreImagen = UniqueKey.generateUniqueKey("00CHP") + ".jpg";
                    imagen = saveFile(part, uploads, nombreImagen);
                    //inputStream = part2.getInputStream();
                    e = new EspecialidadPizzaDto();
                    e.setIdEspecialidad(idEspecialidad);
                    e.setNombreEspecialidad(nombreEspecialidad);
                    e.setIngredientesEspecialidad(ingredientesEspecialidad);
                    e.setImgUrl(imagen);
                    //e.setImagenEspecialidad(inputStream);
                    EspecialidadPizzaDao.editaEspecialidadPizza(e);
                    listaEspecialidadPizza = EspecialidadPizzaDao.dameListaEspecialidadPizza();
                    sesion.setAttribute("listaEspecialidadPizza", listaEspecialidadPizza);
                    request.getRequestDispatcher("catalogoespecialidades.jsp").forward(request, response);
                    break;
                default:
                    break;
            }

        } catch (SQLException ex) {
            Logger.getLogger(EspecialidadPizzaController.class.getName()).log(Level.SEVERE, null, ex);
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
//    protected void doGet(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//        //       try {
//        //           processRequest(request, response);
////            String id = request.getParameter("id");
////            EspecialidadPizzaDao e = new EspecialidadPizzaDao();
////            e.listarImagen(id, response);
////        } catch (SQLException ex) {
//        Logger.getLogger(EspecialidadPizzaController.class.getName()).log(Level.SEVERE, null, ex);
//    }
//}

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
//    protected void doPost(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//        response.setContentType("text/html;charset=ISO-8859-1");
//        try {
//            String pathFiles = "D:\\NetBeansProjects\\CHPSystem\\2023\\SistemaCapturaPreciosProductosPromocionesWeb\\web\\img\\";
//            File uploads = new File(pathFiles);
//            //processRequest(request, response);
//            String accion = request.getParameter("accion");
//            HttpSession sesion = request.getSession();
//            SucursalDto sucursal = (SucursalDto) sesion.getAttribute("sucursal");
//            switch (accion) {
//                case "insertar":
//                    String nombreEspecialidad = request.getParameter("nombreEspecialidad");
//                    String ingredientesEspecialidad = request.getParameter("ingredientesEspecialidad");
//                    Part part = request.getPart("imagenEspecialidad");
//                    
//                    String nombreImagen=UniqueKey.generateUniqueKey("00CHP")+".jpg";
//                    String imagen = saveFile(part, uploads,nombreImagen);
//                    EspecialidadPizzaDto e = new EspecialidadPizzaDto();
//                    e.setIdEspecialidad(UniqueKey.generateUniqueKey("00CHP"));
//                    e.setNombreEspecialidad(nombreEspecialidad);
//                    e.setIngredientesEspecialidad(ingredientesEspecialidad);
//                    e.setRutaImagen(imagen);
//                    EspecialidadPizzaDao.insertaEspecialidadPizza(e);
//                    List<EspecialidadPizzaDto> listaEspecialidadPizza = EspecialidadPizzaDao.dameListaEspecialidadPizza();
//                    sesion.setAttribute("listaEspecialidadPizza", listaEspecialidadPizza);
//                    request.getRequestDispatcher("catalogoespecialidades.jsp").forward(request, response);
//                    break;
//                case "borrar":
////                    String id = request.getParameter("id");
////                    e = new EspecialidadPizzaDto();
////                    e.setIdEspecialidad(id);
////                    EspecialidadPizzaDao.borraEspecialidadPizza(e);
////                    listaEspecialidadPizza = EspecialidadPizzaDao.dameListaEspecialidadPizza();
////                    sesion.setAttribute("listaEspecialidadPizza", listaEspecialidadPizza);
////                    request.getRequestDispatcher("catalogoespecialidades.jsp").forward(request, response);
////                    break;
//                case "editar":
////                    String idEspecialidad = request.getParameter("id");
////                    nombreEspecialidad = request.getParameter("nombre");
////                    ingredientesEspecialidad = request.getParameter("ingredientes");
////                    request.setAttribute("idEspecialidad", idEspecialidad);
////                    request.setAttribute("nombreEspecialidad", nombreEspecialidad);
////                    request.setAttribute("ingredientesEspecialidad", ingredientesEspecialidad);
////                    request.getRequestDispatcher("editarespecialidad.jsp").forward(request, response);
////                    break;
//                case "guardaedicion":
//                    String idEspecialidad = request.getParameter("idEspecialidad");
//                    nombreEspecialidad = request.getParameter("nombreEspecialidad");
//                    ingredientesEspecialidad = request.getParameter("ingredientesEspecialidad");
//                    part = request.getPart("imagenEspecialidad");
//                    nombreImagen=UniqueKey.generateUniqueKey("00CHP")+".jpg";
//                    imagen=saveFile(part,uploads,nombreImagen);
//                    //inputStream = part2.getInputStream();
//                    e = new EspecialidadPizzaDto();
//                    e.setIdEspecialidad(idEspecialidad);
//                    e.setNombreEspecialidad(nombreEspecialidad);
//                    e.setIngredientesEspecialidad(ingredientesEspecialidad);
//                    e.setRutaImagen(imagen);
//                    //e.setImagenEspecialidad(inputStream);
//                    EspecialidadPizzaDao.editaEspecialidadPizza(e);
//                    listaEspecialidadPizza = EspecialidadPizzaDao.dameListaEspecialidadPizza();
//                    sesion.setAttribute("listaEspecialidadPizza", listaEspecialidadPizza);
//                    request.getRequestDispatcher("catalogoespecialidades.jsp").forward(request, response);
//                    break;
//                default:
//                    break;
//            }
//
//        } catch (SQLException ex) {
//            Logger.getLogger(EspecialidadPizzaController.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }

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
