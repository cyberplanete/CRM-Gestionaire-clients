package test.JDBC;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TestJDBC
 */
@WebServlet("/TesteurJDBC")
public class TestJDBC extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
    	String utilisateur="etudiantspring";
    	String mdp="etudiantspring";
    	
    	String jdbcURL="jdbc:mysql://localhost:3306/crm_gestionnaire_client?useSSL=false";
    	
    	String piloteSQL= "com.mysql.cj.jdbc.Driver";
    	
    	try {
			
    		PrintWriter sortieHTTP = response.getWriter();
    		
    		sortieHTTP.println("Connexion à la base de donnée: " + jdbcURL );
    		
    		Class.forName(piloteSQL);
    		
    		Connection connection = DriverManager.getConnection(jdbcURL, utilisateur, mdp);
    		
    		sortieHTTP.println("Connexion ok");
    		
    		connection.close();
    		
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServletException();
		}
    	
    }

}
