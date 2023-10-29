package Interfaces;

import java.util.List;

import model.TblProductocl2;

public interface Iproductoable {
	public void RegistrarProducto(TblProductocl2 tblpro);
	public void ActualizarProducto(TblProductocl2 tblpro);
	public void EliminarProducto(TblProductocl2 tblpro);
	public List<TblProductocl2> ListadoProducto();
	public TblProductocl2 BuscarProductoCodigo(TblProductocl2 tblpro);
}
