package com.afzdev.todolistapp.service;

import com.afzdev.todolistapp.model.TodoList;

import java.util.List;
import java.util.UUID;

public interface TodoListService {
    List<TodoList> getTodoLists();
    TodoList createTodoList(TodoList todoList);
    TodoList getTodoList(UUID id);
    TodoList updateTodoList(UUID id, TodoList todoList);
    void deleteTodoList(UUID id);

}
