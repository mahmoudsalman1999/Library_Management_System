package com.example.demo.Controller;


import com.example.demo.service.BorrowingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/BorrowingRecord")
public class BorrowingRecord_Controller {
    @Autowired
    private BorrowingService borrowingService; // Assuming you have a BorrowingService to interact with the database

    @PostMapping("/borrow/{bookId}/patron/{patronId}")
    public ResponseEntity<?> borrowBook(@PathVariable int bookId, @PathVariable int patronId) {
        try {
            borrowingService.borrowBook(bookId, patronId);
            return ResponseEntity.ok().build(); // Return 200 OK upon successful borrowing
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to borrow book: " + e.getMessage());
        }
    }

    @PutMapping("/return/{bookId}/patron/{patronId}")
    public ResponseEntity<?> returnBook(@PathVariable int bookId, @PathVariable int patronId) {
        try {
            borrowingService.returnBook(bookId, patronId);
            return ResponseEntity.ok().build(); // Return 200 OK upon successful return
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to return book: " + e.getMessage());
        }
    }

}
