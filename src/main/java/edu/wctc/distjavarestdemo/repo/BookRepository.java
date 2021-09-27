package edu.wctc.distjavarestdemo.repo;

import edu.wctc.distjavarestdemo.entity.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Integer> {
}
