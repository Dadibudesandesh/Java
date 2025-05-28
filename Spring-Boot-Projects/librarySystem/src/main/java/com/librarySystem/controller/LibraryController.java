package com.librarySystem.controller;

import com.librarySystem.entity.Book;
import com.librarySystem.entity.Student;
import com.librarySystem.repository.BorrowRepository;
import com.librarySystem.repository.StudentRepository;
import com.librarySystem.service.BookService;
import com.librarySystem.service.LibraryService;
import com.librarySystem.service.StudentService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Controller
public class LibraryController {

    @Autowired
    private BookService bookService;

    @Autowired
    private StudentService studentService;

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private final LibraryService libraryService;

    @Autowired
    private BorrowRepository borrowRepository;



    public LibraryController(LibraryService libraryService) {
        this.libraryService = libraryService;
    }


    @GetMapping("/admin/home")
    public String homePage(Model model, HttpSession session) {

        Object role = session.getAttribute("role");
        if (role == null || !role.equals("admin")) {
            return "redirect:/login";
        }

        List<Object[]> rawData = borrowRepository.findMostBorrowedBooks();
        List<Map<String, Object>> mostBorrowedBooks = rawData.stream().map(record -> {
            Map<String, Object> map = new HashMap<>();
            map.put("name", record[0]);  // Book title
            map.put("borrowCount", record[1]);  // Times borrowed
            return map;
        }).toList();

        model.addAttribute("mostBorrowedBooks", mostBorrowedBooks);
        model.addAttribute("totalBooks", libraryService.getTotalBooks());
        model.addAttribute("totalStudents", libraryService.getTotalStudents());
        model.addAttribute("borrowedBooks", libraryService.getBorrowedBooks());
        model.addAttribute("returnedBooks", libraryService.getReturnedBooks());
        model.addAttribute("bookRequests", libraryService.getBookRequests());
        return "admin/home";
    }

    @GetMapping("/")
    public String indexPage() {
        return "login";
    }

    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }

}
