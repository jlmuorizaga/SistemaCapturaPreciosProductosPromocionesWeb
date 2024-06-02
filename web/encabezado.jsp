<%-- 
    Document   : encabezado
    Created on : 7/04/2023, 12:26:00 AM
    Author     : LUIS.MU
--%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
        <table align="center" class="table100">            
            <td valign="top"><p><strong>Sucursal: <br>${sucursal.getClave()} <br>${sucursal.getNombreSucursal()} </strong></p><br></td>
            <!--td valign="top"><img src="img/logoMoto100x100.jpg"><br></td-->
            <td valign="middle" align="center"><h2>Sistema de Captura de precios, productos y promociones Cheese Pizza</h2></td>
            <td valign="top"><p><strong>Usuario: <br> ${usuario.getNombre()} </strong><br><a href="login.do">Logout</a></p></td>
        </table>   
