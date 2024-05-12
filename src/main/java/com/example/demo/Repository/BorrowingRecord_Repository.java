package com.example.demo.Repository;


import com.example.demo.Entity.Book;
import com.example.demo.Entity.BorrowingRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BorrowingRecord_Repository extends JpaRepository<BorrowingRecord, Integer> {
    BorrowingRecord findByBookIdAndPatronIdAndReturnDateIsNull(int bookId, int patronId);
}
