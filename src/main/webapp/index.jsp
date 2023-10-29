<%@page import="java.util.*" %>
<%@page import="model.TblProductocl2" %>
<html>
<body>
<h2>Registrar Producto</h2>
<form method="post" action="ControladorProducto">
	<table>
		<tr>
			<td>Nombre</td>
			<td><input type="text" name="nombre"></td>
		</tr>
		<tr>
			<td>Precio Venta</td>
			<td><input type="number" name="precioven"></td>
		</tr>
		<tr>
			<td>Precio Compra</td>
			<td><input type="number" name="preciocom"></td>
		</tr>
		<tr>
			<td colspan="2">
				<select name="estado">
					<option>Seleccione estado</option>
					<option>Disponible</option>
					<option>Agotado</option>
				</select>
			</td>
		</tr>
		<tr>
			<td>Descripcion</td>
			<td><input type="text" name="descrip"></td>
		</tr>
		<tr>
			<td colspan="2">
				<input type="submit" value="Registrar">
			</td>
		</tr>
	</table>
</form>
<h2>Lista</h2>
<table>
	<tr>
		<th>Codigo</th>
		<th>Nombre</th>
		<th>Precio Venta</th>
		<th>Precio Compra</th>
		<th>Estado</th>
		<th>Descripcion</th>
	</tr>
	<%
		List<TblProductocl2> listado = (List<TblProductocl2>)request.getAttribute("listado");
		if(listado!=null){
			for(TblProductocl2 tblpro:listado){
	%>
		<tr>
			<td><%=tblpro.getIdproductocl2()%></td>	
			<td><%=tblpro.getNombrecl2()%></td>	
			<td><%=tblpro.getPrecioventacl2()%></td>	
			<td><%=tblpro.getPreciocompcl2()%></td>	
			<td><%=tblpro.getEstadocl2()%></td>	
			<td><%=tblpro.getDescripcl2()%></td>	
		</tr>		
	<% 				
			}
		}
	%>
</table>
</body>
</html>
