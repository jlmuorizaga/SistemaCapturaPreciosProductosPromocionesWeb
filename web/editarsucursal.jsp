<%-- 
    Document   : editartamaniopizza
    Created on : 7/04/2023, 11:40:22 AM
    Author     : LUIS.MU
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="css/estiloboton.css">
        <!--link rel="stylesheet" href="css/tablestyle.css"-->
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Editar Sucursal</title>
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
                        <input type="text" id="clave" name="clave" value="${clave}">
                    </td>
                    <td>
                        <label>Nombre Sucursal</label><br>
                        <input type="text" id="nombreSucursal" name="nombreSucursal" value="${nombreSucursal}">
                    </td>
                </tr>
                <tr>
                    <td>
                        <label>RFC</label><br>
                        <input type="text" id="rfc" name="rfc" value="${rfc}">
                    </td>
                    <td>
                        <label>Teléfono</label><br>
                        <input type="text" id="telefono" name="telefono" value="${telefono}">
                    </td>
                </tr>
                <tr align="center">
                    <td colspan="2">
                        <label>Domicilio</label><br>
                        <input type="text" id="domicilio" name="domicilio" value="${domicilio}">
                    </td>
                </tr>

                <tr>
                    <td>
                        <label>Hora Inicio</label><br>
                        <input type="text" id="horaInicio" name="horaInicio" value="${horaInicio}">
                    </td>
                    <td>
                        <label>Hora Fin</label><br>
                        <input type="text" id="horaFin" name="horaFin" value="${horaFin}">
                    </td>
                </tr>
                <tr>
                    <td>
                        <label>Latitud</label><br>
                        <input type="text" id="latitud" name="latitud" value="${latitud}">
                    </td>
                    <td>
                        <label>Longitud</label><br>
                        <input type="text" id="longitud" name="longitud" value="${longitud}">
                    </td>
                </tr>

                <tr align="center">
                    <td colspan="2">
                        <label>Lugar</label><br>
                        <select name="idLugar" id="idLugar">
                            <c:forEach var="dato" items="${listaLugar}">
                                <c:choose>
                                    <c:when test="${dato.getId()==idLugar}">
                                        <option value="${dato.getId()}" selected>${dato.getId()} - ${dato.getNombre()}</option>
                                    </c:when>
                                    <c:otherwise>
                                        <option value="${dato.getId()}">${dato.getId()} -  ${dato.getNombre()}</option>
                                    </c:otherwise>                                
                                </c:choose>
                            </c:forEach>  
                        </select>
                    </td>
                </tr>

                <tr align="center">
                    <td colspan="2">
                        <label>Venta Activa</label><br>
                        <c:choose>
                            <c:when test="${ventaActiva=='S'}">
                                <input type="radio" id="ventaActiva" name="ventaActiva" value="S" checked>Si
                                <input type="radio" id="ventaActiva" name="ventaActiva" value="N">No
                            </c:when>
                            <c:otherwise>
                                <input type="radio" id="ventaActiva" name="ventaActiva" value="S">Si
                                <input type="radio" id="ventaActiva" name="ventaActiva" value="N" checked>No
                            </c:otherwise>
                        </c:choose>
                    </td>
                </tr>                   



            </table>
            <input type="hidden" id="id" name="id" value="${id}"><br><br>
            <input type="hidden" id="accion" name="accion" value="guardaedicion">
            <input type="submit" value="Editar" class="btnazul">            

        </form>
    </center>
</body>
</html>
