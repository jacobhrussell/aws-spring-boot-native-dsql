package com.software.aws_spring_boot_native_dsql.controller;

import com.software.aws_spring_boot_native_dsql.model.Book;
import com.software.aws_spring_boot_native_dsql.repository.BookRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import java.security.Principal;
import java.util.List;
import java.util.Optional;

@RestController
@EnableWebMvc
@AllArgsConstructor
public class BookController {

    private final BookRepository bookRepository;

    @GetMapping(path = "/books")
    public List<Book> listBooks(@RequestParam("limit") Optional<Integer> limit, Principal principal) {
        System.out.println("Listing Books");

        PageRequest pageRequest = PageRequest.of(0, 10, Sort.by("id"));
        List<Book> books = bookRepository.findAll(pageRequest).stream().toList();

        System.out.println("Finished listing books");

        return books;
    }

}
