package org.jt.todo.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Data
public class Todo {
    @Id
    private String id;
    private String title;
    private boolean isCompleted;
}
