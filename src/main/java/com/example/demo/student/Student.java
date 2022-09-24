package com.example.demo.student;

import javax.persistence.*;
import java.time.LocalDate;

@Entity(name = "Student")
@Table(
        name = "student",

        uniqueConstraints = {
                @UniqueConstraint(name="student_email_unique", columnNames = {"email"})
        }
)
public class Student {
    @Id
    @SequenceGenerator(

            name = "student_sequence",
            sequenceName = "student_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "student_sequence"
    )
    @Column(
            name = "id",
            updatable = false
    )
    private int id;
    @Column(
            name = "name",
            updatable = true,
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String name;
    @Column(
            name = "email",
            updatable = true,
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String email;
    @Column(
            name = "dob",
            updatable = true,
            nullable = false
    )
    private LocalDate dob;
    @Column(
            name = "age",
            updatable = true,
            nullable = false
    )
    private int age;

    public Student() {
    }

    public Student(int id, String name, String email, LocalDate dob, int age) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.dob = dob;
        this.age = age;
    }

//    public Student(String name, String email, LocalDate dob, int age) {
//        this.name = name;
//        this.email = email;
//        this.dob = dob;
//        this.age = age;
//    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", dob=" + dob +
                ", age=" + age +
                '}';
    }
}
