package com.sasicodes.fullStack.A.Full.stack.application.with.react.student;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("api/v1/students")
@RequiredArgsConstructor
public class StudentController {

    private final StudentService studentService;

    @GetMapping
    public List<Student> getAllStudents() {
        return studentService.getAllStudents();
    }

    @PostMapping
    public ResponseEntity<?> addStudents(@RequestBody Student student) {
        studentService.addStudents(student);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
