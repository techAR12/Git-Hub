package com.example.todo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.todo.entity.Task;

@Repository // combination of @Component and ...
public interface TodoRepository  extends JpaRepository<Task,Integer>{
}
