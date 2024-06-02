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
        <link rel="stylesheet" href="css/tablestyle.css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Insertar Promocion, Sucursal</title>
    </head>
    <body>
        <jsp:include page="encabezado.jsp"/>   
        <jsp:include page="menu.jsp"/>  
    <center>
        <h3>Promoción, Sucursal</h3>      
        <form action="relacionPromocionEspecialSucursalController.do">
            <table border="0">
                <tr align="center">
                    <td>
                        <label>Promoción</label><br>
                        <select name="idPromocion" id="idPromocion" style="width:1000px" size="15">
                            <c:forEach var="dato" items="${listaPromocion}">
                                <option value="${dato.getId()}">${dato.getDefinicion()}</option>
                            </c:forEach>  
                        </select>
                    </td>
                </tr>
                <tr align="center">
                    <td>
                        <label>Activa</label><br>
                        <input type="text" id="activa" name="activa">
                    </td>
                </tr>
            </table><br>
            <input type="hidden" id="accion" name="accion" value="insertar">
            <input type="submit" value="Insertar" class="btnverde">
        </form>
    </center>
</body>
</html>
