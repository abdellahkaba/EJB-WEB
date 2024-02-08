package com.entity;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Task implements Serializable{
   
	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_task;

    private String post_task;
  
    
    @ManyToOne
    @JoinColumn(name = "todolist_id")
    private TodoList todoList;
    
    public Task() {
    }

   
    public Task(String post_task,  TodoList todoList) {
    	this.post_task = post_task;
        this.todoList = todoList;
    }

    public int getId_task() {
        return id_task;
    }

    public void setId_task(int id_task) {
        this.id_task = id_task;
    }

    public String getPost_task() {
        return post_task;
    }

    public void setPost_task(String post_task) {
        this.post_task = post_task;
    }

    public TodoList getTodoList() {
        return todoList;
    }

    public void setTodoList(TodoList todoList) {
        this.todoList = todoList;
    }
    @Override
    public String toString() {
        return "Task{" +
                "id_task=" + id_task +
                ", post_task='" + post_task + '\'' +
                '}';
    }
}