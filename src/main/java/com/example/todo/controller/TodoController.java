package com.example.todo.controller;

import java.util.List;
import java.util.Optional;

import org.apache.catalina.connector.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.todo.entity.Task;
import com.example.todo.exceptions.taskExceptions.InvalidTaskException;
import com.example.todo.services.TodoServices;

@RestController("todoControllerBean") //target,component etc
@RequestMapping("/todo-app")
public class TodoController {
	 private static final Logger logger = LoggerFactory.getLogger(TodoController.class);

 	@Autowired
	TodoServices todoService; //have only one iml class right now 
//   @RequestMapping(value = "/",method = RequestMethod.GET)
   @GetMapping("/")
   public String homePage() {
	   return "Helle from server";
   }
   @PostMapping("/add-task")
   public ResponseEntity<String> addTask(@RequestBody Task task) throws InvalidTaskException{
	   todoService.addTask(task);
	   return ResponseEntity.status(201).body("Resource Created"); 
   }
   @GetMapping("/get-all-task")
   public ResponseEntity<List<Task>> getAllTask() {
	   List<Task> allTask =todoService.getAllTask();
	   return ResponseEntity.status(200).body(allTask);
   }
   @GetMapping("/get-task-by-id/{id}")
   public ResponseEntity<Task> getTaskById(@PathVariable(value = "id",required=true) int id) {
	   logger.info("Given id "+id);
	   Optional<Task> task = todoService.getTaskById(id);
	   logger.info("now in controller classs");
	   if(task.isPresent()) return ResponseEntity.status(200).body(task.get());
	   logger.info("task with id " +id+" is not pressent hence returning null");
	   return ResponseEntity.status(400).body(null);
   }
   @PostMapping("/updateTask")
   public ResponseEntity<String> updateTask(@RequestBody Task task){
	   if(todoService.updateTask(task)) {
		   return ResponseEntity.status(200).body("Task Updated");
	   }
	   return ResponseEntity.status(400).body("Task Not Found");
   }
}
