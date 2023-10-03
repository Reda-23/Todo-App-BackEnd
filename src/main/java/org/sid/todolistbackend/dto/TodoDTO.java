package org.sid.todolistbackend.dto;


import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
public class TodoDTO {

    private Long id;
    private String title;
    private LocalDate addedDate;
    private LocalDate dueDate;

    private boolean selected ;

   public TodoDTO(String title){
       this.title = title;
   }

}
