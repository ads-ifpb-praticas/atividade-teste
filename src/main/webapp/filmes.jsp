<%-- 
    Document   : filmes
    Created on : 31/03/2017, 19:55:15
    Author     : Edilva
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:useBean id="listaFilmes" class="br.edu.ifpb.praticas.atividade.praticas.servicos.FilmeService" scope="page"/>
<!DOCTYPE html>
<html>
    <head>
        <script src='http://code.jquery.com/jquery-2.1.3.min.js'></script>
        <script src="jquery.js"></script>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/bootstrap.min.css" rel="stylesheet">
        <title>Filmes</title>
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
                <form method="post" id="cadastroFilme" action="Controller?command=CadastrarFilme" name="formFilme">
                    <div class="form-group col-md-5">
                        <label for="titulo">Título: </label>
                        <input type="text" class="form-control" name="titulo" id="titulo" autofocus required>
                    </div>
                    <div class="form-group col-md-3">
                        <label for="genero">Gênero: </label>
                        <input type="text" class="form-control" name="genero" id="genero" required>
                    </div>
                    <div class="form-group col-md-2">
                        <label for="duracao">Duração: </label>
                        <input type="text" class="form-control" name="duracao" id="duracao" required>
                    </div>
                    <div class="form-group col-md-2">
                        <label> </label>
                        <input id="btnCadastrar" type="submit" value="Cadastrar" class="btn btn-primary btn-block">
                    </div>          
                </form>
                <div class="form-group col-md-12">
                    <div class="container text-center">
                        <h2>Filmes</h2>
                        <br>
                    </div>
                    <table class="table table-striped">
                        <tr class="row">
                            <td>TÍTULO</td>
                            <td>GÊNERO</td>
                            <td>DURAÇÃO</td>
                            <td>ESTADO</td>
                            <td>EMPRESTAR</td>
                            <td>EDITAR</td>
                            <td>EXCLUIR</td>
                        </tr>
                        <c:forEach var="filme" items="${listaFilmes.listar()}">
                            <tr class="row">
                                <td>${filme.titulo}</td>
                                <td>${filme.genero}</td>
                                <td>${filme.duracao}</td>
                                <td>${filme.estado}</td>
                                <c:if test="${filme.estado == 'EMPRESTADO'}">
                                    <td>
                                        <a class="btn btn-warning btn-block" href="Controller?command=DevolverFilme&id=${filme.id}" id="devolver">Devolver</a>
                                    </td>
                                    <td>
                                        <a class="btn btn-primary btn-block" href="" id="editar" disabled>Editar</a>
                                    </td>
                                    <td>
                                        <a class="btn btn-danger btn-block" href="Controller?command=RemoverFilme&id=${filme.id}" disabled>Excluir</a>
                                    </td>
                                </c:if>
                                <c:if test="${filme.estado == 'DISPONIVEL'}">
                                    <td>
                                        <a class="btn btn-success btn-block" href="Controller?command=ExibirFilme&id=${filme.id}&c=empr" id="emprestar">Emprestar</a>
                                    </td>
                                    <td>
                                        <a class="btn btn-primary btn-block" href="Controller?command=ExibirFilme&id=${filme.id}&c=edit" id="editar">Editar</a>
                                    </td>
                                    <td>
                                        <a class="btn btn-danger btn-block" href="Controller?command=RemoverFilme&id=${filme.id}">Excluir</a>
                                    </td>
                                </c:if>
                            </tr>
                        </c:forEach>   
                    </table>
                </div>   
            </div>
        </div>
    </body>
</html>
