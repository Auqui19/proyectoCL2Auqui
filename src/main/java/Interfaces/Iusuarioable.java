package Interfaces;

import java.util.List;

import model.TblUsuariocl2;

public interface Iusuarioable {
	public void RegistrarUsuario(TblUsuariocl2 tblusu);
	public void ActualizarUsuario(TblUsuariocl2 tblusu);
	public void EliminarUsuario(TblUsuariocl2 tblusu);
	public List<TblUsuariocl2> ListadoUsuario();
	public TblUsuariocl2 BuscarUsuario(TblUsuariocl2 tblusu);
	public String ValidarUsuario(TblUsuariocl2 tblusu);
}
