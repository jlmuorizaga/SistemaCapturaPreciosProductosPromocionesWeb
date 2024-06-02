<%-- 
    Document   : insertarespecialidad
    Created on : 7/04/2023, 04:10:38 PM
    Author     : LUIS.MU
--%>

<!DOCTYPE html>
<%@page contentType="text/html" pageEncoding="ISO-8859-1"%>
<html>
    <head>
        <link rel="stylesheet" href="css/estiloboton.css">
        <link rel="stylesheet" href="css/tablestyle.css">
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <meta charset="utf-8">
        <title>Insertar Especialidad</title>
    </head>
    <body>
        <jsp:include page="encabezado.jsp"/>   
        <jsp:include page="menu.jsp"/>  
    <center>
        <h3>Catálogo Especialidades</h3>      
        <form action="especialidadPizzaController.do" method="post" enctype="multipart/form-data">
            <label>Especialidad</label><br>
            <input type="text" id="nombreEspecialidad" name="nombreEspecialidad"><br><br>
            <label>Ingredientes:</label><br>
            <input type="text" id="ingredientesEspecialidad" name="ingredientesEspecialidad"><br><br>
            <label>Imagen:</label><br>
            <input type="file" id="imagenEspecialidad" name="imagenEspecialidad"><br><br>
            <input type="hidden" id="accion" name="accion" value="insertar">
            <input type="submit" value="Insertar" class="btnverde">
        </form>
    </center>
</body>
</html>

