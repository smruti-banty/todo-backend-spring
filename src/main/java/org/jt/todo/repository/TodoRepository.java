package org.jt.todo.repository;

import org.jt.todo.model.Todo;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TodoRepository
        extends MongoRepository<Todo, String> {
}
