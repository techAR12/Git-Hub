package com.example.todo.services;

import java.util.List;
import java.util.Optional;

import com.example.todo.entity.Task;
import com.example.todo.exceptions.taskExceptions.InvalidTaskException;
import com.mysql.cj.x.protobuf.MysqlxCrud.Update;

public interface TodoServices {
   public List<Task> getAllTask(); 

   public void addTask(Task task) throws InvalidTaskException;
   
   public Optional<Task> getTaskById(int id);

   public boolean updateTask(Task task, int id); 
public boolean deleteTask(int id);

}
