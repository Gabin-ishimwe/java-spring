package com.example.demo.student;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service // or @Component
public class StudentService {
    public Student[] getStudents() {
        Student student1 = new Student(1, "gabin", "gabin@gmail.com", LocalDate.now(), 20);
        Student student2 = new Student(1, "ishimwe", "ishimwe@gmail.com", LocalDate.now(), 22);
        return new Student[]{student1, student2};
    }
}
