package org.jt.todo.service;

import lombok.RequiredArgsConstructor;
import org.jt.todo.model.Todo;
import org.jt.todo.repository.TodoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TodoService {
    private final TodoRepository repository;

    public Todo createTodo(Todo todo) {
        return repository.save(todo);
    }

    public List<Todo> getAllTodos() {
        return repository.findAll();
    }

    public Todo updateTodo(String id, Todo updatedTodo) {
        if (!repository.existsById(id)) {
            throw new IllegalArgumentException("Todo with id " + id + " does not exist");
        }
        updatedTodo.setId(id);
        return repository.save(updatedTodo);
    }

    public void deleteTodoById(String id) {
        if (!repository.existsById(id)) {
            throw new IllegalArgumentException("Todo with id " + id + " does not exist");
        }
        repository.deleteById(id);
    }

    public Todo updateState(String id, boolean state) {
        Todo todo = repository.findById(id).orElseThrow();
        todo.setCompleted(state);
        repository.save(todo);
        return todo;
    }

    public void deleteAll() {
        repository.deleteAll();
    }
}
