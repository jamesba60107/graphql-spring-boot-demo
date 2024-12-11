package com.graphql.service;

import com.graphql.entity.AuthorEntity;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthorService {
    public Optional<AuthorEntity> getAuthorById(Integer id) {
        return AuthorEntity.authors.stream()
                .filter(a -> a.id().equals(id))
                .findFirst();
    }

    public AuthorEntity createAuthor(@Argument String name) {
        AuthorEntity author = new AuthorEntity(AuthorEntity.authors.size() + 1, name);
        AuthorEntity.authors.add(author);
        return author;
    }
}
