package com.example.demo.Repository;


import com.example.demo.Entity.Book;
import com.example.demo.Entity.Patron;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Patron_Repository extends JpaRepository<Patron, Integer> {
}
