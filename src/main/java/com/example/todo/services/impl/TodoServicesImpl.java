package com.example.todo.services.impl;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.todo.entity.Task;
import com.example.todo.exceptions.taskExceptions.InvalidTaskException;
import com.example.todo.repository.TodoRepository;
import com.example.todo.services.TodoServices;

@Service
public class TodoServicesImpl implements TodoServices{
	
	private static final Logger logger = LoggerFactory.getLogger(TodoServicesImpl.class);
    @Autowired
    TodoRepository todoDao;
    
	@Override
	public List<Task> getAllTask() {
		// TODO Auto-generated method stub
        return todoDao.findAll();
	}

	@Override
	public void addTask(Task task) throws InvalidTaskException {
		// TODO Auto-generated method stub
	   try {
			todoDao.save(task);   
	   }catch(Exception e) {
		   throw new InvalidTaskException("Task is invalid ");
	   }
	}

	@Override
	public Optional<Task> getTaskById(int id) {
		// TODO Auto-generated method stub
		logger.info("logging id from servicimp class "+id);
		Optional<Task> singleTask = todoDao.findById(id);
		logger.info("While searching  recored for id "+id);
		return singleTask;
	}

}
