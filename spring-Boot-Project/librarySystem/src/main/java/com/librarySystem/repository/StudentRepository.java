package com.librarySystem.repository;

import com.librarySystem.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student,Integer> {
    Student findByEmail(String email);
    Student findByName(String name);

//    long countByActiveTrue();
}
