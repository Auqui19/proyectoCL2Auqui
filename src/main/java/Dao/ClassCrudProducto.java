package Dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import Interfaces.Iproductoable;
import model.TblProductocl2;

public class ClassCrudProducto implements Iproductoable {

	@Override
	public void RegistrarProducto(TblProductocl2 tblpro) {
		EntityManagerFactory conex=Persistence.createEntityManagerFactory("LPII_CL2_AUQUITASAYCOSEBASTIAN");
		EntityManager emanager=conex.createEntityManager();
		emanager.getTransaction().begin();
		emanager.persist(tblpro);
		emanager.getTransaction().commit();
		emanager.close();
	}

	@Override
	public void ActualizarProducto(TblProductocl2 tblpro) {
		EntityManagerFactory conex=Persistence.createEntityManagerFactory("LPII_CL2_AUQUITASAYCOSEBASTIAN");
		EntityManager emanager=conex.createEntityManager();
		emanager.getTransaction().begin();
		emanager.merge(tblpro);
		emanager.getTransaction().commit();
		emanager.close();
	}

	@Override
	public void EliminarProducto(TblProductocl2 tblpro) {
		EntityManagerFactory conex=Persistence.createEntityManagerFactory("LPII_CL2_AUQUITASAYCOSEBASTIAN");
		EntityManager emanager=conex.createEntityManager();
		emanager.getTransaction().begin();
		TblProductocl2 elim = emanager.merge(tblpro);
		emanager.remove(elim);
		emanager.getTransaction().commit();
		emanager.close();
	}

	@Override
	public List<TblProductocl2> ListadoProducto() {
	    EntityManagerFactory conex = Persistence.createEntityManagerFactory("LPII_CL2_AUQUITASAYCOSEBASTIAN");
	    EntityManager emanager = conex.createEntityManager();
	    emanager.getTransaction().begin();
	    List<TblProductocl2> listado = emanager.createQuery("SELECT t FROM TblProductocl2 t", TblProductocl2.class).getResultList();
	    emanager.getTransaction().commit();
	    emanager.close();
	    return listado;
	}


	@Override
	public TblProductocl2 BuscarProductoCodigo(TblProductocl2 tblpro) {
		EntityManagerFactory conex=Persistence.createEntityManagerFactory("LPII_CL2_AUQUITASAYCOSEBASTIAN");
		EntityManager emanager=conex.createEntityManager();
		emanager.getTransaction().begin();
		TblProductocl2 buscar = emanager.find(TblProductocl2.class, tblpro.getIdproductocl2());
		emanager.getTransaction().commit();
		emanager.clear();
		return buscar;
	}

}
