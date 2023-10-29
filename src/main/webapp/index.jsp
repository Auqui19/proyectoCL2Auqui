<%@page import="java.util.*" %>
<%@page import="model.TblProductocl2" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Registro de Productos</title>
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
    <div class="container">
        <h2 class="mt-4">Registrar Producto</h2>
        <form method="post" action="ControladorProducto" class="mt-3">
            <div class="form-group">
                <label for="nombre">Nombre</label>
                <input type="text" name="nombre" class="form-control col-sm-4"> 
            </div>
            <div class="form-group">
                <label for="precioven">Precio Venta</label>
                <input type="number" name="precioven" class="form-control col-sm-4"> 
            </div>
            <div class="form-group">
                <label for="preciocom">Precio Compra</label>
                <input type="number" name="preciocom" class="form-control col-sm-4"> 
            </div>
            <div class="form-group">
                <label for="estado">Estado</label>
                <select name="estado" class="form-control col-sm-4"> 
                    <option>Seleccione estado</option>
                    <option>Disponible</option>
                    <option>Agotado</option>
                </select>
            </div>
            <div class="form-group">
                <label for="descrip">Descripción</label>
                <input type="text" name="descrip" class="form-control col-sm-4"> 
            </div>
            <button type="submit" class="btn btn-primary">Registrar</button>
        </form>
        <h2 class="mt-4">Lista De productos</h2>
        <table class="table">
            <thead>
                <tr>
                    <th>Codigo</th>
                    <th>Nombre</th>
                    <th>Precio Venta</th>
                    <th>Precio Compra</th>
                    <th>Estado</th>
                    <th>Descripción</th>
                </tr>
            </thead>
            <tbody>
                <%
                    List<TblProductocl2> listado = (List<TblProductocl2>)request.getAttribute("listado");
                    if (listado != null) {
                        for (TblProductocl2 tblpro : listado) {
                    %>
                    <tr>
                        <td><%= tblpro.getIdproductocl2() %></td>
                        <td><%= tblpro.getNombrecl2() %></td>
                        <td><%= tblpro.getPrecioventacl2() %></td>
                        <td><%= tblpro.getPreciocompcl2() %></td>
                        <td><%= tblpro.getEstadocl2() %></td>
                        <td><%= tblpro.getDescripcl2() %></td>
                    </tr>
                    <%
                        }
                    }
                %>
            </tbody>
        </table>
    </div>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
