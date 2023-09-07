package com.afzdev.todolistapp.controller;

import com.afzdev.todolistapp.model.TodoItem;
import com.afzdev.todolistapp.service.TodoItemService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@RestController
@RequestMapping("api/v1/todo-items")
public class TodoItemController {

    private final TodoItemService service;

    @GetMapping
    ResponseEntity<List<TodoItem>> getTodoItems(){
        return ResponseEntity.ok(service.getTodoItems());
    }
    @PostMapping
    ResponseEntity<TodoItem> createTodoItem(@RequestBody TodoItem todoItem){
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(todoItem.getId()).toUri();
        return ResponseEntity.created(uri).body(service.createTodoItem(todoItem));
    }

    @GetMapping("/{id}")
    ResponseEntity<TodoItem> getTodoItem(@PathVariable("id") UUID id){
        return ResponseEntity.ok(service.getTodoItem(id));
    }

    @PutMapping("/{id}")
    ResponseEntity<TodoItem> updateTodoItem(@PathVariable("id") UUID id, @RequestBody TodoItem todoItem){
        return ResponseEntity.ok(service.updateTodoItem(id,todoItem));
    }
    @DeleteMapping("/{id}")
    ResponseEntity<Void> deleteTodoItem(@PathVariable("id") UUID id){
        service.deleteTodoItem(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("status/{id}")
    ResponseEntity<TodoItem> updateTodoItem(@PathVariable("id") UUID id){
        return ResponseEntity.ok(service.markTodoItemCompleted(id));
    }


}
