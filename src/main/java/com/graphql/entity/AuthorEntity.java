package com.graphql.entity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public record AuthorEntity(Integer id,
                     String name) {

    public static List<AuthorEntity> authors = new ArrayList<>(Arrays.asList(
            new AuthorEntity(1, "Mama Samba"),
            new AuthorEntity(2, "Jamila"),
            new AuthorEntity(3, "Allah")
    ));

    public static Optional<AuthorEntity> getAuthorById(Integer id) {
        return authors.stream()
                .filter(a -> a.id().equals(id))
                .findFirst();
    }
}
