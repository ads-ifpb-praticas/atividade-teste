<%-- 
    Document   : cadastrarEmprestimo
    Created on : 03/04/2017, 08:03:36
    Author     : Edilva
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:useBean id="listaEmprestimos" class="br.edu.ifpb.praticas.atividade.praticas.servicos.EmprestimoService" scope="page"/>
<!DOCTYPE html>
<html>
    <head>
        <script src='http://code.jquery.com/jquery-2.1.3.min.js'></script>
        <script src="jquery.js"></script>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/bootstrap.min.css" rel="stylesheet">
        <script src="js/jquery.maskedinput.min.js" type="text/javascript"></script>
        <title>Cadastrar Emprestimo</title>
    </head>
    <body>
        <div><jsp:include page="index.html"/></div>
        <div class="container text-center">
            <br><br>
            <h1>Dados do Emprestimo</h1>
            <br>
        </div>
        <div class="container" style="width:30%">
            <div class="row">
                <form method="post" id="cadastroFilmeEmprrestimo" action="Controller?command=RealizarEmprestimo&id=${filme.id}" name="formFilmeEmprrestimo">
                    <div class="form-group col-md-12">
                        <label for="data">Data de Devolução: </label>
                        <input type="date" class="form-control" name="data" id="data" required>
                    </div>
                    <div class="form-group col-md-12">
                        <label> </label>
                        <input id="btnCadastrar" type="submit" value="Emprestar" class="btn btn-primary btn-block">
                    </div>          
                </form>               
            </div>
        </div>
        <div class="container text-center">
            <h2>Emprestimos</h2>
            <br>
        </div>
        <div class="container" style="width:60%">
            <div class="row center-block">
                <div class="form-group col-md-12">
                    <table class="table table-striped">
                        <tr class="row">
                            <td>FILME</td>
                            <td>DATA DO EMPRESTIMO</td>
                            <td>DATA DA DEVOLUÇÃO</td>
                        </tr>
                        <c:forEach var="emprestimo" items="${listaEmprestimos.listar()}">
                            <tr class="row">
                                <td>${emprestimo.filme.titulo}</td>
                                <td>${emprestimo.dataEnprestimo}</td>
                                <td>${emprestimo.dataDevolucao}</td>
                            </tr>
                        </c:forEach>   
                    </table>
                </div>
            </div>
        </div>
    </body>
</html>
