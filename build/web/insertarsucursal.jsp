<%-- 
    Document   : insertartamaniopizza
    Created on : 7/04/2023, 01:14:35 AM
    Author     : LUIS.MU
--%>

<!DOCTYPE html>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>
    <head>
        <link rel="stylesheet" href="css/estiloboton.css">
        <!--link rel="stylesheet" href="css/tablestyle.css"-->
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Insertar Sucursal</title>
    </head>
    <body>
        <jsp:include page="encabezado.jsp"/>   
        <jsp:include page="menu.jsp"/>  
    <center>
        <h3>Catálogo Sucursales</h3>      
        <form action="sucursalController.do">
            <table border="0" width="20%">
                <tr align="center">
                    <td>
                        <label>Clave Sucursal</label><br>
                        <input type="text" id="clave" name="clave">
                    </td>
                    <td>
                        <label>Nombre Sucursal</label><br>
                        <input type="text" id="nombreSucursal" name="nombreSucursal">
                    </td>
                </tr>

                <tr align="center">
                    <td>
                        <label>RFC</label><br>
                        <input type="text" id="rfc" name="rfc">
                    </td>
                    <td>
                        <label>Teléfono</label><br>
                        <input type="text" id="telefono" name="telefono">
                    </td>
                </tr>

                <tr align="center">
                    <td colspan="2">
                        <label>Domicilio</label><br>
                        <input type="text" id="domicilio" name="domicilio">
                    </td>
                </tr>

                <tr align="center">
                    <td>
                        <label>Hora Inicio</label><br>
                        <input type="text" id="horaInicio" name="horaInicio">
                    </td>
                    <td>
                        <label>Hora Fin</label><br>
                        <input type="text" id="horaFin" name="horaFin">
                    </td>
                </tr>

                <tr align="center">
                    <td>
                        <label>Latitud</label><br>
                        <input type="text" id="latitud" name="latitud">
                    </td>
                    <td>
                        <label>Longitud</label><br>
                        <input type="text" id="longitud" name="longitud">
                    </td>
                </tr>

                <tr align="center">
                    <td colspan="2">
                        <label>Lugar</label><br>
                        <select name="idLugar" id="idLugar">
                            <c:forEach var="dato" items="${listaLugar}">
                                <option value="${dato.getId()}">${dato.getId()} -  ${dato.getNombre()}</option>
                            </c:forEach>  
                        </select>
                    </td>
                </tr>
                <tr align="center">
                    <td colspan="2">
                        <label>Venta Activa</label><br>
                        <input type="text" id="ventaActiva" name="ventaActiva">
                    </td>
                </tr>
            </table><br>
            <input type="hidden" id="accion" name="accion" value="insertar">
            <input type="submit" value="Insertar" class="btnverde">
        </form>
    </center>
</body>
</html>
