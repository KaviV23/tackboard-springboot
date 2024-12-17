package com.kavirajv.tackboard.services;

import com.kavirajv.tackboard.domain.Todo;
import com.kavirajv.tackboard.domain.User;
import com.kavirajv.tackboard.dto.TodoRequest;
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

    public Todo saveTodo(User user, TodoRequest request) {
        Todo todo = new Todo();
        todo.setTitle(request.getTitle());
        todo.setDescription(request.getDescription());
        todo.setUser(user);
        return todoRepo.save(todo);
    }

    public List<Todo> findByUser(User user) {
        return todoRepo.findTodoByUser(user);
    }

}
