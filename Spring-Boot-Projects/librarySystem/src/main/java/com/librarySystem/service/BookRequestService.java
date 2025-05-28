package com.librarySystem.service;

import com.librarySystem.entity.BookRequest;
import com.librarySystem.repository.BookRequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookRequestService {
    @Autowired
    private BookRequestRepository bookRequestRepository;

    public void saveBookRequest(BookRequest bookRequest) {
        bookRequestRepository.save(bookRequest);
    }
}
