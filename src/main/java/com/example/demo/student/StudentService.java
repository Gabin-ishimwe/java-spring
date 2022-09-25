package com.example.demo.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service // or @Component
public class StudentService {
    private final StudentRepository studentRepository;

    @Autowired
    StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }
    public List<Student> getStudents() {
        return this.studentRepository.findAll();
    }

    public void addStudent(Student student) throws Exception {
        final Optional<Student> studentByEmail = studentRepository.findStudentByEmail(student.getEmail());
        if(studentByEmail.isPresent()) {
            throw new Exception("Email already exists");
        }
        studentRepository.save(student);
    }

    public void deleteStudent(int id) throws IllegalAccessException {
        final var byId = studentRepository.existsById(id);
        if(!byId) {
            throw new IllegalAccessException("Student id doesn't exist");
        }
        studentRepository.deleteById(id);
    }

    @Transactional
    public void updateStudent(Student student, int id) throws IllegalAccessException {
        final Student findStudent = this.studentRepository.findById(id).orElseThrow(() -> new IllegalStateException("Studen't doesn't exist"));

        System.out.println(student);
        if(student.getName() != null &&
                student.getName().length() > 0 &&
                !Objects.equals(findStudent.getName(), student.getName())) {
            findStudent.setName(student.getName());
        }
        if(student.getEmail() != null &&
                student.getEmail().length() > 0 &&
                !Objects.equals(findStudent.getEmail(), student.getEmail())) {
            final var studentByEmail = this.studentRepository.findStudentByEmail(student.getEmail());
            if(studentByEmail.isPresent()) {
                throw new IllegalStateException("Email arleady exists");
            }
            findStudent.setEmail(student.getEmail());

        }

    }
}
