package com.afzdev.todolistapp.repository;

import com.afzdev.todolistapp.model.TodoItem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface TodoItemRepository extends JpaRepository<TodoItem, UUID> {

}
