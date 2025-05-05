package com.librarySystem.service;

import com.librarySystem.entity.Book;
import com.librarySystem.entity.Student;
import com.librarySystem.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    @Autowired
    private BookRepository bRepo;

    public void save(Book b){
        bRepo.save(b);
    }

    public List<Book> getAllBook(){
        return  bRepo.findAll();
    }

    public void deleteById(int id){
        bRepo.deleteById(id);
    }

    public Book getBookById(int id){
        return bRepo.findById(id).get();
    }

}
