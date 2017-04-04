<%-- 
    Document   : paginaDeResposta
    Created on : 01/04/2017, 19:32:24
    Author     : Edilva
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/bootstrap.min.css" rel="stylesheet">
        <title>Confirmação</title>
    </head>
    <body>
        <div><jsp:include page="index.html"/></div>
        <div>
            <br><br><br>
            <div class="container text-center">
                <h3>${mensagem}</h3>
                <div class="col-md-12 text-center">
                    <a href="${pagina}" class="btn btn-primary">Voltar</a>
                </div>
            </div>
        </div>
    </body>
</html>
