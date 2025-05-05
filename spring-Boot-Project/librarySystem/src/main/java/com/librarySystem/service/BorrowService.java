package com.librarySystem.service;

import com.librarySystem.entity.Book;
import com.librarySystem.entity.Borrow;
import com.librarySystem.entity.Student;
import com.librarySystem.repository.BookRepository;
import com.librarySystem.repository.BorrowRepository;
import com.librarySystem.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class BorrowService {

    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private BorrowRepository borrowRepository;  //  Use the correct repository

    /**
     * Get the list of books borrowed by a student
     */
//    public List<Borrow> getBorrowedBooks(Integer studentId) {
//        Student student = studentRepository.findById(studentId).orElse(null);
//        if (student != null) {
//            return borrowRepository.findByStudent(student);  //  Use existing method correctly
//        }
//        return List.of();  //  Return empty list if student is not found
//    }




    public List<Borrow> getBorrowedBooks(Integer studentId) {
        Student student = studentRepository.findById(studentId).orElse(null);
        if (student != null) {
            List<Borrow> borrowedBooks = borrowRepository.findByStudent(student);
            return borrowedBooks;
        }
        return List.of();
    }

    public boolean returnBook(Integer borrowId) {
        Borrow borrow = borrowRepository.findById(borrowId).orElse(null);

        if (borrow != null && "pending".equals(borrow.getStatus())) {
            borrow.setReturnDate(LocalDate.now());
            borrow.setStatus("returned");

            borrowRepository.save(borrow);

            Book book = borrow.getBook();
            book.setQuantity(book.getQuantity() + 1);
            book.setAvailable(true);

            bookRepository.save(book);
            return true;
        }
        return false;
    }

    public Borrow borrowBook(Integer studentId, Integer bookId) {
        Student student = studentRepository.findById(studentId).orElse(null);
        Book book = bookRepository.findById(bookId).orElse(null);

        if (student != null && book != null && book.getQuantity() > 0) {
            Borrow existingBorrow = borrowRepository.findByStudentAndBookAndReturnDateIsNull(student, book);
            if (existingBorrow != null) {
                return null;
            }

            LocalDate borrowDate = LocalDate.now();
            LocalDate dueDate = borrowDate.plusWeeks(2);
            Borrow borrow = new Borrow(student, book, borrowDate, dueDate, "pending");

            borrowRepository.save(borrow);

            book.setQuantity(book.getQuantity() - 1);
            if (book.getQuantity() == 0) {
                book.setAvailable(false);
            }
            bookRepository.save(book);

            return borrow;
        }

        return null;
    }

    public List<Borrow> getAllBorrow() {
        return borrowRepository.findAll();
    }

//    public void deleteById(int id) {
//         borrowRepository.deleteById(id);
//    }
}
