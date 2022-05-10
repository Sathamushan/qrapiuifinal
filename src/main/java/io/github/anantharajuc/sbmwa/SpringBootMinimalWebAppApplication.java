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
//@RequiredArgsConstructor
public class SpringBootMinimalWebAppApplication 
{
	
	// final UserService userService;
	public static void main(String[] args) 
	{
		SpringApplication.run(SpringBootMinimalWebAppApplication.class, args);
		
		log.info("-----> Started Spring Boot Minimal Web App - "+LocalDateTime.now());
		
		Dotenv dotenv = Dotenv.load();
		
		log.info("-----> My Secret Environment Variable 1 - "+dotenv.get("MY_ENV_VAR1", "Unable to fetch SECRET_CREDENTIAL1"));
		log.info("-----> My Secret Environment Variable 2 - "+dotenv.get("MY_ENV_VAR2", "Unable to fetch SECRET_CREDENTIAL2"));
	}
	

	/*
	 * @Bean public ModelMapper modelMapper() { return new ModelMapper(); }
	 */
	/*
	 * public void run(String... params) throws Exception { AppUser admin = new
	 * AppUser(); admin.setUsername("admin"); admin.setPassword("admin");
	 * admin.setEmail("admin@email.com"); admin.setAppUserRoles(new
	 * ArrayList<AppUserRole>(Arrays.asList(AppUserRole.ROLE_ADMIN)));
	 * 
	 * userService.signup(admin);
	 * 
	 * AppUser client = new AppUser(); client.setUsername("client");
	 * client.setPassword("client"); client.setEmail("client@email.com");
	 * client.setAppUserRoles(new
	 * ArrayList<AppUserRole>(Arrays.asList(AppUserRole.ROLE_CLIENT))); }
	 */
	 
}
