package edu.wctc.distjavarestdemo.controller;

import edu.wctc.distjavarestdemo.dto.SimpleBook;
import edu.wctc.distjavarestdemo.entity.Book;
import edu.wctc.distjavarestdemo.repo.BookRepository;
import org.modelmapper.ModelMapper;
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

    @Autowired
    private ModelMapper modelMapper;

    private SimpleBook convertToDto(Book book) {
//        SimpleBook simpleBook = new SimpleBook();
//        simpleBook.setDescription(book.getDescription());
//        simpleBook.setAuthorName(book.getAuthor().getName());
//        simpleBook.setIsbn(book.getIsbn());
        return modelMapper.map(book, SimpleBook.class);
    }

    @GetMapping
    public List<SimpleBook> getBooks() {
        List<SimpleBook> list = new ArrayList<>();

        bookRepo.findAll().forEach(book -> list.add(convertToDto(book)));

        return list;
    }

    @PostMapping
    public Book createBook(@RequestBody Book newBook) {
        Book savedBook = bookRepo.save(newBook);
        return savedBook;
    }
}
