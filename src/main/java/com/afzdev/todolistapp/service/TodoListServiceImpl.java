package com.afzdev.todolistapp.service;

import com.afzdev.todolistapp.model.TodoList;
import com.afzdev.todolistapp.repository.TodoListRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
@Transactional
public class TodoListServiceImpl implements TodoListService{

    private final TodoListRepository repository;

    @Override
    public List<TodoList> getTodoLists() {
        return repository.findAll();
    }

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
        try {
            repository.deleteById(id);
        }catch (Exception e){
            throw new RuntimeException("Erro ao tentar deletar "+id+" "+e.getMessage());
        }
    }
}
