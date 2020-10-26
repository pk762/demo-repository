package whz.pti.eva.gradeCalculator;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class GradeCalculatorBaitakovaStraesserApplication {

	public static void main(String[] args) {
		SpringApplication.run(GradeCalculatorBaitakovaStraesserApplication.class, args);
	}
	
	@Bean
    CommandLineRunner init() {
        return (evt) -> {
        	System.out.println("Nur ein kleiner Test");
        };
	}
}
