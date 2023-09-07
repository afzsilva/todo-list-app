package com.afzdev.todolistapp.service;

import com.afzdev.todolistapp.model.TodoItem;
import com.afzdev.todolistapp.repository.TodoItemRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
@Transactional
public class TodoItemServiceImpl implements TodoItemService{

    private final TodoItemRepository repository;

    @Override
    public List<TodoItem> getTodoItems() {
        return repository.findAll();
    }

    @Override
    public TodoItem createTodoItem(TodoItem todoItem) {
        return repository.save(todoItem);
    }

    @Override
    public TodoItem getTodoItem(UUID id) {
        return repository.findById(id).orElseThrow(()-> new IllegalArgumentException("id "+id+" Não existe"));
    }

    @Override
    public TodoItem updateTodoItem(UUID id, TodoItem todoItem) {
        TodoItem list = repository.findById(id).orElseThrow();
        todoItem.setId(id);
        return repository.save(todoItem);
    }

    @Override
    public void deleteTodoItem(UUID id) {
        try {
            repository.deleteById(id);
        }catch (Exception e){
            throw new RuntimeException("Erro ao tentar deletar "+id+" "+e.getMessage());
        }
    }

    @Override
    public TodoItem markTodoItemCompleted(UUID id) {
        TodoItem todoItem = repository.findById(id).orElseThrow(()-> new RuntimeException("Não existe o "+id+"na base"));

        if (todoItem.isCompleted()){
            todoItem.setCompleted(false);
        }else {
            todoItem.setCompleted(true);
        }

        return repository.save(todoItem);
    }
}
