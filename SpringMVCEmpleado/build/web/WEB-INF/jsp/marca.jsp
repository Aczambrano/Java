<%-- 
    Document   : marca
    Created on : 27/09/2023, 22:03:53
    Author     : Anderson
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.4.1/dist/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
        <title>Listar Marca</title>
    </head>

    <body>
        <div class="container mt-4">
            <div class="card border-info">
                <div class="card-header bg-info text-white">
                    <a class="btn btn-primary" href="agregarMarca.htm">Nueva Marca</a>
                </div>
                <div class="card-body">
                    <table class="table table-hover">
                        <thead>
                            <tr>
                                <th>Id</th>
                                <th>Nombre Marca</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach var="dato" items="${listaMarca}">
                                <tr>
                                    <td>${dato.id_marca}</td>
                                    <td>${dato.nombre_marca}</td>                                    
                                    <td>
                                        <a href="editarMarca.htm?id=${dato.id_marca}" class="btn btn-warning">Editar</a>
                                        <a href="eliminarMarca.htm?id=${dato.id_marca}" class="btn btn-danger">Eliminar</a>
                                    </td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>

                </div>

            </div>
        </div>

    </body>
</html>
