package edu.wctc.distjavarestdemo.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
public class SimpleBook {
    private String isbn;
    private String title;
    private String subtitle;
    private String authorName;
    private LocalDate publicationDate;
    private String publisher;
    private int pageCount;
    private String description;
    private String website;
}
