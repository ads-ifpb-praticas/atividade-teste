<%-- 
    Document   : editarLivro
    Created on : 02/04/2017, 18:59:26
    Author     : Edilva
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:useBean id="listaFilmes" class="br.edu.ifpb.praticas.atividade.praticas.facade.Facade" scope="page"/>
<!DOCTYPE html>
<html>
    <head>
        <script src='http://code.jquery.com/jquery-2.1.3.min.js'></script>
        <script src="jquery.js"></script>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/bootstrap.min.css" rel="stylesheet">
        <title>Editar Filme</title>
    </head>
    <body>
        <div><jsp:include page="index.html"/></div>
        <div class="container text-center">
            <br><br>
            <h1>Dados do Filme</h1>
            <br>
        </div>
        <div class="container" style="width:80%">
            <div class="row">
                <form method="post" id="cadastroFilme" action="Controller?command=EditarFilme&id=${filme.id}&estado=${filme.estado}" name="formFilme">
                    <div class="form-group col-md-5">
                        <label for="titulo">Título: </label>
                        <input type="text" class="form-control" name="titulo" id="titulo" value="${filme.titulo}" autofocus required>
                    </div>
                    <div class="form-group col-md-3">
                        <label for="genero">Gênero: </label>
                        <input type="text" class="form-control" name="genero" id="genero" value="${filme.genero}" required>
                    </div>
                    <div class="form-group col-md-2">
                        <label for="duracao">Duração: </label>
                        <input type="text" class="form-control" name="duracao" id="duracao" value="${filme.duracao}" required>
                    </div>
                    <div class="form-group col-md-2">
                        <label> </label>
                        <input id="btnAtualizar" type="submit" value="Atualizar" class="btn btn-primary btn-block">
                    </div>          
                </form>               
            </div>
        </div>
    </body>
</html>
