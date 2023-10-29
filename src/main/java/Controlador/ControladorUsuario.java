package Controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.TblUsuariocl2;
import Dao.ClassCrudUsuario;
/**
 * Servlet implementation class ControladorUsuario
 */
public class ControladorUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControladorUsuario() {
        //super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    String usuario = request.getParameter("usuario");
	    String contrasena = request.getParameter("contrasena");
	    TblUsuariocl2 usuarioValidar = new TblUsuariocl2();
	    usuarioValidar.setUsuariocl2(usuario);
	    usuarioValidar.setPasswordcl2(contrasena);
	    
	    ClassCrudUsuario crudUsuario = new ClassCrudUsuario();
	    String resultado = crudUsuario.ValidarUsuario(usuarioValidar);

	    if ("existe".equals(resultado)) {
	        request.getRequestDispatcher("/index.jsp").forward(request, response);
	    } else {
	    	System.out.println("Usuario o contraseña incorrectos");
	        request.setAttribute("error", "Usuario o contraseña incorrectos");
	        request.getRequestDispatcher("logueo.jsp").forward(request, response);
	    }

	}

}
