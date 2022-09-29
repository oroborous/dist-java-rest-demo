package edu.wctc.distjavarestdemo.controller;

import edu.wctc.distjavarestdemo.entity.Book;
import edu.wctc.distjavarestdemo.repo.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/books")
public class BookController {
    private BookRepository bookRepo;

    @Autowired
    public BookController(BookRepository ar) {
        this.bookRepo = ar;
    }

    @GetMapping
    public List<Book> getBooks() {
        List<Book> list = new ArrayList<>();

        bookRepo.findAll().forEach(list::add);

        return list;
    }

    @PostMapping
    public Book createBook(@RequestBody Book newBook) {
        Book savedBook = bookRepo.save(newBook);
        return savedBook;
    }
}
