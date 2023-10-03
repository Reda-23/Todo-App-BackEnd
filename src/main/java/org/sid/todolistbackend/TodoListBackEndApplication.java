package org.sid.todolistbackend;

import org.sid.todolistbackend.services.TodoService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class TodoListBackEndApplication {

    public static void main(String[] args) {
        SpringApplication.run(TodoListBackEndApplication.class, args);
    }


    @Bean
    CommandLineRunner run(TodoService todoService){
        return args -> {

        };
    }

}
