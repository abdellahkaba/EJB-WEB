package com.session;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.List;

import com.entity.Task;
import com.entity.TodoList;
import com.entity.User;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;


public class TodoImplement implements TodoRemote, TodoLocal{
	
	//notre entity manager avec unité de persistence
	
	@PersistenceContext(unitName = "TP_TODOLIST")
	private EntityManager emp;
	
	@Override
	public void addTodoList(TodoList todo) {
		//on lui dit maintenant d'ajout un todolist avec persiste
		emp.persist(todo);
	}
	
	public void addTask2(Task task) {
		emp.persist(task);
	}
	
	@Override
	public List<Task> taskAll() {
		
		TypedQuery <Task> req = emp.createQuery("SELECT t from Task t", Task.class) ;
		return req.getResultList();
	}
	
	@Override
	public List<Task> getTasksForTodolist(int todolist_id) {
		Query  req = emp.createQuery("select t from Task t where t.todolist_id = :todolist_id");
        req.setParameter("todolist_id", todolist_id);
		return req.getResultList();
	}
	
	@Override
	public List<TodoList> getAllTodoList() {
		
		TypedQuery <TodoList> req = emp.createQuery("SELECT t from TodoList t", TodoList.class) ;
		return req.getResultList();
	}
	@Override
	public void addTask(Task task, int todolistId) {
		
		//on cherche d'abord l'identifiant de todolist
		 TodoList todoList = emp.find(TodoList.class, todolistId);
		
//		if (todoList != null) {
//		       Task task = new Task(post_task, todoList);
//		       emp.addTask2(task);
//		   } else {
//		       
//		   }
		
	}

	
	
	
	public TodoList getTodo(int todolistId) {
		 TodoList todoList = emp.find(TodoList.class, todolistId);
		 return todoList ;
	}

	
	 public Task getTaskById(int taskId) {
		 
		 Task task = emp.find(Task.class, taskId);
		 // Vérifier si la tâche existe
		 if(task == null) throw new RuntimeException( "Cet Task est introuvable !") ;
		 //puis return le task
		 return task ;
	 }
	 
	 public void removeTask(int taskId) {
		 
		 Task task = emp.find(Task.class, taskId);
	        // Vérifier si la tâche existe avant de la supprimer
	        if (task != null) {
	            // Supprimer la tâche
	            emp.remove(task);
	        }
	 }

	
	 @Override
		public void addUser(User user) {
			emp.persist(user);
		}
	 
	 	@Override
	    public User getUserFromDatabase(String username) {
	        // Utilisation de Hibernate pour récupérer un utilisateur depuis la base de données
	        String jpql = "SELECT u FROM User u WHERE u.username = :username";
	        TypedQuery<User> query = emp.createQuery(jpql, User.class);
	        query.setParameter("username", username);

	        try {
	            return query.getSingleResult();
	        } catch (Exception e) {
	            // Gérer l'exception (par exemple, si aucun utilisateur n'est trouvé)
	            return null;
	        }
	    }
	 
	 	
	 	
	 @Override
	 public String hashPassword(String password) {
	        try {
	            MessageDigest digest = MessageDigest.getInstance("SHA-256");
	            byte[] hash = digest.digest(password.getBytes("UTF-8"));
	            return Base64.getEncoder().encodeToString(hash);
	        } catch (NoSuchAlgorithmException | UnsupportedEncodingException e) {
	            e.printStackTrace();
	            return null;
	        }
	    }

	
	
}
