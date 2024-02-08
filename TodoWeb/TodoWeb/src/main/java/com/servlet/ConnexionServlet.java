package com.servlet;

import java.io.IOException;
import jakarta.ejb.EJB;
import com.entity.User;
import com.session.TodoLocal;


import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ConnexionServlet
 */
public class ConnexionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
      
	@EJB 
	private TodoLocal todo ;
	
    public ConnexionServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    public boolean authenticateUser(String username,String password) {
    	User user = todo.getUserFromDatabase(username);
        if (user != null) {
            // Hasher le mot de passe fourni pour le comparer avec le mot de passe stocké
            String hashedPasswordToCheck = todo.hashPassword(password);
            // Comparer les mots de passe hachés
            return hashedPasswordToCheck.equals(user.getUser_hash());
        }
        return false; // Utilisateur non trouvé dans la base de données
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("Connexion.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
		String username = request.getParameter("username");
		  String password = request.getParameter("password");
		  
		  if (authenticateUser(username, password)) {
			  request.setAttribute("todolists", todo.getAllTodoList());
			  request.getRequestDispatcher("index.jsp").forward(request, response);
			  System.out.println("La connexion a reussi !");
	        } else {
	        	request.getRequestDispatcher("Connexion.jsp").forward(request, response);
	        	System.out.println("La connexion a échouée");
	        }
		
	}

}
