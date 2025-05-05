package com.librarySystem.controller;

import com.librarySystem.entity.Book;
import com.librarySystem.entity.BookRequest;
import com.librarySystem.entity.Student;
import com.librarySystem.repository.BookRepository;
import com.librarySystem.repository.BookRequestRepository;
import com.librarySystem.repository.StudentRepository;
import com.librarySystem.service.BookService;
import com.librarySystem.service.BorrowService;
import com.librarySystem.service.StudentService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;
import java.util.List;

@Controller
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @Autowired
    private BookService bookService;

    @Autowired
    private BorrowService borrowService;

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private BookRequestRepository bookRequestRepository;

    @GetMapping("/home")
    public String studentHomePage(HttpSession session) {
        Object loggedInUser = session.getAttribute("loggedInUser");
        if (loggedInUser == null) {
            return "redirect:/login";
        }
        return "student/home";
    }

    @GetMapping("/request-borrow/{id}")
    public String requestBook(@PathVariable int id, Model model, Principal principal) {
        Student student = studentRepository.findByName(principal.getName());
        Book book = bookRepository.findById(id).orElse(null);

        if (book == null) {
            return "redirect:/student/home";
        }

        model.addAttribute("book", book);
        model.addAttribute("student", student);
        return "borrowRequest";
    }


    @PostMapping("/borrowRequest/{id}")
    public String confirmBorrowRequest(@PathVariable int id, Principal principal) {
        Student student = studentRepository.findByName(principal.getName());
        Book book = bookRepository.findById(id).orElse(null);

        if (book != null) {
            BookRequest request = new BookRequest();
            request.setStudent(student);
            request.setBook(book);
            request.setStatus("PENDING");
            bookRequestRepository.save(request);
        }
        return "redirect:/student/myRequests";
    }

    @GetMapping("/borrowRequest")
    public ModelAndView getBookStudentPage() {
        List<Book> list = bookService.getAllBook();
        return new ModelAndView("student/borrowRequest", "availableBooks", list);
    }

    @GetMapping("/newBooks")
    public String newBookPage(HttpSession session) {
        Object loggedInUser = session.getAttribute("loggedInUser");
        if (loggedInUser == null) {
            return "redirect:/login";
        }
        return "student/newBooks";
    }

    @GetMapping("/bookCart")
    public String bookCartPage(HttpSession session) {
        Object loggedInUser = session.getAttribute("loggedInUser");
        if (loggedInUser == null) {
            return "redirect:/login";
        }
        return "student/bookCart";
    }

    @GetMapping("/myRequests")
    public String profilePage(HttpSession session,Model model) {
        Object loggedInUser = session.getAttribute("loggedInUser");
        if (loggedInUser == null) {
            return "redirect:/login";
        }
        model.addAttribute("requests", bookRequestRepository.findByStatus("PENDING"));
        return "student/myRequests";
    }



}
