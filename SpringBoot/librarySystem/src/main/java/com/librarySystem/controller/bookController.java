package com.librarySystem.controller;

import com.librarySystem.entity.Book;
import com.librarySystem.entity.Student;
import com.librarySystem.service.BookService;
import com.librarySystem.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class bookController {

    @Autowired
    private BookService bookService;



    @RequestMapping("/updateBook/{id}")
    public String updateBook(@PathVariable("id") int id, Model model) {
        Book b=bookService.getBookById(id);

        List<String> categories = List.of("Fiction", "Psychology", "Science",
                "Technology", "History", "Mathematics");

        model.addAttribute("categories",categories);
        model.addAttribute("book",b);
        return "admin/updateBook";
    }

}
