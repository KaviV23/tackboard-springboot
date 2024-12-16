package com.kavirajv.tackboard.services;

import com.kavirajv.tackboard.domain.Todo;
import com.kavirajv.tackboard.repository.TodoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoService {
    @Autowired
    private TodoRepo todoRepo;

    public List<Todo> getUserTodosById(Long id) {
        return todoRepo.findTodoById(id);
    }

    public Todo saveTodo(Todo todo) {
        return todoRepo.save(todo);
    }

}
