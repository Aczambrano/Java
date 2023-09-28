<%-- 
    Document   : editarProducto
    Created on : 27/09/2023, 22:38:47
    Author     : Anderson
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.4.1/dist/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">

        <title>Editar Producto</title>
    </head>
    <body>
        <div class="containter mt-4 col-lg-4">
            <div class="card border-info">
                <div class="card-header bg-info">
                    <h4>Editar Producto</h4>
                </div>
                
                <div class="card-body">
                    <form method="POST">
                        
                        <label>Id Categoria</label>
                        <input type="text" name="id_categoria" class="form-control"  value="${listaProducto[0].id_categoria}">
                        
                        <label>Id Marca</label>
                        <input type="text" name="id_marca" class="form-control"  value="${listaProducto[0].id_marca}">
                        
                        <label>Descripción Producto</label>
                        <input type="text" name="descripcion_producto" class="form-control"  value="${listaProducto[0].descripcion_producto}">
                        
                        
                        <label>Precio Producto</label>
                        <input type="text" name="precio_producto" class="form-control"  value="${listaProducto[0].precio_producto}">
                    

                        
                        <input type="submit" value="editarProducto" class="btn btn-success">
                        <a href="producto.htm">Regresar</a>                        
                    </form>
                </div>
            </div>
            
                
        </div>
    </body>
</html>
