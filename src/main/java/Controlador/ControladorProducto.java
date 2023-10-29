package Controlador;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.ClassCrudProducto;
import model.TblProductocl2;

/**
 * Servlet implementation class ControladorProducto
 */
public class ControladorProducto extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControladorProducto() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String nombre=request.getParameter("nombre");
		String precioven = request.getParameter("precioven");
		String preciocom = request.getParameter("preciocom");
		String estado=request.getParameter("estado");
		String descrip=request.getParameter("descrip");

		double precioVenta = Double.parseDouble(precioven);
		double precioCompra = Double.parseDouble(preciocom);
		
		TblProductocl2 tblpro=new TblProductocl2();
		ClassCrudProducto crud=new ClassCrudProducto();

		tblpro.setNombrecl2(nombre);
		tblpro.setPrecioventacl2(precioVenta);
		tblpro.setPreciocompcl2(precioCompra);
		tblpro.setEstadocl2(estado);
		tblpro.setDescripcl2(descrip);
		
		crud.RegistrarProducto(tblpro);
		List<TblProductocl2> listado = crud.ListadoProducto();
		request.setAttribute("listado", listado);
		
		request.getRequestDispatcher("/index.jsp").forward(request, response);
	}

}
