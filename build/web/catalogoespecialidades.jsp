<%-- 
    Document   : catalogoespecialidades
    Created on : 7/04/2023, 12:29:07 AM
    Author     : LUIS.MU
--%>


<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">       
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <meta charset="utf-8">
        <link rel="shortcut icon" href="#" />
        <link rel="stylesheet" href="css/estiloboton.css">
        <link rel="stylesheet" href="css/tablestyle.css">

        <!--meta http-equiv="Content-Type" content="text/html; charset=UTF-8"-->
        <title>Catálogo Especialidades</title>
        <!--link rel="stylesheet" href="css/estilotabla.css"-->
        <script type="text/javascript">
            function confirmarBorrar(id) {
                if (confirm("¿Estás seguro de que quieres borrar el registro: " + id + "?")) {
                    //alert("¡Has confirmado la acción!");
                    window.location.href = 'especialidadPizzaController.do?accion=borrar&id=' + id;
                } else {
                    //alert("Has cancelado la acción.");
                }
            }
        </script>
    </head>
    <body>
        <jsp:include page="encabezado.jsp"/>   
        <jsp:include page="menu.jsp"/>  
    <center>
        <h3>Catálogo Especialidades</h3>      
        <!--form method="POST"-->
        <form>
            <input type=button onclick="window.location.href = 'insertarespecialidad.jsp';" value="Insertar Especialidad" class="btnverde">
        </form>
    </center><br>
    <c:if test="${not empty listaEspecialidadPizza}">
        <center>
            <table width="80%" border="1">
                <thead class="text-center">
                    <tr class="trhover">
                        <th>ID</th>
                        <th>Nombre</th>
                        <th>Ingredientes</th>
                        <th>Aplica 2x1</th>
                        <th>Aplica 1 pizza</th>
                        
                        <th>Imagen</th>
                        <th>Imagen URL</th>
                        <th colspan="2">Acciones</th>
                    </tr>
                </thead>
                <c:forEach var="dato" items="${listaEspecialidadPizza}">
                    <tr>
                        <td width="20%">${dato.getIdEspecialidad()}</td>
                        <td width="20%">${dato.getNombreEspecialidad()}</td>
                        <td width="20%">${dato.getIngredientesEspecialidad()}</td>
                        <td width="20%">${dato.getAplica2x1Especialidad()}</td>
                        <td width="20%">${dato.getAplicaP1Especialidad()}</td>
                        <td width="20%" align="center"><img  src="${urlServidor}${dato.getImgUrl()}" width="100" height="100" border="3"></td> 
                        <td width="20%">${dato.getImgUrl()}</td>
                        <td width="10%" align="center">
                            <form>
                                <!--input type=button onclick="window.location.href = 'especialidadPizzaController.do?accion=editar&id=${dato.getIdEspecialidad()}&nombre=${dato.getNombreEspecialidad()}&ingredientes=${dato.getIngredientesEspecialidad()}&ruta=${dato.getImgUrl()}';" value="Editar" class="btnazul"-->
                                <input type=button onclick="window.location.href = 'especialidadPizzaController.do?accion=editar&id=${dato.getIdEspecialidad()}&nombre=${dato.getNombreEspecialidad()}&ingredientes=${dato.getIngredientesEspecialidad()}&imgUrl=${urlServidor}${dato.getImgUrl()}';" value="Editar" class="btnazul">
                            </form>
                        </td>
                        <td width="10%" align="center">
                            <form>
                                <!--input type=button onclick="window.location.href = 'insertartamaniopizza.jsp';" value="Borrar"-->
                                <input type=button onclick="javascript:confirmarBorrar('${dato.getIdEspecialidad()}');" value="Borrar" class="btnrojo">
                            </form>
                        </td>
                    </tr>
                </c:forEach>
            </table>
        </center>
    </c:if>
</body>
</html>
