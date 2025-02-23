package fr.hb.color_run;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("fr.hb.color_run")
public class ColorRunApplication {

	public static void main(String[] args) {
		SpringApplication.run(ColorRunApplication.class, args);
	}

}
