package org.sid.todolistbackend.mapper;

import org.sid.todolistbackend.dto.TodoDTO;
import org.sid.todolistbackend.models.Todo;
import org.springframework.stereotype.Component;


@Component
public class TodoMapperImpl implements TodoMapper {


    @Override
    public TodoDTO fromTodoToDTO(Todo todo) {
        TodoDTO todoDTO = new TodoDTO();
        todoDTO.setId(todo.getId());
        todoDTO.setTitle(todo.getTitle());
        todoDTO.setAddedDate(todo.getAddedDate());
        todoDTO.setDueDate(todo.getDueDate());
        todoDTO.setSelected(todo.isSelected());
        return todoDTO;
    }

    @Override
    public Todo fromDTOToTodo(TodoDTO todoDTO) {
        Todo todo = new Todo();
        todo.setId(todoDTO.getId());
        todo.setTitle(todoDTO.getTitle());
        todo.setAddedDate(todoDTO.getAddedDate());
        todo.setDueDate(todoDTO.getDueDate());
        todo.setSelected(todoDTO.isSelected());
        return todo;
    }
}
