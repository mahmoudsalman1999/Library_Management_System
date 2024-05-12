package com.example.demo.Controller;


import com.example.demo.Entity.Book;
import com.example.demo.Repository.Book_Repository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class Book_Controller {
    @Autowired
    private Book_Repository bookRepository;
    @PostMapping("/save")
    @Transactional
    public ResponseEntity<?> addBook(@RequestBody Book books) {
        bookRepository.save(books);
        return ResponseEntity.ok("The book has been added");
    }
    @GetMapping("/get")
    public ResponseEntity<?> getAllBook()
    {
        List<Book> books= bookRepository.findAll();
        if ( books.isEmpty())
        {
            return ResponseEntity.ok("Empty");
        }
        return ResponseEntity.ok("This all Book : \n" + books);
    }

    @GetMapping ("/get/{id}")

    public ResponseEntity<?> getBookById(@PathVariable ("id") int id)
    {
        Book books=bookRepository.findById(id).get();
        if (books != null)
        {
            return ResponseEntity.ok("this id Is : \n" + books);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Book not found with ID: " + id);
    }
   @PutMapping ("/update/{id}")
   public ResponseEntity<?> updateBook(@PathVariable ("id") int id , @RequestBody Book book)
   {
       book.setBook_id(id);
       bookRepository.save(book);
       return ResponseEntity.ok("Done");

   }
   @DeleteMapping("/delete/{id}")
   @Transactional
   public ResponseEntity<?> deleteById(@PathVariable("id") int id)
   {
       bookRepository.deleteById(id);
       return ResponseEntity.ok("deleted \n" );
   }

}
