package com.service.client.book.controller;

import com.service.client.book.client.BookClient;
import com.service.client.book.model.Book;
import lombok.RequiredArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
@RequiredArgsConstructor
public class BookGraphqlController {

    private final BookClient bookClient;

    @QueryMapping
    Flux<Book> bookDetails(@Argument Integer bookId) {
        return this.bookClient.getBookDetails(bookId);
    }
}
