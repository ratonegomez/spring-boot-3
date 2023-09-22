package com.service.book.application.controller;

import com.service.book.model.Book;
import com.service.book.service.BookQueryService;
import io.micrometer.observation.Observation;
import io.micrometer.observation.ObservationRegistry;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/books")
@ResponseBody
public class BookController {

    private final BookQueryService bookQueryService;
    private final ObservationRegistry observationRegistry;

    @GetMapping("/{bookId}")
    public Book getBookDetails(@PathVariable @NotNull Integer bookId){
        return Observation.createNotStarted(
                "by-book-id",this.observationRegistry
        ).observe(()->this.bookQueryService.getBookDetails(bookId));
    }
}
