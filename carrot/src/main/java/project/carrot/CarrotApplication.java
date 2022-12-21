package project.carrot;

import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import javax.persistence.EntityManager;

@SpringBootApplication
public class CarrotApplication {

	public static void main(String[] args) {
		SpringApplication.run(CarrotApplication.class, args);
	}
}
