package com.afzdev.todolistapp.repository;

import com.afzdev.todolistapp.model.TodoList;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface TodoListRepository extends JpaRepository<TodoList, UUID> {

}
