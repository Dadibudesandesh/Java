package com.librarySystem.repository;

import com.librarySystem.entity.BookRequest;
import com.librarySystem.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRequestRepository extends JpaRepository<BookRequest, Long> {

    List<BookRequest> findByStatus(String status);

    long countByStatus(String pending);

    List<BookRequest> findByStudent(Student student);
}

