package org.sid.todolistbackend.controller;


import lombok.RequiredArgsConstructor;
import org.sid.todolistbackend.dto.TodoDTO;
import org.sid.todolistbackend.services.TodoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/todo")
@RequiredArgsConstructor
@CrossOrigin("*")
public class TodoRestController {

    private final TodoService todoService;


    @GetMapping("/{id}")
    TodoDTO getTodoById(@PathVariable Long id){
        return todoService.getTodoById(id);
    }

    @GetMapping("/todos")
    List<TodoDTO> todoList(){

        return todoService.TodoList();
    }

    @GetMapping("/todoSelected")
    List<TodoDTO> todoListSelected(){
        return todoService.todoListSelected();
    }

    @GetMapping("/todoFSelected")
    List<TodoDTO> todoListSelectedFalse(){
        return todoService.todoListSelectedFalse();
    }

    @GetMapping("/todosSorted")
    List<TodoDTO> todoListSorted(){
        return todoService.sortTodoByDueDate();
    }

    @PostMapping("/add")
    TodoDTO addTodo(@RequestBody TodoDTO todoDTO){

        return todoService.addTodo(todoDTO);
    }

    @PutMapping("/update/{id}")
    TodoDTO updateTodo(@PathVariable Long id,@RequestBody TodoDTO todoDTO){
        return todoService.updateTodo(id,todoDTO);
    }

    @DeleteMapping("/delete/{id}")
    void deleteTodo(@PathVariable Long id){
        todoService.deleteTodo(id);
    }


}
