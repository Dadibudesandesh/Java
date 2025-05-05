package com.librarySystem.controller;

import com.librarySystem.entity.Book;
import com.librarySystem.entity.Borrow;
import com.librarySystem.service.BookService;
import com.librarySystem.service.BorrowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.util.List;

@Controller
@RequestMapping("/admin")
public class ReportController {

    @Autowired
    private BorrowService borrowService;

    @Autowired
    private BookService bookService;

    // ✅ Load the form where admin can enter student ID
    @GetMapping("/studentBookReport")
    public String showReportPage() {
        return "admin/studentBookReport"; // Ensure this view exists
    }

    // ✅ Generate report when student ID is provided
    @GetMapping("/studentBookReport_view")
    public String generateReport(@RequestParam Integer studentId, Model model) {
        System.out.println("Received studentId: " + studentId); // Debugging statement
        List<Borrow> borrowedBooks = borrowService.getBorrowedBooks(studentId);

        model.addAttribute("studentId", studentId);
        model.addAttribute("borrowedBooks", borrowedBooks);

        return "admin/studentBookReport"; // Ensure this view exists
    }

    @GetMapping("/returnBookReport")
    public String getReturnedBooksBetweenDates(
            @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate,
            @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate endDate,
            Model model) {

        if (startDate != null && endDate != null) {
            List<Borrow> returnedBooks = borrowService.getReturnedBooksBetweenDates(startDate, endDate);
            model.addAttribute("returnedBooks", returnedBooks);
        }

        model.addAttribute("startDate", startDate);
        model.addAttribute("endDate", endDate);

        return "admin/returnBookReport";
    }

    @GetMapping("/borrowBookReport")
    public String getBorrowersByBook(@RequestParam(required = false) Integer bookId, Model model) {
        List<Book> books = bookService.getAllBooks();
        model.addAttribute("books", books);

        if (bookId != null) {
            Book selectedBook = bookService.getBookById(bookId); // you must have this method
            List<Borrow> borrowedRecords = borrowService.getBorrowersByBook(bookId);
            model.addAttribute("borrowedRecords", borrowedRecords);
            model.addAttribute("selectedBook", selectedBook);
        }

        return "admin/borrowBookReport";
    }



}
