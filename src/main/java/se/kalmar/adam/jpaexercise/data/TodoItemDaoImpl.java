package se.kalmar.adam.jpaexercise.data;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import se.kalmar.adam.jpaexercise.model.TodoItem;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Optional;

@Repository
public class TodoItemDaoImpl implements TodoItemDao{

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional
    public Optional<TodoItem> findById(String id) {
        return Optional.ofNullable(entityManager.find(TodoItem.class, id));
    }

    @Override
    @Transactional
    public Optional<TodoItem> findByTitle(String title) {
        return Optional.empty();
    }

    @Override
    @Transactional
    public Optional<TodoItem> findAll() {
        return Optional.empty();
    }

    @Override
    @Transactional
    public Optional<TodoItem> findByDone() {
        return Optional.empty();
    }

    @Override
    @Transactional
    public TodoItem update(TodoItem todoItem) {
        return entityManager.merge(todoItem);
    }

    @Override
    @Transactional
    public TodoItem save(TodoItem todoItem) {
        if (todoItem == null) {
            throw new IllegalArgumentException("Cant persist TodoItem ");
        }
        entityManager.persist(todoItem);
        return todoItem;
    }

    @Override
    @Transactional
    public boolean delete(TodoItem todoItem) {
        boolean deleted = false;
        entityManager.remove(todoItem);
        if (!findById(todoItem.getTodoId()).isPresent()) {
            deleted = true;
        }

        return false;
    }
}
