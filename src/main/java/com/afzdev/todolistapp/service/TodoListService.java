package com.afzdev.todolistapp.service;

import com.afzdev.todolistapp.model.TodoList;

import java.util.UUID;

public interface TodoListService {
    TodoList createTodoList();
    TodoList getTodoList(UUID id);
    TodoList updateTodoList(UUID id, TodoList todoList);
    TodoList deleteTodoList(UUID id);

}
