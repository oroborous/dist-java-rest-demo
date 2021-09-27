package edu.wctc.distjavarestdemo.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@Entity
@Table(name="book")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="book_id")
    private int id;
    private String isbn;
    private String title;
    private String subtitle;
    private String author;
    @Column(name="publication_date")
    private LocalDate publicationDate;
    private String publisher;
    @Column(name="page_count")
    private int pageCount;
    private String description;
    private String website;
}
