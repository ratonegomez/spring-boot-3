package com.service.client.book.client;

import com.service.client.book.model.Book;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.service.annotation.GetExchange;
import reactor.core.publisher.Flux;

public interface BookClient {
    @GetExchange("/{bookId}")
    Flux<Book> getBookDetails(@PathVariable Integer bookId);
}
