package com.sasicodes.fullStack.A.Full.stack.application.with.react.student;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentService {

    private final StudentRepository studentRepository;


    public List<Student> getAllStudents() {
       return studentRepository.findAll();
    }

    public void addStudents(Student student) {
        studentRepository.save(student);
    }
}
