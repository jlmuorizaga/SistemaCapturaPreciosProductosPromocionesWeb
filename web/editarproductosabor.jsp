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
        <title>Editar Producto Sabor</title>
        <script src="https://cdn.jsdelivr.net/npm/sweetalert2@11"></script>
        <script type="text/javascript">
            function validaForma() {
                const formulario = document.getElementById('myForm');
                if (formulario.descripcion.value == '') {
                    Swal.fire({
                        type: 'warning',
                        title: 'Descripción no puede estar vacío',
                        confirmButtonColor: '#a91e1e',
                        confirmButtonText: 'Intenta nuevamente'
                    });
                } else {
                    window.location.href = 'salsaController.do?accion=guardaedicion&descripcion=' + formulario.descripcion.value + '&id=' + formulario.id.value;

                }
            }
        </script>        

    </head>
    <body>
        <jsp:include page="encabezado.jsp"/>   
        <jsp:include page="menu.jsp"/>  
    <center>
        <h3>Catálogo Producto Sabor</h3>      
        <!--form action="salsaController.do"-->
        <form id="myForm" method="post">
            <label>Descripción:</label><br>
            <input type="text" id="descripcion" name="descripcion" value="${descripcion}"><br><br>
            <input type="hidden" id="id" name="id" value="${id}"><br><br>
            <input type="hidden" id="accion" name="accion" value="guardaedicion">
            <!--input type="submit" value="Editar" class="btnazul"-->
            <input type="button" value="Editar" class="btnazul" onclick="validaForma()">
        </form>
    </center>
</body>
</html>
