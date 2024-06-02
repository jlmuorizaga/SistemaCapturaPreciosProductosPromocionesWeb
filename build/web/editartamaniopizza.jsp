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
        <link rel="stylesheet" href="css/tablestyle.css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Editar Tamaño Pizza</title>
        <script src="https://cdn.jsdelivr.net/npm/sweetalert2@11"></script>
        <script type="text/javascript">
            function validaForma() {
                const formulario = document.getElementById('myForm');
                if (formulario.nombre.value == '') {
                    Swal.fire({
                        type: 'warning',
                        title: 'Tamaño de pizza no puede estar vacío',
                        confirmButtonColor: '#a91e1e',
                        confirmButtonText: 'Intenta nuevamente'
                    });
//                    return false;
                    //               } else {
                } else {
                    window.location.href = 'tamanioPizzaController.do?accion=guardaedicion&nombre=' + formulario.nombre.value + '&id=' + formulario.id.value;                            

                }
            }
        </script> 
    </head>
    <body>
        <jsp:include page="encabezado.jsp"/>   
        <jsp:include page="menu.jsp"/>  
    <center>
        <h3>Catálogo Tamanio Pizza</h3>      
        <!--form action="tamanioPizzaController.do"-->
        <form id="myForm" method="post">
            <label>Tamaño:</label><br>
            <input type="text" id="nombre" name="nombre" value="${nombreEditar}"><br><br>
            <input type="hidden" id="id" name="id" value="${idEditar}"><br><br>            

            <input type="hidden" id="accion" name="accion" value="guardaedicion">
            <!--input type="submit" value="Editar" class="btnazul"-->
            <input type="button" value="Editar" class="btnazul" onclick="validaForma()">
        </form>
    </center>
</body>
</html>
