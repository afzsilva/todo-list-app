package com.afzdev.todolistapp.controller;

import com.afzdev.todolistapp.model.TodoList;
import com.afzdev.todolistapp.service.TodoListService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.UUID;
@AllArgsConstructor
@RestController
@RequestMapping("api/todolist/")
public class TodoListController {

    private final TodoListService service;

    @GetMapping
    ResponseEntity<List<TodoList>> getTodoLists(@PathVariable("id") UUID id){
        return ResponseEntity.ok(service.getTodoLists());
    }
    @PostMapping
    ResponseEntity<TodoList> createTodoList(@RequestBody TodoList todoList){
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(todoList.getId()).toUri();
        return ResponseEntity.created(uri).body(service.createTodoList(todoList));
    }

    @GetMapping("/{id}")
    ResponseEntity<TodoList> getTodoList(@PathVariable("id") UUID id){
        return ResponseEntity.ok(service.getTodoList(id));
    }

    @PutMapping("/{id}")
    ResponseEntity<TodoList> updateTodoList(@PathVariable("id") UUID id, @RequestBody TodoList todoList){
        return ResponseEntity.ok(service.updateTodoList(id,todoList));
    }
    @DeleteMapping("/{id}")
    ResponseEntity<Void> deleteTodoList(@PathVariable("id") UUID id){
        service.deleteTodoList(id);
        return ResponseEntity.noContent().build();
    }

}
