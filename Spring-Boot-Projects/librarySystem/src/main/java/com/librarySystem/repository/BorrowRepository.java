package com.librarySystem.repository;
import com.librarySystem.entity.Book;
import com.librarySystem.entity.Borrow;
import com.librarySystem.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;


@Repository
public interface BorrowRepository extends JpaRepository<Borrow, Integer> {

    List<Borrow> findByStudentId(Integer studentId);

    List<Borrow> findByBookId(Integer bookId);

    List<Borrow> findByBookIdAndStatus(Integer bookId, String status);

    List<Borrow> findByStatus(String status);

    Borrow findByStudentAndBookAndReturnDateIsNull(Student student, Book book);

    List<Borrow> findByStudent(Student student);

    long countByStatus(String isReturned);

    @Query("SELECT b.book.name, COUNT(b.book.id) FROM Borrow b GROUP BY b.book ORDER BY COUNT(b.book.id) DESC")
    List<Object[]> findMostBorrowedBooks();

    @Query("SELECT b.student.name, COUNT(b) FROM Borrow b GROUP BY b.student.name ORDER BY COUNT(b) DESC LIMIT 5")
    List<Object[]> findActiveBorrowers();


    long countByReturnDateIsNull();

    long countByReturnDateIsNotNull();
}
