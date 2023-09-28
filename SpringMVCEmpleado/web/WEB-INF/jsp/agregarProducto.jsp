<%-- 
    Document   : agregarProducto
    Created on : 27/09/2023, 22:32:24
    Author     : Anderson
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.4.1/dist/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">

        <title>Agregar Producto</title>
    </head>
    <body>
        <div class="containter mt-4 col-lg-4">
            <div class="card border-info">
                <div class="card-header bg-info">
                    <h4>Nuevo Producto</h4>
                </div>
                
                <div class="card-body">
                    <form method="POST">
                        
                        <label>Id Categoria</label>
                        <input type="text" name="id_categoria" class="form-control">
                        
                        <label>Id Marca</label>
                        <input type="text" name="id_marca" class="form-control">
                        
                        <label>Descripción Producto</label>
                        <input type="text" name="descripcion_producto" class="form-control">
                        
                        
                        <label>Precio Producto</label>
                        <input type="text" name="precio_producto" class="form-control">
                        
                        
                        <input type="submit" value="agregarProducto" class="btn btn-success">
                        <a href="producto.htm">Regresar</a>                        
                    </form>
                </div>
            </div>
            
                
        </div>
    </body>
</html>
