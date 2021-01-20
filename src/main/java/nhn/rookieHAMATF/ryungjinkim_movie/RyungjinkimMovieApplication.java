package nhn.rookieHAMATF.ryungjinkim_movie;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class RyungjinkimMovieApplication {

	public static void main(String[] args) {
		SpringApplication.run(RyungjinkimMovieApplication.class, args);
	}

}
