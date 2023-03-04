package com.sasicodes.fullStack.A.Full.stack.application.with.react.student;

import com.sasicodes.fullStack.A.Full.stack.application.with.react.student.exception.StudentNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class StudentService {

    private final StudentRepository studentRepository;


    public List<Student> getAllStudents() {

        return studentRepository.findAll();
    }

    public void addStudents(Student student) {

        String studentEmail = studentRepository.findByEmail(student.getEmail());

        if(!studentEmail.isEmpty()) {
            throw new IllegalStateException("Email is already taken");
        }

        studentRepository.save(student);
    }

    public void deleteStudent(Long id) {

        if(!studentRepository.existsById(id)) {
            throw new StudentNotFoundException("Student not found");
        }

        studentRepository.deleteById(id);

    }
}
