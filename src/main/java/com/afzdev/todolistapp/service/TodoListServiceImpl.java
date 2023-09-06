package com.afzdev.todolistapp.service;

import com.afzdev.todolistapp.model.TodoList;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@AllArgsConstructor
@Transactional
public class TodoListServiceImpl implements TodoListService{

    @Override
    public TodoList createTodoList() {
        return null;
    }

    @Override
    public TodoList getTodoList(UUID id) {
        return null;
    }

    @Override
    public TodoList updateTodoList(UUID id, TodoList todoList) {
        return null;
    }

    @Override
    public TodoList deleteTodoList(UUID id) {
        return null;
    }
}
