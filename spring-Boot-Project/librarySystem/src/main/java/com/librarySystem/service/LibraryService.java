package com.librarySystem.service;
import com.librarySystem.entity.Book;
import com.librarySystem.repository.BookRepository;
import com.librarySystem.repository.BookRequestRepository;
import com.librarySystem.repository.BorrowRepository;
import com.librarySystem.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LibraryService {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private BorrowRepository borrowRepository;

    @Autowired
    private StudentRepository studentRepository;


    @Autowired
    private BookRequestRepository bookRequestRepository;


    public long getTotalBooks() {
        return bookRepository.count(); // Count total books in the database
    }

    public long getBorrowedBooks() {
        return borrowRepository.countByReturnDateIsNull(); // Count books that are currently borrowed
    }

    public long getReturnedBooks() {
        return borrowRepository.countByReturnDateIsNotNull(); // Count books that have been returned
    }

//    public long getPendingReturns() {
//        return borrowRepository.countByReturnDateIsNull(); // Pending return books
//    }

//    public long getActiveStudents() {
//        return studentRepository.countByActiveTrue(); // Count students who are active
//}

    public long getTotalStudents() {
        return studentRepository.count(); // Count total students in the system
    }

    public long getBookRequests() {
        return bookRequestRepository.countByStatus("Pending");
    }

}
