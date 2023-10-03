package org.sid.todolistbackend.mapper;

import org.sid.todolistbackend.dto.TodoDTO;
import org.sid.todolistbackend.models.Todo;

public interface TodoMapper {



    TodoDTO fromTodoToDTO(Todo todo);
    Todo fromDTOToTodo(TodoDTO todoDTO);
}
