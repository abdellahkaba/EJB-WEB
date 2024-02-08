package com.session;

import java.util.List;

import com.entity.Task;
import com.entity.TodoList;
import com.entity.User;

import jakarta.ejb.Remote;


@Remote
public interface TodoRemote {
	
	public void addTodoList(TodoList todo);
	public void addTask2(Task task);
	public List<Task> taskAll() ;
	public List<Task> getTasksForTodolist(int todoTaskId);
	public List<TodoList> getAllTodoList();
	public void addTask(Task task,int todolist_id);
	
	public Task getTaskById(int taskId);
	public TodoList getTodo(int todolistId) ;
	public void removeTask(int taskId);
	public void addUser(User user) ;
	 
	
}
