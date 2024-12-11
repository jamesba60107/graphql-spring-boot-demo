package com.graphql.service;

import com.graphql.entity.BookEntity;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    // 透過 id 查詢書籍
    public Optional<BookEntity> getBookById(Integer id) {
        return BookEntity.books.stream()
                .filter(b -> b.id().equals(id))
                .findFirst();
    }

    // 搜尋 id 大於指定值的書籍
    public Optional<List<BookEntity>> getBookListByIdGreaterThan(Integer id) {
        return Optional.of(BookEntity.books.stream()
                .filter(b -> b.id() > id)
                .toList());
    }

    // 搜尋 id 小於指定值的書籍
    public Optional<List<BookEntity>> getBookListByIdLessThan(@Argument("id") Integer id) {
        return Optional.of(BookEntity.books.stream()
                .filter(b -> b.id() < id)
                .toList());
    }

    // 搜尋頁數大於指定值的書籍
    public Optional<List<BookEntity>> getBookListByPageCountGreaterThan(@Argument("pageCount") Integer pageCount) {
        return Optional.of(BookEntity.books.stream()
                .filter(b -> b.pageCount() > pageCount)
                .toList());
    }

    // 搜尋頁數小於指定值的書籍
    public Optional<List<BookEntity>> getBookListByPageCountLessThan(@Argument("pageCount") Integer pageCount) {
        return Optional.of(BookEntity.books.stream()
                .filter(b -> b.pageCount() < pageCount)
                .toList());
    }

    // 創建書籍
    public BookEntity createBook(@Argument("name") String name,
                                 @Argument("pageCount") Integer pageCount,
                                 @Argument("authorId") Integer authorId) {
        BookEntity book = new BookEntity(BookEntity.books.size() + 1, name, pageCount, authorId);
        BookEntity.books.add(book);
        return book;
    }

    // 更新書籍
    public BookEntity updateBook(@Argument("id") Integer id,
                                 @Argument("name") String name,
                                 @Argument("pageCount") Integer pageCount,
                                 @Argument("authorId") Integer authorId) {
        BookEntity book = BookEntity.books.stream()
                .filter(b -> b.id().equals(id))
                .findFirst()
                .orElseThrow();

        // 創建一個新的 Book 實例，替換舊的
        BookEntity updatedBook = new BookEntity(id,
                name != null ? name : book.name(),
                pageCount != null ? pageCount : book.pageCount(),
                authorId != null ? authorId : book.authorId());

        // 更新書籍列表，替換舊的書籍
        int index = BookEntity.books.indexOf(book);
        BookEntity.books.set(index, updatedBook);

        return updatedBook;
    }
}
