package miPrimerPaqueteSpring.miProyecto;

//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import miPrimerPaqueteSpring.miProyecto.domain.Car2;
import miPrimerPaqueteSpring.miProyecto.domain.Car2Repository;
import miPrimerPaqueteSpring.miProyecto.domain.Owner2;
import miPrimerPaqueteSpring.miProyecto.domain.Owner2Repository;
import miPrimerPaqueteSpring.miProyecto.domain.User;
import miPrimerPaqueteSpring.miProyecto.domain.UserRepository;

@SpringBootApplication
public class MiProyectoApplication {
	
	@Autowired
	private UserRepository urepository;

	@Autowired 
	private Car2Repository repository;
	
	@Autowired
	private Owner2Repository orepository;
	
	//private static final Logger logger = LoggerFactory.getLogger(MiProyectoApplication.class);
	
	public static void main(String[] args) {
		SpringApplication.run(MiProyectoApplication.class, args);
		//logger.info("Hello Spring Boot"); 
		
	}
	
	@Bean
	CommandLineRunner runner() {
		return args -> {
			//Add owner objects and save these to db
			Owner2 owner1 = new Owner2 ("John", "Johnson");
			Owner2 owner2 = new Owner2 ("Mary", "Robinson");
			orepository.save(owner1);
			orepository.save(owner2);
			
			//Add car object with link to owners and save these to db.
			repository.save(new Car2("Ford","Mustang", "Red", "ADF-1121",2017, 59000, owner1));
			
			repository.save(new Car2("Nissan","Leaf", "White", "SSJ-3002",2014, 29000, owner2));
			
			repository.save(new Car2("Toyota","Prius", "Silver", "KKO-0212",2018, 39000, owner2));
			
			//username: user password: user
			urepository.save(new User("user", "$2a$10$Fie.9tk3IgLHEe91CO3ucuyPPQWVF/v/VnJWKfYUF0qi6RQM.SVZu","USER"));
			
			//username: admin password: admin
			urepository.save(new User("admin","$2a$10$my8JGy0nK5ZysVE7UouYw.l8LXIEoLv6nszDfcTVk4jkfJ/1AIfwu","ADMIN"));
			
		};
	}
}
