package com.librarySystem.service;

import com.librarySystem.entity.Student;
import com.librarySystem.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

    @Autowired
    private StudentRepository studentRepository;

    public Student login(String email, String password) {
        Student student = studentRepository.findByEmail(email);

        if (student == null) {
            return null;
        }
        if(student.getPassword().equals(password)) {
            System.out.println("Password matches!");
            return student;
        }
        return null;
    }
}
