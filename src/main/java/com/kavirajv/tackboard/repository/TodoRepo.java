package com.kavirajv.tackboard.repository;

import com.kavirajv.tackboard.domain.Todo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TodoRepo extends JpaRepository<Todo, Long> {
    List<Todo> findTodoById(Long id);
}