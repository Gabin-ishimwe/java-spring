package com.example.demo.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;

@RestController
@RequestMapping(path="/api/v1/student")
public class StudentController {
    private final StudentService studentService;

    @Autowired
    StudentController(StudentService studentService) {
        this.studentService = studentService;
    }
    @GetMapping
    public List<Student> students() {
        return this.studentService.getStudents();
    }

    @PostMapping
    public void register(@RequestBody Student student) throws Exception {
        this.studentService.addStudent(student);
    }

    @DeleteMapping(path = "{studentId}")
    public void delete(@PathVariable("studentId") int id) throws IllegalAccessException {
        this.studentService.deleteStudent(id);
    }

    @PutMapping(path = {"{studentId}"})
    public void update(@PathVariable("studentId") int id,
                       @RequestBody Student student) throws IllegalAccessException {
        this.studentService.updateStudent(student, id);
    }

}
