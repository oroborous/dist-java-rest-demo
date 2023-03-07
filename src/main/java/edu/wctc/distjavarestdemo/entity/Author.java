package edu.wctc.distjavarestdemo.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="author")
@Data
@NoArgsConstructor
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="author_id")
    private int id;

    @Column(name="name")
    private String name;

    @Column(name="books_on_contract")
    private int booksOnContract;

    @Column(name="advance_per_book")
    private float advancePerBook;
}
