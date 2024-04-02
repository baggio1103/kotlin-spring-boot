package com.javajedi.jps.jpsserver;

import com.javajedi.jps.todo.Todo;
import com.javajedi.jps.todo.TodoJpsClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/todos")
public class TodoController {

    private final TodoJpsClient jpsClient;

    public TodoController(TodoJpsClient jpsClient) {
        this.jpsClient = jpsClient;
    }

    @GetMapping
    public List<Todo> findAllTodos() {
        return jpsClient.findAll();
    }

}
