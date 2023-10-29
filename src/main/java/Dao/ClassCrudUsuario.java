package Dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import Interfaces.Iusuarioable;
import model.TblUsuariocl2;

public class ClassCrudUsuario implements Iusuarioable {

	@Override
	public void RegistrarUsuario(TblUsuariocl2 tblusu) {
		EntityManagerFactory conex=Persistence.createEntityManagerFactory("LPII_CL2_AUQUITASAYCOSEBASTIAN");	
		EntityManager emanager=conex.createEntityManager();
		emanager.getTransaction().begin();
		emanager.persist(tblusu);
		emanager.getTransaction().commit();
		emanager.close();
	}

	@Override
	public void ActualizarUsuario(TblUsuariocl2 tblusu) {
		EntityManagerFactory conex=Persistence.createEntityManagerFactory("LPII_CL2_AUQUITASAYCOSEBASTIAN");
		EntityManager emanager=conex.createEntityManager();
		emanager.getTransaction().begin();
		emanager.merge(tblusu);
		emanager.getTransaction().commit();
		emanager.close();
	}

	@Override
	public void EliminarUsuario(TblUsuariocl2 tblusu) {
		EntityManagerFactory conex=Persistence.createEntityManagerFactory("LPII_CL2_AUQUITASAYCOSEBASTIAN");
		EntityManager emanager=conex.createEntityManager();
		emanager.getTransaction().begin();
		TblUsuariocl2 elim = emanager.merge(tblusu);
		emanager.remove(elim);
		emanager.getTransaction().commit();
		emanager.close();
	}

	@Override
	public List<TblUsuariocl2> ListadoUsuario() {
		EntityManagerFactory conex=Persistence.createEntityManagerFactory("LPII_CL2_AUQUITASAYCOSEBASTIAN");
		EntityManager emanager=conex.createEntityManager();
		emanager.getTransaction().begin();
		List<TblUsuariocl2> listado = emanager.createQuery("select e from TblUsuariocl1 e",TblUsuariocl2.class).getResultList();
		emanager.getTransaction().commit();
		emanager.close();
		return listado;
	}

	@Override
	public TblUsuariocl2 BuscarUsuario(TblUsuariocl2 tblusu) {
		EntityManagerFactory conex=Persistence.createEntityManagerFactory("LPII_CL2_AUQUITASAYCOSEBASTIAN");
		EntityManager emanager=conex.createEntityManager();
		emanager.getTransaction().begin();
		TblUsuariocl2 buscar = emanager.find(TblUsuariocl2.class, tblusu.getIdusuariocl2());
		emanager.getTransaction().commit();
		emanager.clear();
		return buscar;
	}

	@Override
	public String ValidarUsuario(TblUsuariocl2 tblusu) {
		EntityManagerFactory conex=Persistence.createEntityManagerFactory("LPII_CL2_AUQUITASAYCOSEBASTIAN");
		EntityManager emanager=conex.createEntityManager();
		emanager.getTransaction().begin();
		Query consulta = emanager.createQuery("SELECT u FROM TblUsuariocl2 u where u.usuariocl2 = :x and u.passwordcl2 = :y", TblUsuariocl2.class);
		consulta.setParameter("x", tblusu.getUsuariocl2());
		consulta.setParameter("y", tblusu.getPasswordcl2());
		@SuppressWarnings("unused")
		TblUsuariocl2 t;
		String mensaje = "";
		try {
			t=(TblUsuariocl2) consulta.getSingleResult();
			mensaje="existe";
		} catch (Exception e) {
			t=null;
			mensaje="No existe";
		}
		
		return mensaje;
	}
	
}
