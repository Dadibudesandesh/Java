package com.librarySystem.controller;

import com.librarySystem.entity.Book;
import com.librarySystem.entity.BookRequest;
import com.librarySystem.entity.Borrow;
import com.librarySystem.entity.Student;
import com.librarySystem.repository.BookRepository;
import com.librarySystem.repository.BookRequestRepository;
import com.librarySystem.repository.StudentRepository;
import com.librarySystem.service.*;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.security.Principal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class adminController {

    @Autowired
    private StudentService studentService;

    @Autowired
    private BookService bookService;

    @Autowired
    private StatisticsService statisticsService;

    @Autowired
    private BookRequestRepository bookRequestRepository;

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private BookRequestService bookRequestService;

    @Autowired
    private BorrowService borrowService;


    @GetMapping("/admin/addStudent")
    public String addStudentPage(HttpSession session) {
        Object loggedInUser = session.getAttribute("role");
        if (!(loggedInUser == "admin")) {
            return "redirect:/login";
        }
        return "admin/addStudent";
    }

    @GetMapping("/admin/manageStudent")
    public ModelAndView getStudent(HttpSession session){
        Object role = session.getAttribute("role");
        if (role == null || !role.equals("admin")) {
            return new ModelAndView("redirect:/login");
        }
        List<Student> list = studentService.getAllStudent();
        return new ModelAndView("admin/manageStudent","students",list);
    }

    @GetMapping("/admin/addBook")
    public String addBooksPage(HttpSession session) {
        Object role = session.getAttribute("role");
        if (role == null || !role.equals("admin")) {
            return "redirect:/login";
        }
        return "admin/addBook";
    }

    @GetMapping("/admin/manageBook")
    public ModelAndView getBookPage(HttpSession session){
        Object role = session.getAttribute("role");
        if (role == null || !role.equals("admin")) {
            return new ModelAndView("redirect:/login");
        }
        List<Book> list = bookService.getAllBook();
        return new ModelAndView("admin/manageBook","books",list);
    }


//    @GetMapping("/admin/statistic")
//    public String showStatistics(Model model) {
//        Map<String, Integer> returnedBooksByMonth = getReturnedBooksByMonth(); // Ensure this method returns a valid map
//
//        if (returnedBooksByMonth == null) {
//            returnedBooksByMonth = new HashMap<>(); // Prevent null error
//        }
//
//        model.addAttribute("returnedBooksByMonth", returnedBooksByMonth);
//        return "admin/statistic";
//    }


    @GetMapping("/admin/borrowBook")
    public String borrowBookPage(HttpSession session) {
        Object role = session.getAttribute("role");
        if (role == null || !role.equals("admin")) {
            return "redirect:/login";
        }
        return "admin/borrowBook";
    }


    @PostMapping("/saveBook")
    public String addBook(@ModelAttribute Book b) {
        bookService.save(b);
        return "redirect:/admin/addBook";
    }

    @PostMapping("/saveStudent")
    public String addStudent(@ModelAttribute Student  s) {
        studentService.save(s);
        return "redirect:/admin/addStudent";
    }


    @RequestMapping("/updateStudent/{id}")
    public String updateStudent(@PathVariable("id") int id, Model model , HttpSession session) {

        Object role = session.getAttribute("role");
        if (role == null || !role.equals("admin")) {
            return "redirect:/login";
        }

        Student s = studentService.getStudentById(id);

        List<String> classes = List.of("BCA I", "BCA II", "BCA III",
                "BBA I", "BBA II", "BBA III",
                "MCA I", "MCA II", "MBA I", "MBA II");

        List<String> roles = List.of("student");
        model.addAttribute("roles",roles);
        model.addAttribute("classes", classes);
        model.addAttribute("student", s);
        return "admin/updateStudent";
    }

    @RequestMapping("/deleteStudent/{id}")
    public String deleteStudent(@PathVariable("id") int id) {
        studentService.deleteById(id);
        return "redirect:/admin/manageStudent";
    }

    @GetMapping("/admin/statistics")
    public String showStatisticsPage(Model model) {
        model.addAttribute("returnedBooksByMonth", statisticsService.getReturnedBooksByMonth());
        model.addAttribute("pendingBooks", statisticsService.getPendingBooks());
        model.addAttribute("totalBorrowed", statisticsService.getTotalBorrowedBooks());
        model.addAttribute("totalReturned", statisticsService.getTotalReturnedBooks());
        model.addAttribute("mostBorrowedBooks", statisticsService.getMostBorrowedBooks());
        model.addAttribute("activeBorrowers", statisticsService.getActiveBorrowers());
        return "admin/statistics";
    }


    @GetMapping("/admin/bookRequests")
    public String viewRequests(Model model , HttpSession session) {
        Object role = session.getAttribute("role");
        if (role == null || !role.equals("admin")) {
            return "redirect:/login";
        }
        model.addAttribute("requests", bookRequestRepository.findByStatus("PENDING"));
        return "admin/bookRequests";
    }


    @GetMapping("/request-borrow/{bookId}")
    public String requestBook(@PathVariable int bookId, HttpSession session, RedirectAttributes redirectAttributes) {
        Student student = (Student) session.getAttribute("loggedInUser");

        if (student == null) {
            redirectAttributes.addFlashAttribute("error", "You need to log in first.");
            return "redirect:/login";
        }

        Book book = bookService.getBookById(bookId);

        if (book != null) {
            BookRequest bookRequest = new BookRequest();
            bookRequest.setStudent(student);
            bookRequest.setBook(book);
            bookRequest.setStatus("PENDING");

            bookRequestService.saveBookRequest(bookRequest);

            redirectAttributes.addFlashAttribute("message", "Book request sent successfully!");
        } else {
            redirectAttributes.addFlashAttribute("error", "Book not found.");
        }

        return "redirect:/student/borrowRequest";
    }



    @PostMapping("/approve-request/{id}")
    public String approveRequest(@PathVariable Long id) {
        BookRequest request = bookRequestRepository.findById(id).orElse(null);
        if (request != null) {
            request.setStatus("APPROVED");
            bookRequestRepository.save(request);
        }
        return "redirect:/admin/bookRequests";
    }

    @PostMapping("/reject-request/{id}")
    public String rejectRequest(@PathVariable Long id) {
        BookRequest request = bookRequestRepository.findById(id).orElse(null);
        if (request != null) {
            request.setStatus("REJECTED");
            bookRequestRepository.save(request);
        }
        return "redirect:/admin/bookRequests";
    }

    @GetMapping("/admin/manageBorrow")
    public String manageBorrowPage(HttpSession session,Model model){
        Object role = session.getAttribute("role");
        if (role == null || !role.equals("admin")) {
            return "redirect:/login";
        }
        List<Borrow> list = borrowService.getAllBorrow();

        model.addAttribute("borrowList",list);
        return "admin/manageBorrow";
    }





}
