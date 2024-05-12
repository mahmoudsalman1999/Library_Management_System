package com.example.demo.Controller;

import com.example.demo.Entity.Book;
import com.example.demo.Entity.Patron;
import com.example.demo.Repository.Book_Repository;
import com.example.demo.Repository.Patron_Repository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/patron")
public class Patron_Controller {
    @Autowired
    private Patron_Repository patronRepository;
    @PostMapping("/save")
    @Transactional
    public ResponseEntity<?> addPatron(@RequestBody Patron patron) {
        patronRepository.save(patron);
        return ResponseEntity.ok("The Patron has been added");
    }
    @GetMapping("/get")
    public ResponseEntity<?> getAllPatron()
    {
        List<Patron> patrons= patronRepository.findAll();
        if ( patrons.isEmpty())
        {
            return ResponseEntity.ok("Empty");
        }
        return ResponseEntity.ok("This all Patron : \n" + patrons);
    }

    @GetMapping ("/get/{id}")

    public ResponseEntity<?> getPatronById(@PathVariable("id") int id)
    {
        Patron patron=patronRepository.findById(id).get();
        if (patron != null)
        {
            return ResponseEntity.ok("this id Is : \n" + patron);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Patron not found with ID: " + id);
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<?> updatePatron(@PathVariable ("id") int id , @RequestBody Patron patron)
    {
        patron.setPatron_id(id);
        patronRepository.save(patron);
        return ResponseEntity.ok("Done");

    }
    @DeleteMapping("/delete/{id}")
    @Transactional
    public ResponseEntity<?> deleteById(@PathVariable("id") int id)
    {
        patronRepository.deleteById(id);
        return ResponseEntity.ok("deleted \n" );
    }

}
