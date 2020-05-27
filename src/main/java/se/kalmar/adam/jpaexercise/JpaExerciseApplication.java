package se.kalmar.adam.jpaexercise;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import se.kalmar.adam.jpaexercise.data.AppUserDaoImpl;
import se.kalmar.adam.jpaexercise.model.AppUser;

import java.time.LocalDate;

@SpringBootApplication
public class JpaExerciseApplication {

	public static void main(String[] args) {
		SpringApplication.run(JpaExerciseApplication.class, args);


	}

}
