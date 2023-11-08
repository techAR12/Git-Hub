package com.example.todo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity // mapping will happen
public class Task {
   @Id()
   @GeneratedValue(strategy = GenerationType.AUTO) // auto means jpa provider use its default technique to generate PK_ID
   private int id;
   @Column(name = "task_des")
   private String task;
   @Column(name = "task_status")
   private String status;
   
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTask() {
		return task;
	}
	public void setTask(String task) {
		this.task = task;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "Task [id=" + id + ", task=" + task + ", status=" + status + "]";
	}
}
