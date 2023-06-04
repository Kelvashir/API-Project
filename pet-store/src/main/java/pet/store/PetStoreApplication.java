package pet.store;

import java.util.Collections;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication

public class PetStoreApplication {

	public static void main(String[] args) {
		SpringApplication app = new SpringApplication(PetStoreApplication.class);
		app.setDefaultProperties(Collections.singletonMap("server.port", "8083"));
		app.run(args);

	}

}
