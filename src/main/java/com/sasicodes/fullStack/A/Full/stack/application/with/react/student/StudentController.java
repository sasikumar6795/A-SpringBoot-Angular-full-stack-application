package com.sasicodes.fullStack.A.Full.stack.application.with.react.student;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("api/v1/students")
public class StudentController {

    @GetMapping
    public List<Student> getAllStudents() {
        List<Student> students = Arrays.asList(
                new Student(1L,
                        "sasikumar",
                        "sasi6795@gmail.com",
                        Gender.MALE),
                new Student(2L,
                        "abhinandan",
                        "abhi2795@gmail.com",
                        Gender.MALE));
        return students;
    }
}
