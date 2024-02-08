package com.service;

import java.util.List;

import com.entity.Task;
import com.entity.TodoList;
import com.session.TodoLocal;

import jakarta.ejb.EJB;
import jakarta.ejb.Singleton;
import jakarta.ejb.Stateless;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebService;

@Stateless
@WebService
public class TodoService {
	
	@EJB
	
	//on declare un attribut de type TodoLocal
	
	private TodoLocal todo ;
	
	//Methode service qui ajoute un todolist
	@WebMethod
	public void addTodoLists(@WebParam(name="name")String name){
		TodoList todolist = new TodoList(name) ;
		todo.addTodoList(todolist);
	}
	
	//Une fonction qui va ajouter une tâche(task)
	
	public void addTask(String post_task, int todolistId) {
		//Task task = new Task(post_task,todolistId) ;
		//todo.addTask(task, todolistId);
	}
	
	//une méthode qui return tous les todolists
	@WebMethod
	public List<TodoList> listTodoList() {
		return todo.getAllTodoList() ;
	}
	
	//une fonction qui return tous les task d'un todolist
	
	@WebMethod
	
	public List<Task> listTaskTodolist() {
		int todoTaskId = 0 ;
		return todo.getTasksForTodolist(todoTaskId) ;
	}
	
	
	
}
