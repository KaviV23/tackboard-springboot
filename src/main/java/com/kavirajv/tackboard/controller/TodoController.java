package com.kavirajv.tackboard.controller;

import com.kavirajv.tackboard.domain.Todo;
import com.kavirajv.tackboard.domain.User;
import com.kavirajv.tackboard.dto.TodoRequest;
import com.kavirajv.tackboard.services.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:5173")
@RequestMapping("/api/todos")
public class TodoController {

    @Autowired
    private TodoService todoService;

    @PostMapping
    public ResponseEntity<?> saveTodo(@AuthenticationPrincipal User user, @RequestBody TodoRequest request) {
        Todo newTodo = todoService.saveTodo(user, request);

        return ResponseEntity.ok(newTodo);
    }

    @GetMapping
    public ResponseEntity<?> getTodos(@AuthenticationPrincipal User user) {
        List<Todo> todosByUser = todoService.findByUserAndStatus(user, "Pending");
        return ResponseEntity.ok(todosByUser);
    }

    @PostMapping("/updateStatus")
    public ResponseEntity<?> updateStatusToComplete(@RequestBody TodoRequest request) {
        return ResponseEntity.ok(todoService.updateStatusById(request.getId(), "Complete"));
    }

}
