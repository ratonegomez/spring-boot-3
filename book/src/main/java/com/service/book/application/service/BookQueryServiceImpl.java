package com.service.book.application.service;

import com.service.book.model.Author;
import com.service.book.model.Book;
import com.service.book.service.BookQueryService;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.List;

@Service
@Validated
public class BookQueryServiceImpl implements BookQueryService {

    private final List<Book> books=List.of(
            new Book(Book.BookId.of(1),"Batman Begins",100L,
                    new Author(Author.AuthorId.of("a"),"Christopher"," Nolan"))
    );
    @Override
    public Book getBookDetails(Integer bookId) {
        return books.stream().filter(book -> Book.BookId.of(bookId).equals(book.id()))
                .findFirst()
                .orElse(Book.UNKNOWN);
    }
}
