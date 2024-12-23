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


    public Todo saveTodo(User user, TodoRequest request) {
        Todo todo = new Todo();
        todo.setTitle(request.getTitle());
        todo.setDescription(request.getDescription());
        todo.setUser(user);
        return todoRepo.save(todo);
    }

    public List<Todo> findByUserAndStatus(User user, String status) {
        return todoRepo.findTodoByUserAndStatus(user, status);
    }

    public int updateStatusById(Long id, String status) {
        return todoRepo.updateStatusById(id, status);
    }


    // unused actions

    public List<Todo> findByUser(User user) {
        return todoRepo.findTodoByUser(user);
    }

    public List<Todo> getUserTodosById(Long id) {
        return todoRepo.findTodoById(id);
    }

}
