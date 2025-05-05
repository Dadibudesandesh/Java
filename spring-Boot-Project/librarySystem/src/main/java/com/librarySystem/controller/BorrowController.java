package com.librarySystem.controller;

import com.librarySystem.entity.Borrow;
import com.librarySystem.entity.Student;
import com.librarySystem.repository.BorrowRepository;
import com.librarySystem.service.BookService;
import com.librarySystem.service.BorrowService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class BorrowController {

    @Autowired
    private BorrowService borrowService;

    @Autowired
    private BookService bookService;

    @Autowired
    private BorrowRepository borrowRepository;

    @PostMapping("/admin/borrowBook")
    public String borrowBook(@RequestParam("studentId") Integer studentId,
                             @RequestParam("bookId") Integer bookId,
                             Model model) {
        Borrow borrow = borrowService.borrowBook(studentId, bookId);
        return "admin/borrowBook";
    }

    @GetMapping("/student/borrowedBooks")
    public String showBorrowedBooks(HttpSession session, Model model) {
        Object loggedInUser = session.getAttribute("loggedInUser");
        if (loggedInUser == null) {
            return "redirect:/login";
        }
        if (!(loggedInUser instanceof Student)) {
            return "redirect:/login";
        }
        Student student = (Student) loggedInUser;
        List<Borrow> borrowedBooks = borrowService.getBorrowedBooks(student.getId());
        model.addAttribute("borrowList", borrowedBooks);
        return "student/borrowedBooks";
    }


    @PostMapping("/admin/deleteBorrow/{id}")
    public String deleteBook(@PathVariable("id") int id) {
        borrowRepository.deleteById(id);
        return "redirect:/admin/manageBorrow";
    }

    @PostMapping("/admin/returnBook/{id}")
    public String returnBook(@PathVariable("id") Integer borrowId, Model model) {
        boolean success = borrowService.returnBook(borrowId);
        if (success) {
            model.addAttribute("message", "Book returned successfully!");
        } else {
            model.addAttribute("error", "Failed to return book.");
        }
        return "redirect:/admin/manageBorrow";
    }

}


