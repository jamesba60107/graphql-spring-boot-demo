package com.graphql.entity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public record BookEntity (Integer id,
                    String name,
                    Integer pageCount,
                    Integer authorId) {

    public static List<BookEntity> books = new ArrayList<>(Arrays.asList(
            new BookEntity(1, "Quran", 604, 1),
            new BookEntity(2, "Harry Potter", 700, 2),
            new BookEntity(3, "Foobar", 100, 3),
            new BookEntity(4, "Spring Boot", 334, null)
    ));
}
