<%-- 
    Document   : producto
    Created on : 27/09/2023, 22:30:00
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
        <title>Listar Producto</title>
    </head>

    <body>
        <div class="container mt-4">
            <div class="card border-info">
                <div class="card-header bg-info text-white">
                    <a class="btn btn-primary" href="agregarProducto.htm">Nuevo Producto</a>
                </div>
                <div class="card-body">
                    <table class="table table-hover">
                        <thead>
                            <tr>
                                <th>Id</th>
                                <th>Id Categoria</th>
                                <th>Id Marca</th>
                                <th>Descripcion Producto</th>
                                <th>Precio Producto</th>
                                <th>Fecha Producto</th>

                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach var="dato" items="${listaProducto}">
                                <tr>
                                    <td>${dato.id_producto}</td>
                                    <td>${dato.nombre_categoria}</td>       
                                    <td>${dato.nombre_marca}</td>
                                    <td>${dato.descripcion_producto}</td> 
                                    <td>${dato.precio_producto}</td>
                                    <td>${dato.fecha_registro}</td> 
                                    <td>
                                        <a href="editarProducto.htm?id=${dato.id_producto}" class="btn btn-warning">Editar</a>
                                        <a href="eliminarProducto.htm?id=${dato.id_producto}" class="btn btn-danger">Eliminar</a>
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
