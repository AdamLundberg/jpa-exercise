package se.kalmar.adam.jpaexercise.data;

import se.kalmar.adam.jpaexercise.model.TodoItem;

import java.util.Optional;

public interface TodoItemDao {
    Optional<TodoItem> findById(String id);
    Optional<TodoItem> findByTitle(String title);
    Optional<TodoItem> findAll();
    Optional<TodoItem> findByDone();
    TodoItem update(TodoItem todoItem);
    TodoItem save(TodoItem todoItem);
    boolean delete(TodoItem todoItem);

}
