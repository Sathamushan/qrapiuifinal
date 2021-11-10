package io.github.anantharajuc.sbmwa;

import java.time.LocalDateTime;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import io.github.cdimascio.dotenv.Dotenv;
import lombok.extern.log4j.Log4j2;

/*
 * Spring Boot Minimal Web App 
 *
 * @author <a href="mailto:arcswdev@gmail.com">Anantha Raju C</a>
 *
 */
@Log4j2
@SpringBootApplication
@EnableJpaAuditing
public class SpringBootMinimalWebAppApplication 
{
	public static void main(String[] args) 
	{
		SpringApplication.run(SpringBootMinimalWebAppApplication.class, args);
		
		log.info("-----> Started Spring Boot Minimal Web App - "+LocalDateTime.now());
		
		Dotenv dotenv = Dotenv.load();
		
		log.info("-----> My Secret Environment Variable 1 - "+dotenv.get("MY_ENV_VAR1", "Unable to fetch SECRET_CREDENTIAL1"));
		log.info("-----> My Secret Environment Variable 2 - "+dotenv.get("MY_ENV_VAR2", "Unable to fetch SECRET_CREDENTIAL2"));
	}
}
