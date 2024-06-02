<%-- 
    Document   : insertarsalsasucursal
    Created on : 4/03/2024, 09:39:33 PM
    Author     : jlmuo
--%>

<!DOCTYPE html>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>
    <head>
        <link rel="stylesheet" href="css/estiloboton.css">
        <link rel="stylesheet" href="css/tablestyle.css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Insertar Salsa, Sucursal</title>
    </head>
    <body>
        <jsp:include page="encabezado.jsp"/>   
        <jsp:include page="menu.jsp"/>  
    <center>
        <h3>Insertar Salsa, Sucursal</h3>      
        <form action="relacionSalsaSucursalController.do">
            <table border="0">
                <tr align="center">
                    <td>
                        <label>Salsa</label><br>
                        <select name="idSalsa" id="idSalsa">
                            <c:forEach var="dato" items="${listaSalsa}">
                                <!--option value="${dato.getId()}">${dato.getId()} -  ${dato.getDescripcion()}</option-->
                                <option value="${dato.getId()}">${dato.getDescripcion()}</option>
                            </c:forEach>  
                        </select>
                    </td>
                </tr>
            </table><br>
            <input type="hidden" id="accion" name="accion" value="insertar">
            <input type="submit" value="Insertar" class="btnverde">
        </form>
    </center>
</body>
</html>
