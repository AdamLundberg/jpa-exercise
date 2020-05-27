package se.kalmar.adam.jpaexercise;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import se.kalmar.adam.jpaexercise.data.AppUserDaoImpl;
import se.kalmar.adam.jpaexercise.data.TodoItemDaoImpl;
import se.kalmar.adam.jpaexercise.model.AppUser;
import se.kalmar.adam.jpaexercise.model.TodoItem;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Component
public class CommandLine implements CommandLineRunner {

    AppUserDaoImpl appUserDao;
    TodoItemDaoImpl todoItemDao;

    @Autowired
    public CommandLine(AppUserDaoImpl appUserDao, TodoItemDaoImpl todoItemDao) {
        this.appUserDao = appUserDao;
        this.todoItemDao = todoItemDao;
    }

    @Override
    public void run(String... args) throws Exception {
       AppUser appUser = new AppUser("AdamL", "Adam", "Lundberg", LocalDate.of(2020, 07, 17), true, "1234");

        appUserDao.save(appUser);

        TodoItem todoItem = new TodoItem("Clean", "Clean house", LocalDateTime.now());
        todoItemDao.save(todoItem);
    }
}
