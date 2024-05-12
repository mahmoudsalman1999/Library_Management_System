package com.example.demo.service;

import com.example.demo.Entity.Book;
import com.example.demo.Entity.BorrowingRecord;
import com.example.demo.Entity.Patron;
import com.example.demo.Repository.Book_Repository;
import com.example.demo.Repository.BorrowingRecord_Repository;
import com.example.demo.Repository.Patron_Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class BorrowingService {
    @Autowired
    private BorrowingRecord_Repository repository;
   @Autowired
   private Book_Repository bookRepository;
   @Autowired
   private Patron_Repository patronRepository;
    public void borrowBook(int bookId, int patronId) {
        // Fetch book from database
        Book book = bookRepository.findById(bookId).get();

        // Fetch patron from database
        Patron patron = patronRepository.findById(patronId)
                .get();

        // Check if the book is available for borrowing
        BorrowingRecord borrowingRecord = new BorrowingRecord();
        borrowingRecord.setBook(book);
        borrowingRecord.setPatron(patron);
        borrowingRecord.setBorrowingDate(new Date());


        // Update book status

        // Save borrowing record and update book in the database
        repository.save(borrowingRecord);
        bookRepository.save(book);
        }

    public void returnBook(int bookId, int patronId) {
        // Fetch the borrowing record from the database based on book and patron IDs
        BorrowingRecord borrowingRecord = repository.findByBookIdAndPatronIdAndReturnDateIsNull(bookId, patronId);



        // Set the return date to mark when the book was returned
        borrowingRecord.setReturnDate(new Date());

        // Update the book status to indicate it's available for borrowing
        Book book = borrowingRecord.getBook();


        // Save the updated borrowing record and book entity in the database
        repository.save(borrowingRecord);
        bookRepository.save(book);
    }
}
