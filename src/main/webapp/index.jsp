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
			<td>Precio</td>
			<td><input type="number" name="precioven"></td>
		</tr>
		<tr>
			<td>PrecioVen</td>
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
</body>
</html>
