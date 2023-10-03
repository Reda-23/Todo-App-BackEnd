package org.sid.todolistbackend.services;

import lombok.RequiredArgsConstructor;
import org.sid.todolistbackend.dto.TodoDTO;
import org.sid.todolistbackend.mapper.TodoMapper;
import org.sid.todolistbackend.models.Todo;
import org.sid.todolistbackend.repositories.TodoRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class TodoServiceImpl implements TodoService {


    private final TodoRepository todoRepository;
    private final TodoMapper todoMapper;

    @Override
    public TodoDTO getTodoById(Long id) {
        Todo todo = todoRepository.findTodoById(id);
        if (todo == null) throw new RuntimeException("ToDo Is Null");
        return todoMapper.fromTodoToDTO(todo);
    }

    @Override
    public List<TodoDTO> TodoList() {
        List<Todo> todos = todoRepository.findAll();
        return todos.stream().map(todoMapper::fromTodoToDTO).collect(Collectors.toList());
    }

    @Override
    public List<TodoDTO> todoListSelected(){
        List<Todo> todoList = todoRepository.findTodoBySelectedIsTrue();
        return todoList.stream().map(todoMapper::fromTodoToDTO).toList();
    }

    @Override
    public List<TodoDTO> todoListSelectedFalse(){
        List<Todo> todoList = todoRepository.findTodoBySelectedIsFalse();
        return todoList.stream().map(todoMapper::fromTodoToDTO).toList();
    }

    @Override
    public TodoDTO addTodo(TodoDTO todoDTO) {
        Todo todo = todoMapper.fromDTOToTodo(todoDTO);
        todo.setAddedDate(LocalDate.now());
        todo.setSelected(false);
        Todo savedTodo = todoRepository.save(todo);
        return todoMapper.fromTodoToDTO(savedTodo);
    }

    @Override
    public TodoDTO updateTodo(Long id, TodoDTO todoDTO) {
        Todo todo = todoRepository.findTodoById(id);
        if (todo == null) throw new RuntimeException("ToDo Is Null");
        TodoDTO updatedTodo = todoMapper.fromTodoToDTO(todo);
        updatedTodo.setId(todoDTO.getId());
        updatedTodo.setTitle(todoDTO.getTitle());
        updatedTodo.setSelected(!todo.isSelected());
        updatedTodo.setDueDate(todoDTO.getDueDate());
        todoRepository.save(todoMapper.fromDTOToTodo(updatedTodo));
        return updatedTodo;
    }

    @Override
    public void deleteTodo(Long id) {
        Todo deletedTodo = todoRepository.findTodoById(id);
        if (deletedTodo == null) throw new RuntimeException("ToDo Is Null");
        todoRepository.delete(deletedTodo);
    }

    @Override
    public List<TodoDTO> sortTodoByDueDate() {
        List<Todo> sortedTodo = todoRepository.findByOrderByDueDateAsc();
        return sortedTodo.stream().map(todoMapper::fromTodoToDTO).collect(Collectors.toList());
    }

}
