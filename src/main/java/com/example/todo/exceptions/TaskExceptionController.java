package com.example.todo.exceptions;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.example.todo.exceptions.taskExceptions.InvalidTaskException;

@ControllerAdvice
public class TaskExceptionController {
	@ExceptionHandler(value = {InvalidTaskException.class})
	public ResponseEntity<String> invalidTaskHandler(){
	   return ResponseEntity.status(400).body("Invalid Task");
   }
}
