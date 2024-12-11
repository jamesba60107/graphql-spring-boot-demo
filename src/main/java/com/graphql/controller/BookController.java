package com.graphql.controller;

import com.graphql.entity.AuthorEntity;
import com.graphql.entity.BookEntity;
import com.graphql.service.AuthorService;
import com.graphql.service.BookService;
import org.springframework.graphql.data.method.annotation.*;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.Optional;

@Controller
public class BookController {

    private final BookService bookService;
    private final AuthorService authorService;

    public BookController(BookService bookService,
                          AuthorService authorService) {
        this.bookService = bookService;
        this.authorService = authorService;
    }

    @QueryMapping
    public List<BookEntity> getAllBooks() {
        return BookEntity.books;
    }

    @QueryMapping
    public Optional<BookEntity> getBookById(@Argument Integer id) {
        return bookService.getBookById(id);
    }

    @QueryMapping
    public Optional<List<BookEntity>> getBookListByIdGreaterThan(@Argument Integer id) {
        return bookService.getBookListByIdGreaterThan(id);
    }

    @QueryMapping
    public Optional<List<BookEntity>> getBookListByIdLessThan(@Argument Integer id) {
        return bookService.getBookListByIdLessThan(id);
    }

    @QueryMapping
    public Optional<List<BookEntity>> getBookListByPageCountGreaterThan(@Argument Integer pageCount) {
        return bookService.getBookListByPageCountGreaterThan(pageCount);
    }

    @QueryMapping
    public Optional<List<BookEntity>> getBookListByPageCountLessThan(@Argument Integer pageCount) {
        return bookService.getBookListByPageCountLessThan(pageCount);
    }

    @SchemaMapping(typeName = "Book", field = "author")
    public Optional<AuthorEntity> author(BookEntity book) {
        return authorService.getAuthorById(book.id());
    }

    @MutationMapping
    public BookEntity createBook(@Argument String name,
                           @Argument Integer pageCount,
                           @Argument Integer authorId) {
        return bookService.createBook(name, pageCount, authorId);
    }

    @SubscriptionMapping
    public BookEntity updateBook(@Argument Integer id,
                           @Argument String name,
                           @Argument Integer pageCount,
                           @Argument Integer authorId) {
        return bookService.updateBook(id, name, pageCount, authorId);
    }
 }
