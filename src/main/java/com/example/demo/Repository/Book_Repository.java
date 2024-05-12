package com.example.demo.Repository;


import com.example.demo.Entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Book_Repository extends JpaRepository<Book, Integer> {
}
