package controller;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Banco;
import model.Usuario;
@WebServlet("/Autenticador")
public class Autenticador extends HttpServlet{
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 		
			throws ServletException, IOException {
				Usuario user = new Usuario();		
				String login = request.getParameter("login");
				String senha = request.getParameter("senha");		
				user.setLogin(login);
				user.setSenha(senha);
				if(autenticar(user)){
					request.getSession().setAttribute("user", user);
					response.sendRedirect("Home.jsp");
				}else{
					request.setAttribute("erro", "Usuário ou Senha Inválidos!");
				RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
					dispatcher.forward(request, response);
				}
			}
	private boolean autenticar(Usuario user) {
		   boolean autenticado = false;		
		   Connection con = Banco.getConnection();
		   String sql = "select *  " +  
		"from usuario  " +  
		           "where " +  "login = '" + user.getLogin().trim() +  "' and " + "senha = '" + user.getSenha().trim() + "';" ;
		   try {
			Statement stmt = con.createStatement();		
			ResultSet resultSet = stmt.executeQuery(sql);
			if (resultSet.next()) {	
		autenticado = true; 	
		}	
			resultSet.close();
			stmt.close();		
		   }catch (SQLException e) {
			e.printStackTrace();
		   }
		   return autenticado;		
		}
		}
