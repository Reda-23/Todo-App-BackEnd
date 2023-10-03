package org.sid.todolistbackend.services;


import org.sid.todolistbackend.dto.TodoDTO;
import org.sid.todolistbackend.models.Todo;

import java.util.List;

public interface TodoService {


    TodoDTO getTodoById(Long id);
    List<TodoDTO> TodoList();

    List<TodoDTO> todoListSelected();

    List<TodoDTO> todoListSelectedFalse();

    TodoDTO addTodo(TodoDTO todoDTO);
    TodoDTO updateTodo(Long id,TodoDTO todoDTO);
    void deleteTodo(Long id);
    List<TodoDTO> sortTodoByDueDate();

}
