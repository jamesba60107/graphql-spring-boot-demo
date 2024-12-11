package com.graphql;

import org.springframework.graphql.data.method.annotation.Argument;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public record Book (Integer id,
                    String name,
                    Integer pageCount,
                    Integer authorId) {

    public static List<Book> books = Arrays.asList(
            new Book(1, "Quran", 604, 1),
            new Book(2, "Harry Potter", 700, 2),
            new Book(3, "Foobar", 100, 3),
            new Book(4, "Spring Boot", 334, null)
    );

    public static Optional<Book> getBookById(Integer id) {
        return books.stream()
                .filter(b -> b.id().equals(id))
                .findFirst();
    }

    public static Optional<List<Book>> getBookListByIdGreaterThan(Integer id) {
        return Optional.of(books.stream()
                .filter(b -> b.id() > id)
                .toList());
    }

    public static Optional<List<Book>> getBookListByIdLessThan(@Argument("id") Integer id) {
        return Optional.of(books.stream()
                .filter(b -> b.id() < id)
                .toList());
    }

    public static Optional<List<Book>> getBookListByPageCountGreaterThan(@Argument("pageCount") Integer pageCount) {
        return Optional.of(books.stream()
                .filter(b -> b.pageCount() > pageCount)
                .toList());
    }

    public static Optional<List<Book>> getBookListByPageCountLessThan(@Argument("pageCount") Integer pageCount) {
        return Optional.of(books.stream()
                .filter(b -> b.pageCount() < pageCount)
                .toList());
    }
}
