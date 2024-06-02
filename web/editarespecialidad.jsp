<%-- 
    Document   : editartamaniopizza
    Created on : 7/04/2023, 11:40:22 AM
    Author     : LUIS.MU
--%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page contentType="text/html" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="css/estiloboton.css">
        <link rel="stylesheet" href="css/tablestyle.css">
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title>Editar Especialidad</title>
        <meta charset="utf-8">
    </head>
    <body>
        <jsp:include page="encabezado.jsp"/>   
        <jsp:include page="menu.jsp"/>  
    <center>
        <h3>Catálogo Especialidades</h3>      
        <form action="especialidadPizzaController.do" method="post" enctype="multipart/form-data">
            <label>Especialidad</label><br>
            <input type="text" id="nombreEspecialidad" name="nombreEspecialidad" value="${nombreEspecialidad}"><br><br>
            <label>Ingredientes:</label><br>
            <input type="text" id="ingredientesEspecialidad" name="ingredientesEspecialidad" value="${ingredientesEspecialidad}"><br><br>
            <label>Imagen actual:</label><br>
            
            <center><img  src="${imgUrl}" width="100" height="100" border="3"></center><br>
            <input type="file" id="imagenEspecialidad" name="imagenEspecialidad" value="${imagenEspecialidad}"><br><br>            
            <input type="hidden" id="idEspecialidad" name="idEspecialidad" value="${idEspecialidad}"><br><br>
            <input type="hidden" id="accion" name="accion" value="guardaedicion">
            <input type="submit" value="Editar" class="btnazul">
        </form>
    </center>
</body>
</html>
