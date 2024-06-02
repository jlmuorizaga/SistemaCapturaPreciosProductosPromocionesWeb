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
        <!--link rel="stylesheet" href="bootstrap-5.3.0-dist/css/bootstrap.min.css-->"
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

        <!--script src="js/jquery-3.3.1.min.js"></script-->
        <!--script src="js/jquery-3.7.0.min.js"></script-->

        <!--link rel="stylesheet" href="css/sweetalert2.min.css">   
        <script src="js/popper.min.js"></script>
        <script src="js/sweetalert2.all.min.js"></script-->

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
                    window.location.href = 'tamanioPizzaController.do?accion=insertar&nombre=' + formulario.nombre.value;
                }
            }
        </script>        

        <title>Insertar Tamaño Pizza</title>
    </head>
    <body>
        <jsp:include page="encabezado.jsp"/>   
        <jsp:include page="menu.jsp"/>  
    <center>
        <h3>Catálogo Tamanio Pizza</h3>      
        <!--form action="tamanioPizzaController.do"-->
        <form id="myForm" method="post">
            <!--form id="formInsertaTamanioPizza" class="form" action=""-->
            <label>Tamaño:</label><br>
            <input type="text" name="nombre" id="nombre"><br><br>
            <input type="hidden" id="accion" name="accion" value="insertar">
            <input type="button" value="Insertar" class="btnverde" onclick="validaForma()">
        </form>
    </center>
    <!--script src="js/validainsertatamaniopizza.js"></script--> 
</body>
</html>
