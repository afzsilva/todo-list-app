package com.afzdev.todolistapp.service;

import com.afzdev.todolistapp.model.TodoList;
import com.afzdev.todolistapp.repository.TodoListRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
@AllArgsConstructor
@Transactional
public class TodoListServiceImpl implements TodoListService{

    private final TodoListRepository repository;
    @Override
    public TodoList createTodoList(TodoList todoList) {
        return repository.save(todoList);
    }

    @Override
    public TodoList getTodoList(UUID id) {
        return repository.findById(id).orElseThrow(()-> new IllegalArgumentException("id "+id+" Não existe"));
    }

    @Override
    public TodoList updateTodoList(UUID id, TodoList todoList) {
        TodoList list = repository.findById(id).orElseThrow();
        todoList.setId(id);
        return repository.save(todoList);
    }

    @Override
    public void deleteTodoList(UUID id) {
        repository.deleteById(id);
    }
}
