<%-- 
    Document   : insertartamaniopizza
    Created on : 7/04/2023, 01:14:35 AM
    Author     : LUIS.MU
--%>

<!DOCTYPE html>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>
    <head>
        <link rel="stylesheet" href="css/estiloboton.css">
        <link rel="stylesheet" href="css/tablestyle.css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
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
                    window.location.href = 'salsaController.do?accion=insertar&descripcion=' + formulario.descripcion.value;

                }
            }
        </script>        
        <title>Insertar Producto Sabor</title>

    </head>
    <body>
        <jsp:include page="encabezado.jsp"/>   
        <jsp:include page="menu.jsp"/>  
    <center>
        <h3>Catálogo Producto Sabor</h3>      
        <!--form action="salsaController.do"-->
        <form id="myForm" method="post">
            <label>Descripción</label><br>
            <input type="text" id="nombre" name="descripcion"><br><br>
            <input type="hidden" id="accion" name="accion" value="insertar">
            <input type="button" value="Insertar" class="btnverde" onclick="validaForma()">
        </form>
    </center>
</body>
</html>
