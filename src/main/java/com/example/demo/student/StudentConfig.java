package com.example.demo.student;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.List;

@Configuration
public class StudentConfig {
    @Bean
    CommandLineRunner commandLineRunner(StudentRepository studentRepository) {
        return args -> {
            Student gabin = new Student(
                    "Gabin",
                    "gabin@gmail.com",
                    LocalDate.now()
            );
            Student ishimwe = new Student(
                    "ishimwe",
                    "ishimwe@gmail.com",
                    LocalDate.now()
            );
            studentRepository.saveAll(List.of(gabin, ishimwe));
        };



    }
}
