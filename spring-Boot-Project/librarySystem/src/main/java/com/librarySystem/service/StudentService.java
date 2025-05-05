package com.librarySystem.service;

import com.librarySystem.entity.Book;
import com.librarySystem.entity.Student;
import com.librarySystem.repository.BookRepository;
import com.librarySystem.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

        @Autowired
        private StudentRepository sRepo;

        public void save(Student s){
            sRepo.save(s);
        }

        public  List<Student> getAllStudent(){
            return  sRepo.findAll();
        }

        public void deleteById(int id){
            sRepo.deleteById(id);
        }

        public Student getStudentById(int id){
            return sRepo.findById(id).get();
        }

    }

