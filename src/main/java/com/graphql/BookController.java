package com.graphql;

import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.Optional;

@Controller
public class BookController {

    @QueryMapping
    public List<Book> getAllBooks() {
        return Book.books;
    }

    @QueryMapping
    public Optional<Book> getBookById(@Argument Integer id) {
        return Book.getBookById(id);
    }

    @QueryMapping
    public Optional<List<Book>> getBookListByIdGreaterThan(@Argument Integer id) {
        return Book.getBookListByIdGreaterThan(id);
    }

    @QueryMapping
    public Optional<List<Book>> getBookListByIdLessThan(@Argument Integer id) {
        return Book.getBookListByIdLessThan(id);
    }

    @QueryMapping
    public Optional<List<Book>> getBookListByPageCountGreaterThan(@Argument Integer pageCount) {
        return Book.getBookListByPageCountGreaterThan(pageCount);
    }

    @QueryMapping
    public Optional<List<Book>> getBookListByPageCountLessThan(@Argument Integer pageCount) {
        return Book.getBookListByPageCountLessThan(pageCount);
    }

    @SchemaMapping
    public Optional<Author> author(Book book) {
        return Author.getAuthorById(book.id());
    }
 }
