package com.librarySystem.service;

import com.librarySystem.entity.Borrow;
import com.librarySystem.repository.BorrowRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.YearMonth;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class StatisticsService {
    @Autowired
    private BorrowRepository borrowRepository;

    // Get count of returned books per month
    public Map<YearMonth, Long> getReturnedBooksByMonth() {
        List<Borrow> returnedBooks = borrowRepository.findByStatus("returned");
        return returnedBooks.stream()
                .collect(Collectors.groupingBy(
                        b -> YearMonth.from(b.getReturnDate()),
                        Collectors.counting()
                ));
    }

    // Get list of non-returned books
    public List<Borrow> getPendingBooks() {
        return borrowRepository.findByStatus("borrowed");
    }

    // Total borrowed books
    public long getTotalBorrowedBooks() {
        return borrowRepository.count();
    }

    // Total returned books
    public long getTotalReturnedBooks() {
        return borrowRepository.countByStatus("returned");
    }

    // Most borrowed books (Top 5)
    public List<Object[]> getMostBorrowedBooks() {
        return borrowRepository.findMostBorrowedBooks();
    }

    // Most active borrowers (Top 5)
    public List<Object[]> getActiveBorrowers() {
        return borrowRepository.findActiveBorrowers();
    }
}
