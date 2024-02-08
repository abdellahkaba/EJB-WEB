package com.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class TodoList implements Serializable{
    
	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_todoList;

    private String name;
   

    @OneToMany(mappedBy = "todoList", fetch = FetchType.EAGER)
    private List<Task> tasks;
    public TodoList() {
    }

    public TodoList(String name) {
        this.name = name;
        this.tasks = new ArrayList<>();
    }

    public int getId_todoList() {
        return id_todoList;
    }

    public void setId_todoList(int id_todoList) {
        this.id_todoList = id_todoList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }

    @Override
    public String toString() {
        return "TodoList{" +
                "id_todoList=" + id_todoList +
                ", name='" + name + '\'' +
                ", tasks=" + tasks +
                '}';
    }
}

