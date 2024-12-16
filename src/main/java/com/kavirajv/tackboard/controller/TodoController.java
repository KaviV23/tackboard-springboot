package com.kavirajv.tackboard.controller;

import com.kavirajv.tackboard.domain.Todo;
import com.kavirajv.tackboard.services.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/todos")
public class TodoController {
    @Autowired
    TodoService todoService;

//    @GetMapping
//    public List<Todo> getTodos() {
//        // TO-DO
//    }
//
//    @PostMapping
//    public Todo saveTodo(@RequestBody String title) {
//        // TO-DO
//    }
}
