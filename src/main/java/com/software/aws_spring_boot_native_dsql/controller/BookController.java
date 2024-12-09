package com.software.aws_spring_boot_native_dsql.controller;

import com.software.aws_spring_boot_native_dsql.model.Book;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@EnableWebMvc
public class BookController {

    @GetMapping(path = "/books")
    public List<Book> listBooks(@RequestParam("limit") Optional<Integer> limit, Principal principal) {
        System.out.println("Listing Books");

        List<Book> books = new ArrayList<>();

        Book book = new Book();
        book.setId(UUID.randomUUID());
        book.setTitle("The Great Gatsby");

        books.add(book);

        System.out.println("Finished listing books");
        return books;
    }

}
