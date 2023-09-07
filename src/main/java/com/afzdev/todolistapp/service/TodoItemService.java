package com.afzdev.todolistapp.service;

import com.afzdev.todolistapp.model.TodoItem;

import java.util.List;
import java.util.UUID;

public interface TodoItemService {
    List<TodoItem> getTodoItems();
    TodoItem createTodoItem(TodoItem todoItem);
    TodoItem getTodoItem(UUID id);
    TodoItem updateTodoItem(UUID id, TodoItem todoItem);
    void deleteTodoItem(UUID id);
    TodoItem markTodoItemCompleted(UUID id);


}
