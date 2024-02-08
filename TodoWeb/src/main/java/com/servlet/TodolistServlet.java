package com.servlet;
import java.io.IOException;
import jakarta.ejb.EJB;
import com.session.TodoLocal;
import com.entity.TodoList;
import com.service.TodoService;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


public class TodolistServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	//On fait appel à notre EJB
	
	@EJB 
	private TodoLocal todo ;
	
    
	
    public TodolistServlet() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setAttribute("todolists", todo.getAllTodoList());
		request.getRequestDispatcher("Todolist.jsp").forward(request, response);
	
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		TodoList td = new TodoList(name) ;
		todo.addTodoList(td);
	}

}
