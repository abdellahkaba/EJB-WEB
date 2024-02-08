package com.servlet;
 
import java.io.IOException;
import jakarta.ejb.EJB;
import jakarta.persistence.EntityManager;

import com.entity.Task;
import com.entity.TodoList;
import com.session.TodoLocal;


import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;



public class TaskServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@EJB 
	private TodoLocal todo ;
    
    public TaskServlet() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		int todolist_id = Integer.parseInt(request.getParameter("todolist_id"));
		request.setAttribute("todolists", todo.getAllTodoList());
		request.setAttribute("tasks", todo.taskAll());
//		request.setAttribute("todoTask", todo.getTasksForTodolist(2));
		
		
		
//		
		request.getRequestDispatcher("Task.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		String post_task = request.getParameter("post_task");
//		int todolist_id = Integer.parseInt(request.getParameter("todolist_id"));
//		Task task = new Task(post_task,2) ;
		//todo.addTask2(task);
		  String post_task = request.getParameter("post_task");
		   int todolist_id = Integer.parseInt(request.getParameter("todolist_id"));
		   Task task = new Task(post_task, todo.getTodo(todolist_id));
		   todo.addTask2(task);
		  
		
		
	}

}
