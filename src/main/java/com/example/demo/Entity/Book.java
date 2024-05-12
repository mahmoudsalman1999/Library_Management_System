package com.example.demo.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int book_id;
    private String book_title;
    private String book_author;
    private LocalDate publication_year;
    private int ISBN;
    @OneToMany(mappedBy = "book")
    private List<BorrowingRecord> borrowingRecords;

    
}
