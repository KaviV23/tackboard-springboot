package com.kavirajv.tackboard.repository;

import com.kavirajv.tackboard.domain.Todo;
import com.kavirajv.tackboard.domain.User;
import jakarta.persistence.OrderBy;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TodoRepo extends JpaRepository<Todo, Long> {
    List<Todo> findTodoById(Long id);
    List<Todo> findTodoByUser(User user);
    List<Todo> findTodoByUserAndStatus(User user, String string);

    @Modifying
    @Transactional
    @Query("UPDATE Todo t SET t.status = :status WHERE t.id = :id")
    int updateStatusById(Long id, String status);
}
