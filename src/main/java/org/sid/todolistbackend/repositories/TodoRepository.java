package org.sid.todolistbackend.repositories;

import org.sid.todolistbackend.models.Todo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TodoRepository extends JpaRepository<Todo,Long> {

    Todo findTodoById(Long id);
    List<Todo> findByOrderByDueDateAsc();
    List<Todo> findTodoBySelectedIsTrue();
    List<Todo> findTodoBySelectedIsFalse();
}
